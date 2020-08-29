package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced/**ribbon 负载均衡 Ribbon客户端  Netflix**/
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	//默认轮询RoundRobinRule
	
	@Bean
	public IRule myRule() {
//		return new RoundRobinRule();//轮询
		return new RandomRule();//随机
//		return new AvailabilityFilteringRule();
//		return new WeightedResponseTimeRule();
//		return new RetryRule();
//		return new BestAvailableRule();
//		return new ZoneAvoidanceRule();
	}
}
