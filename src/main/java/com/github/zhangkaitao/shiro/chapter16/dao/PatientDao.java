package com.github.zhangkaitao.shiro.chapter16.dao;

import java.util.List;

import com.github.zhangkaitao.shiro.chapter16.entity.Patient;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;


public interface PatientDao {
	public Patient createPatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(Long patientId);

    Patient findOne(Long patientId);

    List<Patient> findAll();

    Patient findByPatientname(String patientname);
    Patient findByPatientnumber(String patientnumber);
    
    Pagination<Patient> findAllByParam(String params,int pageCount);
}
