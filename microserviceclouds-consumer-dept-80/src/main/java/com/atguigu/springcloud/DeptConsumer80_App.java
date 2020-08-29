package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySefRule;

@SpringBootApplication
@EnableEurekaClient/**ribbon 中使用**/
//在启动该微服务的时候就能去加载我的自定义Ribbon配置类，从而快配置生效
//@RibbonClient(name = "MICROSERVICECLOUDS-DEPT",configuration = MySefRule.class)
//自定义才会加 ribbon
@RibbonClient(name = "MICROSERVICECLOUDS-DEPT",configuration = MySefRule.class)
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
