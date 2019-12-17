package com.example.multi.readwritedatasource.persistence.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.multi.readwritedatasource.routing.RoutingDataSource;


@Aspect
@Component
@Order(0)
public class WriteRouteInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(WriteRouteInterceptor.class);

	@Around("@annotation(transactional)")
	public Object proceed(ProceedingJoinPoint proceedingJoinPoint, Transactional transactional) throws Throwable {
		try {
			if (!transactional.readOnly()) {
				RoutingDataSource.setPrimaryRoute();
				logger.info("Routing database call to the primary");
			}
			return proceedingJoinPoint.proceed();
		} finally {
			RoutingDataSource.clearRoute();
		}
	}
}
