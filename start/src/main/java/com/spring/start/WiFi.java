package com.spring.start;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class WiFi implements Network, ApplicationContextAware, InitializingBean, DisposableBean, BeanNameAware {

	 //@Autowired
	private String band;
	private List<Specs> specs;
	private Specs dir615;
	private Specs dir815;
	private Specs dir650;
	private ApplicationContext applicationContext;
	private String beanName;
	
	
	public List<Specs> getSpecs() {
		return specs;
	}

	public void setSpecs(List<Specs> specs) {
		this.specs = specs;
	}

	public Specs getDir615() {
		return dir615;
	}

	public void setDir615(Specs dir615) {
		this.dir615 = dir615;
	}

	public Specs getDir815() {
		return dir815;
	}

	public void setDir815(Specs dir815) {
		this.dir815 = dir815;
	}

	public Specs getDir650() {
		return dir650;
	}

	public void setDir650(Specs dir650) {
		this.dir650 = dir650;
	}

	public String getBand() { return band; } 
		
		  public void setBand(String band) { this.band = band; }
		 
	 
	 
	
	 
	public void state() {
		
		
		  for(Specs spec: specs) { System.out.println("Properties of the " +
		  spec.getName() +"are :\n"+ "Range: "+ spec.getRange()+"\n"+ "Indicator: "+
		  spec.getIndicator() +"\n"+ "Speed: " + spec.getSpeed());
		  
		  }
		 
			/*
			 * Bluetooth b = (Bluetooth) applicationContext.getBean("bluetooth");
			 * 
			 * b.state();
			 */
		
			/*
			 * System.out.println("Properties of the " + dir615.getName() +"are :\n"+
			 * "Range: "+ dir615.getRange()+"\n"+ "Indicator: "+ dir615.getIndicator()
			 * +"\n"+ "Speed: " + dir615.getSpeed());
			 * System.out.println("Properties of the " + dir815.getName() +"are :\n"+
			 * "Range: "+ dir815.getRange()+"\n"+ "Indicator: "+ dir815.getIndicator()
			 * +"\n"+ "Speed: " + dir815.getSpeed());
			 * System.out.println("Properties of the " + dir650.getName() +"are :\n"+
			 * "Range: "+ dir650.getRange()+"\n"+ "Indicator: "+ dir650.getIndicator()
			 * +"\n"+ "Speed: " + dir650.getSpeed());
			 */
		 
		 
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(applicationContext);
		this.applicationContext = applicationContext;
		
	}

	public void destroy() throws Exception {
		System.out.println("Bean Destroyed!");
		
	}
	
	public void dest() {
		System.out.println("Destroyed!");
	}
	
	public void init() {
		System.out.println("Bean initialised!");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean Created with properties specified!");
		
	}

	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("Bean name: "+ beanName);
		
	}
}
