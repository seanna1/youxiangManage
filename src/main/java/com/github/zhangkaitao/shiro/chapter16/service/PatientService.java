package com.github.zhangkaitao.shiro.chapter16.service;

import java.util.List;



import com.github.zhangkaitao.shiro.chapter16.entity.Patient;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

public interface PatientService {
	public Patient createPatient(Patient patient);

    public Patient updatePatient(Patient patient);

    public void deletePatient(Long patientId);


    Patient findOne(Long patientId);

    List<Patient> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public Patient findByPatientname(String patientname);
    public Patient findByPatientnumber(String patientnumber);
    
    /**
     * 分页查询后台用户
     * @param param
     * @param pageCount
     * @return
     */
    public Pagination<Patient> findPatientByParams(String param ,int pageCount);
}
