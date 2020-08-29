package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	//eureka  服务发现
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("dept/add")
	public boolean add(Dept dept) {
		return deptService.add(dept);
	}
//	,method = RequestMethod.GET
	@RequestMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}
	
	@RequestMapping("dept/list")
	public List<Dept> list() {
		return deptService.list();
	}
	
	@RequestMapping("dept/discovery")
	public Object discovery() {
		List<String> list=client.getServices();
		System.out.println("********"+list);
		List<ServiceInstance> serList = client.getInstances("MICROSERVICECLOUDS-DEPT");
		for (ServiceInstance element : serList) {
			System.out.println("elemetnt"+element);
			System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
		}
		return this.client;
	}
}
