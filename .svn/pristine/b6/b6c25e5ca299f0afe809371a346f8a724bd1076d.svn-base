package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;

public class Robot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4341784768063262465L;
	private String id; //编号
    private String robotname; //机器人名
    private int robotrole; //1客服 2表单录入
    private String robotaddr;//楼层
    private String robotcount;//数量
    private String robotpwd; //密码
    private String robotstatus; // 运行状态： 1 上线 ，  2 下线
    private String robotuserid; //绑定的用户ID
    private String  robotuse; //使用状态：1可用 ，2不可用
    private String robotusername; //绑定的用户名字
	
	@Override
	public String toString() {
		return "Robot [id=" + id + ", robotname=" + robotname + ", robotrole="
				+ robotrole + ", robotaddr=" + robotaddr + ", robotcount="
				+ robotcount + ", robotpwd=" + robotpwd + ", robotstatus="
				+ robotstatus + ", robotuserid=" + robotuserid + ", robotuse="
				+ robotuse + ", robotusername=" + robotusername + "]";
	}

	public Robot(String id, String robotname, int robotrole, String robotaddr,
			String robotcount, String robotpwd, String robotstatus,
			String robotuserid, String robotuse, String robotusername) {
		super();
		this.id = id;
		this.robotname = robotname;
		this.robotrole = robotrole;
		this.robotaddr = robotaddr;
		this.robotcount = robotcount;
		this.robotpwd = robotpwd;
		this.robotstatus = robotstatus;
		this.robotuserid = robotuserid;
		this.robotuse = robotuse;
		this.robotusername = robotusername;
	}

	public String getRobotusername() {
		return robotusername;
	}

	public void setRobotusername(String robotusername) {
		this.robotusername = robotusername;
	}

	public String getRobotpwd() {
		return robotpwd;
	}
	
	public String getRobotuserid() {
		return robotuserid;
	}
	public void setRobotuserid(String robotuserid) {
		this.robotuserid = robotuserid;
	}
	public String getRobotuse() {
		return robotuse;
	}
	public void setRobotuse(String robotuse) {
		this.robotuse = robotuse;
	}
	public void setRobotpwd(String robotpwd) {
		this.robotpwd = robotpwd;
	}
	public String getRobotstatus() {
		return robotstatus;
	}
	public void setRobotstatus(String robotstatus) {
		this.robotstatus = robotstatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRobotname() {
		return robotname;
	}
	public void setRobotname(String robotname) {
		this.robotname = robotname;
	}
	public int getRobotrole() {
		return robotrole;
	}
	public void setRobotrole(int robotrole) {
		this.robotrole = robotrole;
	}
	public String getRobotaddr() {
		return robotaddr;
	}
	public void setRobotaddr(String robotaddr) {
		this.robotaddr = robotaddr;
	}
	public String getRobotcount() {
		return robotcount;
	}
	public void setRobotcount(String robotcount) {
		this.robotcount = robotcount;
	}
	public Robot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Robot(String id, String robotname, int robotrole,
			String robotaddr, String robotcount) {
		super();
		this.id = id;
		this.robotname = robotname;
		this.robotrole = robotrole;
		this.robotaddr = robotaddr;
		this.robotcount = robotcount;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (id != null ? !id.equals(robot.id) : robot.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
