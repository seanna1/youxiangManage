package com.github.zhangkaitao.shiro.chapter16.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.github.zhangkaitao.shiro.chapter16.entity.Robot;
import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

@Repository
public class RobotDaoImpl implements RobotDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Override
	public Robot createRobot(final Robot robot) {
		final String sql = "insert into robot_info(robot_id,robot_name,robot_role ,robot_addr,robot_count,robot_pwd,robot_status,robot_user_id,robot_use,robot_user_name) values(?,?,?,?,?,?,?,?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql);
                int count = 1;
                psst.setString(count++, robot.getId());
                psst.setString(count++, robot.getRobotname());
                psst.setInt(count++, robot.getRobotrole());
                psst.setString(count++, robot.getRobotaddr());  
                psst.setString(count++, robot.getRobotcount()); 
                psst.setString(count++,robot.getRobotpwd());
                psst.setString(count++,robot.getRobotstatus());
                psst.setString(count++,robot.getRobotuserid());
                psst.setString(count++,robot.getRobotuse());
                psst.setString(count++,robot.getRobotusername());
                return psst;
            }
        });
        //robot.setId(keyHolder.getKey().longValue());
        return robot;
	}

	@Override
	public Robot updateRobot(Robot robot) {
		final String sql = "update robot_info set robot_name=?, robot_role=?, robot_addr=?,robot_count=?,robot_pwd=?,robot_status=?,robot_user_id=?,robot_use=?,robot_user_name=? where robot_id=?";
        jdbcTemplate.update(
                sql,
                robot.getRobotname(),robot.getRobotrole(), robot.getRobotaddr(),robot.getRobotcount(),robot.getRobotpwd(),robot.getRobotstatus(),robot.getRobotuserid(),robot.getRobotuse(),robot.getRobotusername(), robot.getId());
        return robot;
	}
	
	@Override
	public void deleteRobot(String robotId) {
		 final String sql = "delete from robot_info where robot_id=?";
	     jdbcTemplate.update(sql, robotId);
	}

	@Override
	public Robot findOne(String robotId) {
		 final String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse, robot_user_name as robotusername from robot_info where robot_id=?";
	        List<Robot> robotList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Robot.class), robotId);
	        if(robotList.size() == 0) {
	            return null;
	        }
	        return robotList.get(0);
	}

	@Override
	public List<Robot> findAll() {
		final String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse,robot_user_name as robotusername from robot_info where 1=1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Robot.class));
	}

	@Override
	public Robot findByRobotname(String robotname) {
		String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse,robot_user_name as robotusername from robot_info where robot_name=?";
        List<Robot> robotList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Robot.class), robotname);
        if(robotList.size() == 0) {
            return null;
        }
        return robotList.get(0);
	}
	//分页
	@Override
	public Pagination<Robot> findAllByParam(String params, int pageCount) {
		StringBuffer sb = new StringBuffer(" ");
    	String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse,robot_user_name as robotusername from robot_info where 1=1 ";
    	sb.append(sql);
    	List<Object> list = new ArrayList<Object>();
    	if(params!=null&&!"".equals(params)){
    		sb.append(" and robot_addr like ? ");   		
        	list.add("%"+params+"%");       	
    	}
    	Pagination<Robot>page = new Pagination<Robot>(sb.toString(), pageCount, list, Pagination.NUMBERS_PER_PAGE, jdbcTemplate,Robot.class,null);
    	return page;
	}

	@Override
	public Robot findByRobotId(String id) {
		String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse,robot_user_name as robotusername from robot_info where robot_id=?";
        List<Robot> robotList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Robot.class), id);
        if(robotList.size() == 0) {
            return null;
        }
        return robotList.get(0);
	}

	@Override
	public List<Robot> findByRoleId(String roleId) {
		final String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse,robot_user_name as robotusername from robot_info where robot_role=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Robot.class),roleId);
	}

	@Override
	public Robot findByRoleName(String robotname) {
		 final String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse,robot_user_name as robotusername from robot_info where robot_name=?";
	        List<Robot> robotList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Robot.class), robotname);
	        if(robotList.size() == 0) {
	            return null;
	        }
	        return robotList.get(0);
	}

	@Override
	public Robot findRobotByUserId(String userId) {
		final String sql = "select robot_id as id, robot_name as robotname, robot_role as robotrole, robot_addr as robotaddr, robot_count as robotcount,robot_pwd as robotpwd,robot_status as robotstatus,robot_user_id as robotuserid,robot_use as robotuse,robot_user_name as robotusername from robot_info where robot_user_id=?";
        List<Robot> robotList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Robot.class), userId);
        if(robotList.size() == 0) {
            return null;
        }
        return robotList.get(0);
	}

}
