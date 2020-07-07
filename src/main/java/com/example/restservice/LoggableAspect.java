package com.example.restservice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Cheranev N.
 * created on 24.06.2020.
 */
@Component
@Aspect
public class LoggableAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggableAspect.class.getName());

    @Around("@annotation(com.example.restservice.Loggable)")
    public Object loggingExecuteMethod(ProceedingJoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String className = jp.getSignature().getDeclaringTypeName();
        List<String> parameters = Arrays.stream(jp.getArgs()).map(p -> (String) p).collect(Collectors.toList());
        logger.info("Метод: {}.{}", className, methodName);
        logger.info("Параметры: {}", parameters);
        try {
            Object result = jp.proceed();
            logger.info("Результат: {}", result);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
