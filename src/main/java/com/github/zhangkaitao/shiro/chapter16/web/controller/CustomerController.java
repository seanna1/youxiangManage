package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.zhangkaitao.shiro.chapter16.entity.Customer;
import com.github.zhangkaitao.shiro.chapter16.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//根据“姓名”、分页查询
	//@RequiresPermissions("customer:view") //加上分页出不来
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
    public String listCustomer(@RequestParam(value="params",required=false)String params,
    		@RequestParam(value="pageCount",required=false,defaultValue="1")Integer pageCount,
    		Model model) {
        model.addAttribute("customerList", customerService.findCustomerByParams(params, pageCount)); 
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("params", params);
        model.addAttribute("params", map);
        return "customerService/customer";
    }
	
	//验证病历号是否可用
	//@RequiresPermissions("customer:create")
	@RequestMapping(value = "/selectcustomernumber", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object showCreateForms(String customernumber) {
    	if(customernumber==null || "".equals(customernumber))
    		return "2";
    	Customer c=customerService.findByCustomerNumber(customernumber);
    	if(c==null){
    		return "1";
    	}else{
    		return "0";
    	}      
    }
  	//@RequiresPermissions("customer:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer customer, RedirectAttributes redirectAttributes) {
  		customerService.createCustomer(customer);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/customer";
    }
  	
  	//@RequiresPermissions("customer:create")
    @RequestMapping(value = "/createcustomer", method = RequestMethod.POST)
    public String showCreateForms(Long id,String customernumber,String customername,String gender,String height,String weight,
    					String birthday,String nation,String phone,RedirectAttributes redirectAttributes) {
  		Customer customer = new Customer();
  		customer.setId(id);
  		customer.setNumber(customernumber);
  		customer.setName(customername);
  		if("男".equals(gender)){
  			customer.setGender(true);
  		}else if("女".equals(gender)){
  			customer.setGender(false);
  		}else{
  			customer.setGender(true);
  		}
  		customer.setHeight(height);
  		customer.setWeight(weight);
  		customer.setBirthday(birthday);
  		customer.setNation(nation);
  		customer.setPhone(phone);
  		customerService.createCustomer(customer);
  		redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/customer";
    }   
  	
  	//@RequiresPermissions("customer:update")
    @RequestMapping(value = "/selectupdateCustomer",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.POST,RequestMethod.GET})
  	@ResponseBody
    public String updateCus(Long id, Model model) {
  		Customer c = customerService.findOne(id);
  		JSONObject jo= new JSONObject();
        jo.put("id", c.getId());
        jo.put("customernumber",c.getNumber());
        jo.put("customername", c.getName());
        jo.put("gender", c.getGender());
        jo.put("height", c.getHeight());
        jo.put("weight", c.getWeight());
        jo.put("birthday", c.getBirthday());
        jo.put("nation", c.getNation());
        jo.put("phone", c.getPhone());
        return jo.toString();
    }
    //@RequiresPermissions("customer:update")
    @RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
    public String updateCustomers(Long id,String customernumber,String customername
    						,String gender,String height,String weight,String birthday,String nation,String phone
    						,RedirectAttributes redirectAttributes) {
    	Customer c = customerService.findOne(id);
  		c.setId(id);
  		c.setNumber(customernumber);
  		c.setName(customername);
  		if("男".equals(gender)){
  			c.setGender(true);
  		}else{
  			c.setGender(false);
  		}
  		c.setHeight(height);
  		c.setWeight(weight);
  		c.setBirthday(birthday);
  		c.setNation(nation);
  		c.setPhone(phone);
  		customerService.updateCustomer(c);
  		redirectAttributes.addFlashAttribute("msg", "修改成功");
    	return "redirect:/customer";
    }
    //@RequiresPermissions("customer:delete")
    @RequestMapping(value = "/deleteCustomerById", method = {RequestMethod.POST,RequestMethod.GET})
  	public String deleteCustomers(Long id, RedirectAttributes redirectAttributes) {
    	customerService.deleteCustomer(id);
        return "redirect:/customer";
    }
    //@RequiresPermissions("customer:delete")
    @RequestMapping(value = "/deletecustomer", method = {RequestMethod.POST,RequestMethod.GET})
  	public String deleteCus(String id, RedirectAttributes redirectAttributes) {
    	String [] ids= id.split(",");
    	for(String i:ids){
    		customerService.deleteCustomer(Long.parseLong(i));
    	}     
        return "redirect:/customer";
    }
    
	
/*	//根据“病历号”、分页查询
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
    public String list(@RequestParam(value="param",required=false)String param,
    		@RequestParam(value="pageCount",required=false,defaultValue="1")Integer pageCount,
    		Model model) {
        model.addAttribute("list", customerService.findCustomerByParams(param, pageCount)); 
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("param", param);
        model.addAttribute("param", map);
        return "customerService/customer";
    }*/
}
