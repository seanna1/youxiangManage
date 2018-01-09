package com.github.zhangkaitao.shiro.chapter16.dao;

import java.util.List;

import com.github.zhangkaitao.shiro.chapter16.entity.Customer;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

public interface CustomerDao {
	public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(Long customerId);
	
	//根据客服ID查一个
    Customer findOne(Long customerId);
    //查所有
    List<Customer> findAll();
    //根据客服姓名查询
    Customer findByCustomerName(String customerName);
    //根据病历号查询
    Customer findByCustomerNumber(String customerNumber);
    //更加姓名、分页查询
    Pagination<Customer> findAllByParam(String params,int pageCount);
    //根据病历号、分页查询
    Pagination<Customer> findAllByParam2(String params,int pageCount);
}
