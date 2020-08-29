package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySefRule {
	@Bean
	public IRule myRule() {
//		return new RandomRule();//随机
		return new RandomRule_ZY();
	}
}
