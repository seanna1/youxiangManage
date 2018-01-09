package com.github.zhangkaitao.shiro.chapter16.service;

import java.util.List;

import com.github.zhangkaitao.shiro.chapter16.entity.Robot;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

public interface RobotService {
	public Robot createRobot(Robot robot);
	public Robot updateRobot(Robot robot);
	public void deleteRobot(String robotId);

	public Robot findOne(String id);
	public List<Robot> findAll();
	public Robot findByRobotaddr(String robotaddr);
	public Robot findByRobotId(String id);
	public List<Robot> findByRoleId(String roleId);
	public Pagination<Robot> findRobotByParams(String param ,int pageCount);
	public Robot findByRobotName(String robotname);
	public Robot findRobotByUserId(String userId);
	
}
