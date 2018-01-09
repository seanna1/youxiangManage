package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;
import java.util.Date;

public class TranslateInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2464932423422212536L;
	private Long id;
	private String accept; //接收的数据
	private String send;  //翻译后的数据
	private String translateFrom; //原始语言  en_us 英文 zh_cn 中文
	private String translateTo; //目标语言   en_us 英文 zh_cn 中文
	private Date translateTime; //翻译时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getTranslateFrom() {
		return translateFrom;
	}
	public void setTranslateFrom(String translateFrom) {
		this.translateFrom = translateFrom;
	}
	public String getTranslateTo() {
		return translateTo;
	}
	public void setTranslateTo(String translateTo) {
		this.translateTo = translateTo;
	}
	public Date getTranslateTime() {
		return translateTime;
	}
	public void setTranslateTime(Date translateTime) {
		this.translateTime = translateTime;
	}
	public TranslateInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TranslateInfo(Long id, String accept, String send,
			String translateFrom, String translateTo, Date translateTime) {
		super();
		this.id = id;
		this.accept = accept;
		this.send = send;
		this.translateFrom = translateFrom;
		this.translateTo = translateTo;
		this.translateTime = translateTime;
	}
	@Override
	public String toString() {
		return "TranslateInfo [id=" + id + ", accept=" + accept + ", send="
				+ send + ", translateFrom=" + translateFrom + ", translateTo="
				+ translateTo + ", translateTime=" + translateTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accept == null) ? 0 : accept.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((send == null) ? 0 : send.hashCode());
		result = prime * result
				+ ((translateFrom == null) ? 0 : translateFrom.hashCode());
		result = prime * result
				+ ((translateTime == null) ? 0 : translateTime.hashCode());
		result = prime * result
				+ ((translateTo == null) ? 0 : translateTo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TranslateInfo other = (TranslateInfo) obj;
		if (accept == null) {
			if (other.accept != null)
				return false;
		} else if (!accept.equals(other.accept))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (send == null) {
			if (other.send != null)
				return false;
		} else if (!send.equals(other.send))
			return false;
		if (translateFrom == null) {
			if (other.translateFrom != null)
				return false;
		} else if (!translateFrom.equals(other.translateFrom))
			return false;
		if (translateTime == null) {
			if (other.translateTime != null)
				return false;
		} else if (!translateTime.equals(other.translateTime))
			return false;
		if (translateTo == null) {
			if (other.translateTo != null)
				return false;
		} else if (!translateTo.equals(other.translateTo))
			return false;
		return true;
	}
	
	
}
