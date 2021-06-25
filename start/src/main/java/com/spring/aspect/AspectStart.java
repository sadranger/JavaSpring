package com.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.*;

@Aspect
public class AspectStart {
	
	
	private static String LOG_PATH = "C:\\Users\\Autobot\\Desktop\\Ranjith\\STS\\FirstApp\\start\\logs\\log.txt";
	private static String LOG_PATH2 = "C:\\Users\\Autobot\\Desktop\\Ranjith\\STS\\FirstApp\\start\\logs\\log2.txt";
	private static Logger logger = Logger.getLogger("AspectStart.class");
	
	
	@Before("getAdvice()")
	public void loggingAdvice() throws SecurityException, IOException {
		
		FileHandler handler = new FileHandler(LOG_PATH,true);
		logger.addHandler(handler);
		logger.info("test string!!");
		logger.warning("something");
		System.out.println("logged");
	}
	
	@Before("getAdvice()")
	public void loggingAdvice2() throws SecurityException, IOException {
		
		FileHandler handler = new FileHandler(LOG_PATH2,true);
		logger.addHandler(handler);
		logger.info("test string!!");
		logger.warning("something");
		System.out.println("logged");
	}
	
	@Pointcut("execution(* getKey())")
	public void getAdvice() {
		
	}

}
