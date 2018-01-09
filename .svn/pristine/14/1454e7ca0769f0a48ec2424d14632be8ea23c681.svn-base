package com.github.zhangkaitao.shiro.chapter16.dao;

import java.util.List;

import com.github.zhangkaitao.shiro.chapter16.entity.Robot;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;


public interface RobotDao {
	public Robot createRobot(Robot robot);
    public Robot updateRobot(Robot robot);
    public void deleteRobot(String robotId);
    
    public Robot findOne(String robotId);
    public List<Robot> findAll();
    Robot findByRobotname(String robotname);
    Robot findByRobotId(String id);
    List<Robot> findByRoleId(String roleId);
    Pagination<Robot> findAllByParam(String params,int pageCount);
	public Robot findByRoleName(String robotname);
	public Robot findRobotByUserId(String userId);
}
