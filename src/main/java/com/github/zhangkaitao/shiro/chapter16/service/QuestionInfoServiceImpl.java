package com.github.zhangkaitao.shiro.chapter16.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zhangkaitao.shiro.chapter16.dao.QuestionInfoDao;
import com.github.zhangkaitao.shiro.chapter16.entity.QuestionInfo;

@Service
public class QuestionInfoServiceImpl implements QuestionInfoService {
	
	@Autowired
	private QuestionInfoDao questionInfoDao;
	@Override
	public List<QuestionInfo> findAllByFormId(Long formId) {
		
		return questionInfoDao.findAllByFormId(formId);
	}
	@Override
	public QuestionInfo createQuestionInfo(String name,Long fromId) {
		QuestionInfo q= new QuestionInfo();
		q.setqFromId(fromId);
		q.setQuestionName(name);
		java.util.Date utilDate=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		q.setqCreateTime(sqlDate);
		return questionInfoDao.createQuestion(q);
	}
	@Override
	public QuestionInfo updateQuestionInfo(QuestionInfo q) {
		
		return null;
	}
	@Override
	public void deleteQuestionInfo(Long id) {
		
		questionInfoDao.deleteQuestion(id);
	}
	@Override
	public QuestionInfo findById(Long id) {
		return questionInfoDao.findById(id);
	}

}
