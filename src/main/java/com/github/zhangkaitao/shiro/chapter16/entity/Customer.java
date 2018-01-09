package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3681676230939491663L;
	private Long id; //编号
    private String number; //病历号
    private String name; //病人姓名
    private boolean gender; //性别
    private String height; //身高 单位：cm
    private String weight; //体重 单位：kg
    private String birthday; //出生日期
    private String nation; //民族
    private String phone; //联系方式
    private Date createtime; //创建时间
    
    
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long id, String number, String name, boolean gender,
			String birthday, String nation, String phone, Date createtime) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.nation = nation;
		this.phone = phone;
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", number=" + number + ", name=" + name
				+ ", gender=" + gender + ", height=" + height + ", weight="
				+ weight + ", birthday=" + birthday + ", nation=" + nation
				+ ", phone=" + phone + ", createtime=" + createtime + "]";
	}
	
	public Customer(Long id, String number, String name, boolean gender,
			String height, String weight, String birthday, String nation,
			String phone, Date createtime) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.nation = nation;
		this.phone = phone;
		this.createtime = createtime;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
