package com.github.zhangkaitao.shiro.chapter16.service;

import com.github.zhangkaitao.shiro.chapter16.entity.PatientFrom;



public interface PatientFromService {
	
	 public String findAll();
	 
	 public PatientFrom findOne(Long id);
	 
	 public void createPatientFrom(String name,Long pId);
	 
	 public void updatePatientFrom(String name,Long id);
	 
	 public void deletePatientFrom(Long id);
}
