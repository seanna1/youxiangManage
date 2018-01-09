package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;
import java.util.Date;

public class AnswerInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3157181538737146969L;
	private Long id;
    private String userid; //用户id
    private String questionid; //问题id
    private String keyword; //答案
    private Date createtime; //录入时间

	@Override
	public String toString() {
		return "AnswerInfo [id=" + id + ", userid=" + userid + ", questionid="
				+ questionid + ", keyword=" + keyword + ", createtime="
				+ createtime + "]";
	}

	public AnswerInfo(Long id, String userid, String questionid, String keyword,
			Date createtime) {
		super();
		this.id = id;
		this.userid = userid;
		this.questionid = questionid;
		this.keyword = keyword;
		this.createtime = createtime;
	}

	public AnswerInfo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerInfo answerInfo = (AnswerInfo) o;

        if (id != null ? !id.equals(answerInfo.id) : answerInfo.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
