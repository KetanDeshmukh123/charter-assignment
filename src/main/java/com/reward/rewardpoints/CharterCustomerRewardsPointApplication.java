package com.reward.rewardpoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages ="com.reward")
@EntityScan(basePackages = "com.reward.entity")
@EnableJpaRepositories(basePackages = "com.reward.repository") 
public class CharterCustomerRewardsPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharterCustomerRewardsPointApplication.class, args);
	}

}
