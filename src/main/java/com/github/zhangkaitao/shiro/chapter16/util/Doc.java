package com.github.zhangkaitao.shiro.chapter16.util;

import java.io.Serializable;

public class Doc implements Serializable {
	private String quest;
	private String answer;
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Doc [quest=" + quest + ", answer=" + answer + "]";
	}
	public Doc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doc(String quest, String answer) {
		super();
		this.quest = quest;
		this.answer = answer;
	}
	
}
