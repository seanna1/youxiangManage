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

import com.github.zhangkaitao.shiro.chapter16.entity.TranslateInfo;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;
@Repository
public class TranslateDaoImpl implements TranslateDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public TranslateInfo selectById(Long id) {
		 String sql = "select translate_id as id,translate_accept as accept, translate_send as send, translate_from as translateFrom,translate_to as translateTo,translate_time as translateTime from translate_info where translate_id=?";
	        List<TranslateInfo> tList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TranslateInfo.class), id);
	        if(tList.size() == 0) {
	            return null;
	        }
	        return tList.get(0);
	}

	@Override
	public void deleteById(Long id) {
		 String sql = "delete from translate_info where translate_id=?";
	      jdbcTemplate.update(sql, id);
		
	}

	@Override
	public TranslateInfo insertT(final TranslateInfo t) {
		final String sql = "insert into translate_info(translate_accept,translate_send,translate_from,translate_to,translate_time) values(?,?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, t.getAccept());
                psst.setString(count++, t.getSend());
                psst.setString(count++, t.getTranslateFrom());
                psst.setString(count++, t.getTranslateTo());
                psst.setDate(count++,new java.sql.Date(new Date().getTime()));
                return psst;
            }
        }, keyHolder);
        t.setId(keyHolder.getKey().longValue());
		return t;
	}

	@Override
	public TranslateInfo updateT(TranslateInfo t) {
		String sql = "update translate_info set translate_id=?,translate_accept=?,translate_send=?,translate_from=?,translate_to=?,translate_time=? where translate_id=?";
        jdbcTemplate.update(
                sql,
                t.getAccept(), t.getSend(), t.getTranslateFrom(),t.getTranslateTo(),t.getTranslateTime(),t.getId());
        return t;
	}

	@Override
	public Pagination<TranslateInfo> findAllByParam(String params, int pageCount) {
		StringBuffer sb = new StringBuffer(" ");
    	String sql = "select translate_id as id,translate_accept as accept, translate_send as send, translate_from as translateFrom,translate_to as translateTo,translate_time as translateTime from translate_info where 1=1 ";
    	sb.append(sql);
    	List<Object> list = new ArrayList<Object>();
    	if(params!=null&&!"".equals(params)){
    		sb.append(" and translate_accept like ? ");   		
        	list.add("%"+params+"%");       	
    	}
    	Pagination<TranslateInfo>page = new Pagination<TranslateInfo>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,TranslateInfo.class,"translate_id");
    	return page;
	}

}
