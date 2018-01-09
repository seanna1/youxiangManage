package com.github.zhangkaitao.shiro.chapter16.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.github.zhangkaitao.shiro.chapter16.entity.Patient;
import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;
@Repository
public class PatientDaoImpl implements PatientDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	//添加
	@Override
	public Patient createPatient(final Patient patient) {
		// TODO Auto-generated method stub
		final String sql = "insert into patient_users(patient_name, patient_number, patient_gender,patient_age,patient_height,patient_weight, patient_date_of_birth, patient_nation, patient_phone,p_create_time) values(?,?,?,?,?,?,?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
           
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, patient.getPatientname());
                psst.setString(count++, patient.getPatientnumber());
                psst.setBoolean(count++, patient.getGender());
                psst.setInt(count++, patient.getAge());
                psst.setString(count++,patient.getHeight());
                psst.setString(count++,patient.getWeight());
                psst.setString(count++,  patient.getBirthday());
                psst.setString(count++, patient.getNation());
                psst.setString(count++, patient.getPhone());
                psst.setDate(count++,new java.sql.Date(new Date().getTime()) );
                return psst;
            }
        }, keyHolder);
        //psst.setLong(Long.valueOf(UUID.randomUUID().toString()).longValue(), patient.getId());
        patient.setId(keyHolder.getKey().longValue());
		return patient;
	}
	//修改
	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		String sql = "update patient_users set patient_name=?,patient_number=?, patient_gender=?,patient_age=?,patient_height=?,patient_weight=?, patient_date_of_birth=?, patient_nation=?, patient_phone=? , p_create_time=? where patient_id=?";
        jdbcTemplate.update(
                sql,
                patient.getPatientname(), patient.getPatientnumber(), patient.getGender(),patient.getAge(),patient.getHeight(),patient.getWeight(), patient.getBirthday(), patient.getNation(), patient.getPhone(),patient.getCreatetime(), patient.getId());
        return patient;
	}
	//删除
	@Override
	public void deletePatient(Long patientId) {
		// TODO Auto-generated method stub
		String sql = "delete from patient_users where patient_id=?";
        jdbcTemplate.update(sql, patientId);
	}
	//根据ID查一个
	@Override
	public Patient findOne(Long patientId) {
		// TODO Auto-generated method stub
		String sql = "select patient_id as id, patient_name as patientname, patient_number as patientnumber, patient_gender as gender,patient_age as age,patient_height as height,patient_weight as weight, patient_date_of_birth as birthday, patient_nation as nation,patient_phone as phone, p_create_time as createtime from patient_users where patient_id=?";
        List<Patient> patientList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Patient.class), patientId);
        if(patientList.size() == 0) {
            return null;
        }
        return patientList.get(0);
	}
	//查询所有
	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		String sql = "select patient_id as id , patient_name as patientname, patient_number as patientnumber, patient_gender as gender,patient_age as age,patient_height as height,patient_weight as weight, patient_date_of_birth as birthday, patient_nation as nation,patient_phone as phone, p_create_time as createtime from patient_users";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Patient.class));
	}
	//根据名字查询
	@Override
	public Patient findByPatientname(String patientname) {
		String sql = "select patient_id as id, patient_name as patientname, patient_number as patientnumber, patient_gender as gender,patient_age as age,patient_height as height,patient_weight as weight, patient_date_of_birth as birthday, patient_nation as nation,patient_phone as phone, p_create_time as createtime from patient_users where patient_name=?";
	        List<Patient> patientList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Patient.class), patientname);
	        if(patientList.size() == 0) {
	            return null;
	        }
	        return patientList.get(0);
	}
	//查询
	@Override
	public Pagination<Patient> findAllByParam(String params, int pageCount) {
		StringBuffer sb = new StringBuffer(" ");
    	String sql = "select patient_id as id, patient_name as patientname, patient_number as patientnumber, patient_gender as gender,patient_age as age, patient_height as height,patient_weight as weight, patient_date_of_birth as birthday, patient_nation as nation,patient_phone as phone, p_create_time as createtime from patient_users where 1=1 ";
    	sb.append(sql);
    	List<Object> list = new ArrayList<Object>();
    	if(params!=null&&!"".equals(params)){
    		sb.append(" and patient_name like ? ");   		
        	list.add("%"+params+"%");       	
    	}
    	Pagination<Patient>page = new Pagination<Patient>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,Patient.class,null);
    	return page;
	}
	@Override
	public Patient findByPatientnumber(String patientnumber) {
		String sql = "select patient_id as id, patient_name as patientname, patient_number as patientnumber, patient_gender as gender,patient_age as age,patient_height as height,patient_weight as weight, patient_date_of_birth as birthday, patient_nation as nation,patient_phone as phone, p_create_time as createtime from patient_users where patient_number=?";
        List<Patient> patientList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Patient.class), patientnumber);
        if(patientList.size() == 0) {
            return null;
        }
        return patientList.get(0);
	}

}
