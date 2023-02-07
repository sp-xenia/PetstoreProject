package it.xenia.petstore.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class TestAspect {
	
	@Autowired
	private Logger logger;
	
	@Before(value = "execution(* it.xenia.petstore.service.impl.*.*(..))")
	public void beforeUploadImage(final JoinPoint joinPoint) {
		if(logger.isInfoEnabled()) {
			logger.info("Enter: {}.{}() with argument[s] = {}",
					joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(),
					Arrays.deepToString(joinPoint.getArgs()));
		}
		String joinPointName = joinPoint.getSignature().getName();
		System.out.println(joinPointName);
	}
}
