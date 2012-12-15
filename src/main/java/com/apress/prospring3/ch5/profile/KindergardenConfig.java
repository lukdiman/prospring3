package com.apress.prospring3.ch5.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;
import com.apress.prospring3.ch5.profile.kindergarden.FoodProviderServiceImpl;

@Configuration
@Profile(value="kindergarden")
public class KindergardenConfig {
	@Bean(name="foodProviderService")
	public FoodProviderService foodProviderService() {
		return new FoodProviderServiceImpl();
	}
}
