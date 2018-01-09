package com.github.zhangkaitao.shiro.chapter16.dao;

import com.github.zhangkaitao.shiro.chapter16.entity.Organization;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Organization: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Organization createOrganization(final Organization organization) {
        /*final String sql = "insert into sys_organization(name, parent_id, parent_ids, available) values(?,?,?,?)";*/
    	final String sql = "insert into sys_organization(name) values(?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, organization.getName());
                /*psst.setLong(count++, organization.getParentId());
                psst.setString(count++, organization.getParentIds());
                psst.setBoolean(count++, organization.getAvailable());*/
                return psst;
            }
        }, keyHolder);
        organization.setId(keyHolder.getKey().longValue());
        return organization;
    }

    
    public Organization updateOrganization(Organization organization) {
        /*final String sql = "update sys_organization set name=?, parent_id=?, parent_ids=?, available=? where id=?";*/
    	final String sql = "update sys_organization set name=?where id=?";
        jdbcTemplate.update(
                sql,
                /*organization.getName(), organization.getParentId(), organization.getParentIds(), organization.getAvailable(), organization.getId());*/
                organization.getName(),organization.getId());
        return organization;
    }

    public void deleteOrganization(Long organizationId) {
        Organization organization = findOne(organizationId);
        final String deleteSelfSql = "delete from sys_organization where id=?";
        jdbcTemplate.update(deleteSelfSql, organizationId);
        /*final String deleteDescendantsSql = "delete from sys_organization where parent_ids like ?";
        jdbcTemplate.update(deleteDescendantsSql, organization.makeSelfAsParentIds() + "%");*/
    }


    
    public Organization findOne(Long organizationId) {
        final String sql = "select id, name, parent_id as parentId, parent_ids as parentIds, available from sys_organization where id=?";
        List<Organization> organizationList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class), organizationId);
        if(organizationList.size() == 0) {
            return null;
        }
        return organizationList.get(0);
    }

    
    public List<Organization> findAll() {
        final String sql = "select id, name, parent_id as parentId, parent_ids as parentIds, available from sys_organization";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class));
    }


	public Organization findByName(String name) {
		final String sql = "select id, name, parent_id as parentId, parent_ids as parentIds, available from sys_organization where name=?";
        List<Organization> organizationList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class), name);
        if(organizationList.size() == 0) {
            return null;
        }
        return organizationList.get(0);
	}


	public Pagination<Organization> findAllByParam(String params, int pageCount) {
		StringBuffer sb = new StringBuffer(" ");
    	String sql = "select id, name, parent_id as parentId, parent_ids as parentIds, available from sys_organization where 1=1 ";
    	sb.append(sql);
    	List<Object> list = new ArrayList<Object>();
    	if(params!=null&&!"".equals(params)){
    		sb.append(" and name like ? ");   		
        	list.add("%"+params+"%");       	
    	}
    	/*Pagination<Organization>page = new Pagination<Organization>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,Organization.class,"id");*/
    	Pagination<Organization>page = new Pagination<Organization>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,Organization.class,null);
    	return page;
	}

    
    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
        //TODO 改成not exists 利用索引
        final String sql = "select id, name, parent_id, parent_ids, available from sys_organization where id!=? and parent_ids not like ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class), excludeOraganization.getId(), excludeOraganization.makeSelfAsParentIds() + "%");
    }

    
    public void move(Organization source, Organization target) {
        String moveSourceSql = "update sys_organization set parent_id=?,parent_ids=? where id=?";
        jdbcTemplate.update(moveSourceSql, target.getId(), target.getParentIds(), source.getId());
        String moveSourceDescendantsSql = "update sys_organization set parent_ids=concat(?, substring(parent_ids, length(?))) where parent_ids like ?";
        jdbcTemplate.update(moveSourceDescendantsSql, target.makeSelfAsParentIds(), source.makeSelfAsParentIds(), source.makeSelfAsParentIds() + "%");
    }
}
