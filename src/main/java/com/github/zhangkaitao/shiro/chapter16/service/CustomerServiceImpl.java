package com.github.zhangkaitao.shiro.chapter16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zhangkaitao.shiro.chapter16.dao.CustomerDao;
import com.github.zhangkaitao.shiro.chapter16.entity.Customer;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer findOne(Long customerId) {
		return customerDao.findOne(customerId);
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Customer findByCustomerName(String customername) {
		return customerDao.findByCustomerName(customername);
	}

	@Override
	public Customer findByCustomerNumber(String customernumber) {
		return customerDao.findByCustomerNumber(customernumber);
	}

	@Override
	public Pagination<Customer> findCustomerByParams(String param, int pageCount) {
		return customerDao.findAllByParam(param, pageCount);
	}
	
	@Override
	public Pagination<Customer> findCustomerByParams2(String param, int pageCount) {
		return customerDao.findAllByParam(param, pageCount);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		customerDao.deleteCustomer(customerId);
		
	}
}
