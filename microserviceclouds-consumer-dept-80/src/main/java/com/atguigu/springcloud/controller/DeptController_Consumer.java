package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	//
	@Autowired
	private RestTemplate restTemplate;
	//调第一个启动服务的地址 测试
//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	/**ribbon 使用服务名称 eureka **/
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUDS-DEPT";
	
	@RequestMapping("consumer/dept/add")
	public boolean add(Dept dept) {
		//
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@RequestMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		//
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("consumer/dept/list")
	public List<Dept> list() {
		//
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
	
	//服务发现
	@RequestMapping("consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
}
