package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod="processHystrix_Get") 
	public Dept get(@PathVariable("id") Long id) {
		Dept dept =this.deptService.get(id);
		if(null == dept) {
			throw new RuntimeException("该ID"+id+"没有没有对应的信息");
		}
		return dept;
	}
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID"+id+"没有没有对应的信息，null --@HystrixCommand");
	}
}
