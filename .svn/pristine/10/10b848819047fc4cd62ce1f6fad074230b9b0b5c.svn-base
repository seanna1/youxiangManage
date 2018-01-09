package com.github.zhangkaitao.shiro.chapter16.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.github.zhangkaitao.shiro.chapter16.entity.PatientFrom;
import com.github.zhangkaitao.shiro.chapter16.entity.Resource;

@Repository
public class PatientFromDaoImpl implements PatientFromDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PatientFrom> findAll() {
		final String sql ="select id,name,pid,class_type,image,href from patient_from";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(PatientFrom.class));
	}

	@Override
	public PatientFrom createPatientFrom(final PatientFrom p) {
		final String sql = "insert into patient_from(name,pid,href) values(?,?,?) ";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
	             int count = 1;
	             psst.setString(count++,p.getName());
	             psst.setLong(count++,p.getPid());
	             psst.setString(count++,p.getHref());
	             return psst;
			}          			
		}, keyHolder);
		p.setId(keyHolder.getKey().longValue());
		return p;
	}

	@Override
	public PatientFrom updatePatientFrom(PatientFrom p) {
		String sql ="update patient_from set name=? where id=? ";
		jdbcTemplate.update(sql, p.getName(),p.getId());
		return p;
	}
	
	public PatientFrom updatePatientFromHref(PatientFrom p) {
		String sql ="update patient_from set href=? where id=? ";
		jdbcTemplate.update(sql,p.getHref(),p.getId());
		return p;
	}

	@Override
	public void deletePatientFrom(Long id) {
		
		 String sql = "delete from patient_from where id=?";
	        jdbcTemplate.update(sql, id);
	}

	@Override
	public PatientFrom findOne(Long id) {
		final String sql ="select id,name,pid,class_type,image,href from patient_from where id=?";
		List<PatientFrom> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(PatientFrom.class),id);
		if(list.size() == 0) {
            return null;
        }
        return list.get(0);
	}
	

}
