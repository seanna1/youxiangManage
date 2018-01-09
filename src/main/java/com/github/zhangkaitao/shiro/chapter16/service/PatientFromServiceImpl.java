package com.github.zhangkaitao.shiro.chapter16.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zhangkaitao.shiro.chapter16.dao.PatientFromDao;
import com.github.zhangkaitao.shiro.chapter16.entity.PatientFrom;

@Service
public class PatientFromServiceImpl implements PatientFromService {
	
	@Autowired
	private PatientFromDao patientFromDao;
	
	@Override
	public String findAll() {				
		JSONArray array = new JSONArray();				
		List<PatientFrom> list = patientFromDao.findAll();
		for(PatientFrom p:list){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id",p.getId());
			jsonObject.put("name",p.getName());
			jsonObject.put("pId",p.getPid());
			jsonObject.put("url",p.getHref());
			jsonObject.put("target","content");
			array.add(jsonObject);
		}
		return array.toString();
	}
	
	 public PatientFrom findOne(Long id){
		 return patientFromDao.findOne(id);
	 }

	@Override
	public void createPatientFrom(String name, Long pId) {
		PatientFrom p = new PatientFrom();
		p.setName(name);
		p.setPid(pId);
		//if(pId>1)p.setHref("formInput/selectquestInfo?formid=");
		PatientFrom pa=patientFromDao.createPatientFrom(p);
		if(pId>1){
			pa.setHref("formInput/selectquestInfo?formid="+pa.getId());
			patientFromDao.updatePatientFromHref(pa);
		}
		
	}

	@Override
	public void updatePatientFrom(String name, Long id) {
		PatientFrom p = new PatientFrom();
		p.setName(name);
		p.setId(id);
		patientFromDao.updatePatientFrom(p);
	}

	@Override
	public void deletePatientFrom(Long id) {
		patientFromDao.deletePatientFrom(id);		
	}

}
