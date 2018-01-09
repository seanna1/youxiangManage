package com.github.zhangkaitao.shiro.chapter16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zhangkaitao.shiro.chapter16.dao.PatientDao;
import com.github.zhangkaitao.shiro.chapter16.entity.Patient;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private PasswordHelper passwordHelper;
	
	@Override
    /**
     * 创建用户
     * @param Patient
     */
	public Patient createPatient(Patient patient) {
		
        return patientDao.createPatient(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.updatePatient(patient);
	}

	@Override
	public void deletePatient(Long patientId) {
		// TODO Auto-generated method stub
		patientDao.deletePatient(patientId);
	}

	@Override
	public Patient findOne(Long patientId) {
		// TODO Auto-generated method stub
		return patientDao.findOne(patientId);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientDao.findAll();
	}

	@Override
	public Patient findByPatientname(String patientname) {
		// TODO Auto-generated method stub
		return patientDao.findByPatientname(patientname);
	}

	@Override
	public Pagination<Patient> findPatientByParams(String param, int pageCount) {
		// TODO Auto-generated method stub
		return patientDao.findAllByParam(param, pageCount);
	}

	@Override
	public Patient findByPatientnumber(String patientnumber) {
		// TODO Auto-generated method stub
		return patientDao.findByPatientnumber(patientnumber);
	}

}
