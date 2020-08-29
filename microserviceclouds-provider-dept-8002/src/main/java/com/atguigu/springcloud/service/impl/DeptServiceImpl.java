package com.atguigu.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptDao deptdao;
	@Override
	public boolean add(Dept dept) {
		return deptdao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		if(deptdao.findById(id)== null) {
			System.out.println("错误");
		}
		return deptdao.findById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		List<Dept> list=deptdao.findAll();
		if(list==null || list.size()==0) {
			System.out.println("错误");
		}
		return list;
	}

}
