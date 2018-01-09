package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8352349749455905577L;
	private Long id; //编号
    private String patientname; //病人姓名
    private String patientnumber; //病历号
    private boolean gender; //性别  0/false为女  1/true为男
    private Integer age; //年龄
    private String height; //身高 单位：cm
    private String weight; //体重 单位：kg
    private String birthday; //出生日期
    private String nation; //民族
    private String phone; //联系方式
    private Date createtime; //创建时间
	public Patient() {
		super();
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPatientnumber() {
		return patientnumber;
	}
	public void setPatientnumber(String patientnumber) {
		this.patientnumber = patientnumber;
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
	public String toString() {
		return "Patient [id=" + id + ", patientname=" + patientname
				+ ", patientnumber=" + patientnumber + ", gender=" + gender
				+ ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", birthday=" + birthday + ", nation=" + nation + ", phone="
				+ phone + ", createtime=" + createtime + "]";
	}
	public Patient(Long id, String patientname, String patientnumber,
			boolean gender, String birthday, String nation, String phone,
			Date createtime) {
		super();
		this.id = id;
		this.patientname = patientname;
		this.patientnumber = patientnumber;
		this.gender = gender;
		this.birthday = birthday;
		this.nation = nation;
		this.phone = phone;
		this.createtime = createtime;
	}
    public Patient(Long id, String patientname, String patientnumber,
			boolean gender, String height, String weight, String birthday,
			String nation, String phone, Date createtime) {
		super();
		this.id = id;
		this.patientname = patientname;
		this.patientnumber = patientnumber;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.nation = nation;
		this.phone = phone;
		this.createtime = createtime;
	}

	public Patient(Long id, String patientname, String patientnumber,
			boolean gender, Integer age, String height, String weight,
			String birthday, String nation, String phone, Date createtime) {
		super();
		this.id = id;
		this.patientname = patientname;
		this.patientnumber = patientnumber;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.nation = nation;
		this.phone = phone;
		this.createtime = createtime;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != null ? !id.equals(patient.id) : patient.id != null) return false;

        return true;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
