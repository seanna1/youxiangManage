package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.zhangkaitao.shiro.chapter16.entity.AnswerInfo;
import com.github.zhangkaitao.shiro.chapter16.entity.QuestionInfo;
import com.github.zhangkaitao.shiro.chapter16.service.AnswerInfoService;
import com.github.zhangkaitao.shiro.chapter16.service.PatientFromService;
import com.github.zhangkaitao.shiro.chapter16.service.QuestionInfoService;
import com.github.zhangkaitao.shiro.chapter16.util.StringUtil;

@Controller
@RequestMapping("/formInput")
public class QuestionInfoController {

	@Autowired
	private QuestionInfoService questionInfoService;
	@Autowired
	private PatientFromService patientFromService;

	@RequiresPermissions("formInput:view")
	@RequestMapping(value = "/selectquestInfo",method = {RequestMethod.GET,RequestMethod.POST})
	public String list(@RequestParam(value="formid")Long formid,
			Model model) {
		model.addAttribute("from", patientFromService.findOne(formid));
		model.addAttribute("list", questionInfoService.findAllByFormId(formid));
		return "formInput/pl";
	}
	
	@RequiresPermissions("formInput:create")
	@RequestMapping(value = "/createquestInfo",method = {RequestMethod.GET,RequestMethod.POST})
	public String createQuestionInfo(@RequestParam(value="formid")Long formId,
			@RequestParam(value="questionname")String name,
			Model model) {
		questionInfoService.createQuestionInfo(name, formId);
		return "redirect:/formInput/selectquestInfo?formid="+formId;
	}
	
	@RequiresPermissions("formInput:create")
	@RequestMapping(value = "/deletequestInfo",method = {RequestMethod.GET,RequestMethod.POST})
	public String deleteQuestionInfo(@RequestParam(value="formid")Long formId,
			@RequestParam(value="questionId")Long questionId,
			Model model) {
		questionInfoService.deleteQuestionInfo(questionId);
		return "redirect:/formInput/selectquestInfo?formid="+formId;
	}

}
