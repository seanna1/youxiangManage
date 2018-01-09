package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;
import java.sql.Date;

public class QuestionInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4243516634332532928L;
	
	private Long questionId;
	private String questionName;
	private Long qFromId;
	private Date qCreateTime;
	private String questionKeyword;
	
	
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public Long getqFromId() {
		return qFromId;
	}
	public void setqFromId(Long qFromId) {
		this.qFromId = qFromId;
	}
	public Date getqCreateTime() {
		return qCreateTime;
	}
	public void setqCreateTime(Date qCreateTime) {
		this.qCreateTime = qCreateTime;
	}
	public String getQuestionKeyword() {
		return questionKeyword;
	}
	public void setQuestionKeyword(String questionKeyword) {
		this.questionKeyword = questionKeyword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
