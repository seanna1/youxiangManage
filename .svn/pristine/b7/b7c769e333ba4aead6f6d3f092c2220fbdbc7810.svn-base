package com.github.zhangkaitao.shiro.chapter16.service;

import java.util.List;

import com.github.zhangkaitao.shiro.chapter16.entity.Customer;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

public interface CustomerService {
	public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(Long customerId);
	
	Customer findOne(Long customerId);
    List<Customer> findAll();
    //根据姓名查询
    public Customer findByCustomerName(String customername);
    //根据病历号查询
    public Customer findByCustomerNumber(String customernumber);
    /**
     * 分页查询后台用户
     * @param param
     * @param pageCount
     * @return
     */
    //根据姓名、分页查询
    public Pagination<Customer> findCustomerByParams(String param ,int pageCount);
    //根据病历号、分页查询
    public Pagination<Customer> findCustomerByParams2(String param ,int pageCount);
}
