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

import com.github.zhangkaitao.shiro.chapter16.entity.QuestionInfo;


@Repository
public class QuestionInfoDaoImpl implements QuestionInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public List<QuestionInfo> findAllByFormId(Long formId) {
		
		final String sql = "select question_id,question_name,q_from_id from question_info where q_from_id =?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(QuestionInfo.class),formId);
	}

	@Override
	public QuestionInfo updateQuestion(QuestionInfo q) {
		
		return null;
	}

	@Override
	public QuestionInfo createQuestion(final QuestionInfo q) {
		final String sql = "insert into question_info(question_name,q_from_id,q_create_time) values(?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			 public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				   PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
				   int count = 1;
				   psst.setString(count++, q.getQuestionName());
				   psst.setLong(count++, q.getqFromId());
				   psst.setDate(count++, q.getqCreateTime());
				   return psst;
			 }
		}, keyHolder);
		q.setQuestionId(keyHolder.getKey().longValue());
		return q;
	}

	@Override
	public void deleteQuestion(Long id) {
		 String sql = "delete from question_info where question_id=?";
	        jdbcTemplate.update(sql, id);
	}

	@Override
	public QuestionInfo findById(Long id) {
		final String sql = "select question_id as questionId,question_name as questionName,q_from_id as qFromId,q_create_time as qCreateTime,question_keyword as questionKeyword from question_info where question_id =?";
        List<QuestionInfo> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(QuestionInfo.class),id);
        if(list.size() == 0) {
            return null;
        }
        return list.get(0);
	}

}
