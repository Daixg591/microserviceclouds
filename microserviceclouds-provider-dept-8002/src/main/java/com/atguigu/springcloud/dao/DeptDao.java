package com.atguigu.springcloud.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entities.Dept;

@Mapper
public interface DeptDao {
	int delete(Long deptno);
	
	public boolean addDept(Dept dept);

	public Dept findById(Long deptno);

	public List<Dept> findAll();
}
