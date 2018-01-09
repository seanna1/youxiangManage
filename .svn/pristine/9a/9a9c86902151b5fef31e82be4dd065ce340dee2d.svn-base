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

import com.github.zhangkaitao.shiro.chapter16.entity.Customer;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

@Repository
public  class CustomerDaoImpl implements CustomerDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Customer findOne(Long customerId) {
		String sql = "select customer_id as id, customer_number as number, customer_name as name, customer_gender as gender,customer_height as height,customer_weight as weight, customer_date_of_birth as birthday, customer_nation as nation,customer_phone as phone, customer_createtime as createtime from customer_users where customer_id=?";
        List<Customer> customerList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class), customerId);
        if(customerList.size() == 0) {
            return null;
        }
        return customerList.get(0);
	}

	@Override
	public List<Customer> findAll() {
		String sql = "select customer_id as id, customer_number as number, customer_name as name, customer_gender as gender,customer_height as height,customer_weight as weight, customer_date_of_birth as birthday, customer_nation as nation,customer_phone as phone, customer_createtime as createtime from customer_users";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));
	}
	
	@Override
	public Customer findByCustomerName(String customerName){
		String sql = "select customer_id as id, customer_number as number, customer_name as name, customer_gender as gender,customer_height as height,customer_weight as weight, customer_date_of_birth as birthday, customer_nation as nation,customer_phone as phone, customer_createtime as createtime from customer_users where customer_name=?";
        List<Customer> customerList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class), customerName);
        if(customerList.size() == 0) {
            return null;
        }
        return customerList.get(0);
	}
	
	@Override
	public Customer findByCustomerNumber(String customerNumber) {
		String sql = "select customer_id as id, customer_number as number, customer_name as name, customer_gender as gender,customer_height as height,customer_weight as weight, customer_date_of_birth as birthday, customer_nation as nation,customer_phone as phone, customer_createtime as createtime from customer_users where customer_number=?";
        List<Customer> customerList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class), customerNumber);
        if(customerList.size() == 0) {
            return null;
        }
        return customerList.get(0);
	}

	@Override
	public Pagination<Customer> findAllByParam(String params, int pageCount) {
		StringBuffer sb = new StringBuffer(" ");
    	String sql = "select customer_id as id, customer_number as number, customer_name as name, customer_gender as gender,customer_height as height,customer_weight as weight, customer_date_of_birth as birthday, customer_nation as nation,customer_phone as phone, customer_createtime as createtime from customer_users  where 1=1 ";
    	sb.append(sql);
    	List<Object> list = new ArrayList<Object>();
    	if(params!=null&&!"".equals(params)){
    		sb.append(" and customer_name like ? ");   		
        	list.add("%"+params+"%");       	
    	}
    	Pagination<Customer>page = new Pagination<Customer>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,Customer.class,null);
    	return page;
	}

	@Override
	public Pagination<Customer> findAllByParam2(String params, int pageCount) {
		StringBuffer sb = new StringBuffer(" ");
    	String sql = "select customer_id as id, customer_number as number, customer_name as name, customer_gender as gender,customer_height as height,customer_weight as weight, customer_date_of_birth as birthday, customer_nation as nation,customer_phone as phone, customer_createtime as createtime from customer_users  where 1=1 ";
    	sb.append(sql);
    	List<Object> list = new ArrayList<Object>();
    	if(params!=null&&!"".equals(params)){
    		sb.append(" and customer_number like ? ");   		
        	list.add("%"+params+"%");       	
    	}
    	Pagination<Customer>page = new Pagination<Customer>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,Customer.class,null);
    	return page;
	}

	@Override
	public Customer createCustomer(final Customer customer) {
		final String sql = "insert into customer_users(customer_number, customer_name,customer_gender,customer_height,customer_weight, customer_date_of_birth, customer_nation,customer_phone,customer_createtime) values(?,?,?,?,?,?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, customer.getNumber());
                psst.setString(count++, customer.getName());
                psst.setBoolean(count++, customer.getGender());
                psst.setString(count++, customer.getHeight());
                psst.setString(count++, customer.getWeight());
                psst.setString(count++,  customer.getBirthday());
                psst.setString(count++, customer.getNation());
                psst.setString(count++, customer.getPhone());
                psst.setDate(count++,new java.sql.Date(new Date().getTime()) );
                return psst;
            }
        }, keyHolder);
        //psst.setLong(Long.valueOf(UUID.randomUUID().toString()).longValue(), patient.getId());
        customer.setId(keyHolder.getKey().longValue());
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		String sql = "update customer_users set customer_number=?,customer_name=?,customer_gender=?,customer_height=?,customer_weight=?,customer_date_of_birth=?, customer_nation=?, customer_phone=? ,customer_createtime=? where customer_id=?";
        jdbcTemplate.update(
                sql,
                customer.getNumber(), customer.getName(), customer.getGender(),customer.getHeight(),customer.getWeight(), customer.getBirthday(), customer.getNation(), customer.getPhone(),customer.getCreatetime(), customer.getId());
        return customer;
	}

	@Override
	public void deleteCustomer(Long customerId) {
		String sql = "delete from customer_users where customer_id=?";
        jdbcTemplate.update(sql, customerId);
	}
}
