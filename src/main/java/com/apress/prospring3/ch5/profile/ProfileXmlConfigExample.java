package com.apress.prospring3.ch5.profile;

import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileXmlConfigExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.getEnvironment().setActiveProfiles("highschool");
		ctx.load("classpath:profile/*-config.xml");
		ctx.refresh();
		
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		
		for (Food food : lunchSet) {
			System.out.println("Food: " + food.getName());
		}
	}
}
