package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.zhangkaitao.shiro.chapter16.service.PatientFromService;


@Controller
@RequestMapping("/formInput")
public class PatientFromController {
	
	@Autowired
	private PatientFromService patientFromService;
	
	    @RequiresPermissions("formInput:view")
	    @RequestMapping(method = RequestMethod.GET)
	    public String list(@RequestParam(value="id")Long id,   		
	    		Model model) {
	        model.addAttribute("id", id);
	        return "formInput/formInput";
	    }
	    
	    @RequiresPermissions("formInput:view")
	    @RequestMapping(produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
	    @ResponseBody
	    public Object listAll(Model model) {	
	    	 model.addAttribute("from", patientFromService.findAll());
	        return  patientFromService.findAll();
	    }
	    
	    @RequiresPermissions("formInput:create")
	    @RequestMapping(value = "/addPatientFrom",method = {RequestMethod.POST})
	    public String addPatientFrom(Long pId,String name){
	    	try {
				name = URLDecoder.decode(name,"utf-8");
				patientFromService.createPatientFrom(name, pId);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	    	return "redirect:/formInput";
	    }
	    
	    @RequiresPermissions("formInput:create")
	    @RequestMapping(value = "/updatePatientFrom",method = {RequestMethod.POST})
	    public String updatePatientFrom(Long id,String name){
	    	try {
				name = URLDecoder.decode(name,"utf-8");
				patientFromService.updatePatientFrom(name, id);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	    	return "redirect:/formInput";
	    }
	    
	    @RequiresPermissions("formInput:delete")
	    @RequestMapping(value = "/deletePatientFrom",method = {RequestMethod.POST,RequestMethod.GET})
	    public String deletePatientFrom(Long id,String name){	    	
			patientFromService.deletePatientFrom(id);			
	    	return "redirect:/formInput";
	    }
}
