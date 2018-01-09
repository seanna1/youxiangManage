package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

import com.github.zhangkaitao.shiro.chapter16.entity.Patient;
import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.service.OrganizationService;
import com.github.zhangkaitao.shiro.chapter16.service.PatientService;
import com.github.zhangkaitao.shiro.chapter16.service.RoleService;
import com.github.zhangkaitao.shiro.chapter16.util.StringUtil;

@Controller
@RequestMapping("/patient")
public class PatientController {
	  @Autowired
	  private PatientService patientService;

	  @RequiresPermissions("clientele:view")
	  @RequestMapping(method = RequestMethod.GET)
	    public String lists(@RequestParam(value="params",required=false)String params,
	    		@RequestParam(value="pageCount",required=false,defaultValue="1")Integer pageCount,
	    		Model model) {
	        model.addAttribute("patientList", patientService.findPatientByParams(params, pageCount)); 
	        Map<String,Object> map= new HashMap<String,Object>();
	        map.put("params", params);
	        model.addAttribute("params", map);
	        return "users/account";
	    }

	    /**
	     * 验证病历号是否可用
	     * @param name
	     * @return
	     */
	    @RequiresPermissions("clientele:create")
	    @RequestMapping(value = "/selectpatientnumber", method = RequestMethod.POST)
	    @ResponseBody
	    public Object showCreateForm(String patientnumber) {
	    	if(patientnumber==null || "".equals(patientnumber))
	    		return "2";
	    	Patient p=patientService.findByPatientnumber(patientnumber);
	    	if(p==null){
	    		return "1";
	    	}else{
	    		return "0";
	    	}      
	    }
	  
	  	@RequiresPermissions("clientele:create")
	    @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public String create(Patient patient, RedirectAttributes redirectAttributes) {
	        patientService.createPatient(patient);
	        redirectAttributes.addFlashAttribute("msg", "新增成功");
	        return "redirect:/patient";
	    }
	  	
	  	@RequiresPermissions("clientele:create")
	    @RequestMapping(value = "/createpatient", method = RequestMethod.POST)
	    public String showCreateForm(Long id,String patientnumber,String patientname,String gender,String height,String weight,
	    					String birthday,String nation,String phone,RedirectAttributes redirectAttributes) {
	  		Patient patient = new Patient();
	  		patient.setId(id);
	  		patient.setPatientnumber(patientnumber);
	  		patient.setPatientname(patientname);
	  		if("男".equals(gender)){
	  			patient.setGender(true);
	  		}else if("女".equals(gender)){
	  			patient.setGender(false);
	  		}else{
	  			patient.setGender(true);
	  		}
	  		
	  		patient.setHeight(height);
	  		patient.setWeight(weight);
	  		patient.setBirthday(birthday);
	  		Date date;
			try {
				date = StringUtil.stringToDate2(birthday);
				//由出生日期获得年龄***  
	  			int age = StringUtil.getAgeByBirth(date);
	  			patient.setAge(age);
		  		patient.setNation(nation);
		  		patient.setPhone(phone);
		  		patientService.createPatient(patient);
		  		redirectAttributes.addFlashAttribute("msg", "新增成功");
		        return "redirect:/patient";
			} catch (ParseException e) {
				e.printStackTrace();
			}
  			return "welcome";
	    }    
	  	
	  	@RequiresPermissions("clientele:update")
	    @RequestMapping(value = "/selectupdatePatient",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.POST,RequestMethod.GET})
	  	@ResponseBody
	    public String update(Long id, Model model) {
	  		model.addAttribute("pid",id);
	  		Patient p = patientService.findOne(id);
	  		JSONObject jo= new JSONObject();
	        jo.put("id", p.getId());
	        jo.put("patientnumber",p.getPatientnumber());
	        jo.put("patientname", p.getPatientname());
	        jo.put("gender", p.getGender());
	        jo.put("age", p.getAge());
	        jo.put("height",p.getHeight());
	        jo.put("weight",p.getWeight());
	        jo.put("birthday", p.getBirthday());
	        jo.put("nation", p.getNation());
	        jo.put("phone", p.getPhone());
	        Date createtime = p.getCreatetime();
	        String[] split = createtime.toString().split(" ");
	        String str = split[0];
	        jo.put("createTime", str);
	        return jo.toString();
	    }
	  	
	    @RequiresPermissions("clientele:update")
	    @RequestMapping(value = "/updatepatient", method = RequestMethod.POST)
	    public String updatePatient(Long id,String patientnumber,String patientname,String gender,String height,String weight,
	    				String birthday,String nation,String phone,RedirectAttributes redirectAttributes) {
	    	Patient p = patientService.findOne(id);
	  		p.setId(id);
	  		p.setPatientnumber(patientnumber);
	  		p.setPatientname(patientname);
	  		if("男".equals(gender)){
	  			p.setGender(true);
	  		}else{
	  			p.setGender(false);
	  		}
	  		p.setHeight(height);
	  		p.setWeight(weight);
	  		p.setBirthday(birthday);
	  		try {  
	  			Date date = StringUtil.stringToDate2(birthday);
	  			//由出生日期获得年龄***  
	  			int age = StringUtil.getAgeByBirth(date);
	  			p.setAge(age);
	  			p.setNation(nation);
		  		p.setPhone(phone);
		  		patientService.updatePatient(p);
		  		redirectAttributes.addFlashAttribute("msg", "修改成功");
		    	return "redirect:/patient";
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
	  		return "welcome";
	    }
	    
	    @RequiresPermissions("clientele:delete")
	    @RequestMapping(value = "/deletePatientById", method = {RequestMethod.POST,RequestMethod.GET})
	  	public String deletePatient(Long id, RedirectAttributes redirectAttributes) {
	    	patientService.deletePatient(id);
	        return "redirect:/patient";
	    }

	    @RequiresPermissions("clientele:delete")
	    @RequestMapping(value = "/deletepatient", method = {RequestMethod.POST,RequestMethod.GET})
	  	public String delete(String id, RedirectAttributes redirectAttributes) {
	    	String [] ids= id.split(",");
	    	for(String i:ids){
	    		patientService.deletePatient(Long.parseLong(i));
	    	}     
	        return "redirect:/patient";
	    }
	   
}
