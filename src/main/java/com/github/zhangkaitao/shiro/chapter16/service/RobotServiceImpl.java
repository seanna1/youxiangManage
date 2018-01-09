package com.github.zhangkaitao.shiro.chapter16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zhangkaitao.shiro.chapter16.dao.RobotDao;
import com.github.zhangkaitao.shiro.chapter16.entity.Robot;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;
@Service
public class RobotServiceImpl implements RobotService{
    @Autowired
    private RobotDao robotDao;
    
	@Override
	public Robot createRobot(Robot robot) {
		return robotDao.createRobot(robot);
	}

	@Override
	public Robot updateRobot(Robot robot) {
		return robotDao.updateRobot(robot);
	}

	@Override
	public void deleteRobot(String robotId) {
		robotDao.deleteRobot(robotId);
	}

	@Override
	public Robot findOne(String robotId) {
		return robotDao.findOne(robotId);
	}

	@Override
	public List<Robot> findAll() {
		return robotDao.findAll();
	}

	@Override
	public Robot findByRobotaddr(String robotaddr) {
		return robotDao.findByRobotname(robotaddr);
	}

	@Override
	public Pagination<Robot> findRobotByParams(String params, int pageCount) {
		return robotDao.findAllByParam(params, pageCount);
	}

	@Override
	public Robot findByRobotId(String id) {
		return robotDao.findByRobotId(id);
	}

	@Override
	public List<Robot> findByRoleId(String roleId) {
		return robotDao.findByRoleId(roleId);
	}

	@Override
	public Robot findByRobotName(String robotname) {
		return robotDao.findByRoleName(robotname);
	}

	@Override
	public Robot findRobotByUserId(String userId) {
		return robotDao.findRobotByUserId(userId);
	}

}
