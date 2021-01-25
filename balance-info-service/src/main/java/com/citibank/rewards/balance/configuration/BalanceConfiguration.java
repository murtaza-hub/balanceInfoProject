package com.citibank.rewards.balance.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configurable
@EnableWebMvc
@ComponentScan(basePackages = "com.citibank.rewards.balance.controller")
public class BalanceConfiguration {
	public BalanceConfiguration() {
		System.out.println("Configure++++++++++");
	}
}
