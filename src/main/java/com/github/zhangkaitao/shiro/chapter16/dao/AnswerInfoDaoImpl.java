package com.github.zhangkaitao.shiro.chapter16.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.github.zhangkaitao.shiro.chapter16.entity.AnswerInfo;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;
@Repository
public class AnswerInfoDaoImpl implements AnswerInfoDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void deleteById(Long id) {
		String sql = "delete from answer_info where answer_id=?";
        jdbcTemplate.update(sql, id);
	}

	@Override
	public AnswerInfo insert(final AnswerInfo answerInfo) {
		final String sql = "insert into answer_info(answer_user_id,answer_question_id,answer_keyword,answer_createtime) values(?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, answerInfo.getUserid());
                psst.setString(count++, answerInfo.getQuestionid());
                psst.setString(count++, answerInfo.getKeyword());
                psst.setDate(count++,new java.sql.Date(new Date().getTime()));
                return psst;
            }
        }, keyHolder);
        answerInfo.setId(keyHolder.getKey().longValue());
		return answerInfo;
	}

	@Override
	public AnswerInfo selectById(Long id) {
		 String sql = "select answer_id,answer_user_id, answer_question_id, answer_keyword,answer_createtime from answer_info where answer_id=?";
	        List<AnswerInfo> aList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(AnswerInfo.class), id);
	        if(aList.size() == 0) {
	            return null;
	        }
	        return aList.get(0);
	}

	@Override
	public AnswerInfo update(AnswerInfo a) {
		String sql = "update answer_info set answer_user_id=?,answer_question_id=?,answer_keyword=?,answer_createtime=? where answer_id=?";
        jdbcTemplate.update(
                sql,
                a.getUserid(), a.getQuestionid(), a.getKeyword(), a.getCreatetime(), a.getId());
        return a;
	}

	@Override
	public AnswerInfo findAnswerByUidAndQidAndCtime(Long uid, Long qid,String ctime) {
		String sql = "select answer_id as id,answer_user_id as userid, answer_question_id as questionid, answer_keyword as keyword,answer_createtime as createtime from answer_info  where answer_user_id=? and answer_question_id=? and answer_createtime like ?";
        List<AnswerInfo> aList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(AnswerInfo.class),uid,qid,ctime);
        if(aList.size() == 0) {
            return null;
        }
        return aList.get(0);
	}

	@Override
	public Pagination<AnswerInfo> findAllByParam(String params, int pageCount) {
		StringBuffer sb = new StringBuffer(" ");
    	String sql = "select answer_id, answer_question_id, answer_keyword, answer_createtiome from answer_info where 1=1 ";
    	sb.append(sql);
    	List<Object> list = new ArrayList<Object>();
    	if(params!=null&&!"".equals(params)){
    		sb.append(" and answer_createtime like ? ");   		
        	list.add("%"+params+"%");       	
    	}
    	Pagination<AnswerInfo>page = new Pagination<AnswerInfo>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,AnswerInfo.class,"id");
    	return page;
	}

}
