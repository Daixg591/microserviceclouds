package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.springcloud.entities.Dept;

//feign 后添加的包
//@FeignClient(value = "MICROSERVICECLOUDS-DEPT")
//40 视频
@FeignClient(value = "MICROSERVICECLOUDS-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id);
	
	@RequestMapping("/dept/list")
	public List<Dept> list(); 
	
	@RequestMapping("/dept/add")
	public boolean add(Dept dept); 
	
	
}
