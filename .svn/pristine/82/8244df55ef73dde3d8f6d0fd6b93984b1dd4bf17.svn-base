package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.zhangkaitao.shiro.chapter16.entity.Robot;
import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.service.RobotService;
import com.github.zhangkaitao.shiro.chapter16.service.UserService;

@Controller
@RequestMapping("/robot")
public class RobotController {
	@Autowired
    private RobotService robotService;
	@Autowired
	private UserService userService;
	
	@RequiresPermissions("robot:view")
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	public String lists(@RequestParam(value="param",required=false)String param,
    		@RequestParam(value="pageCount",required=false,defaultValue="1")Integer pageCount,
    		Model model) {
		model.addAttribute("robotList", robotService.findRobotByParams(param, pageCount));
        Map<String,Object> m= new HashMap<String,Object>();
        m.put("param", param);
        model.addAttribute("param", m);
        return "robot/robots";
    }
	
	 /**
     * 判断机器人ID是否可用
     * @param name
     * @return
     */
    @RequiresPermissions("robot:create")
    @RequestMapping(value = "/selectrobotid", method = RequestMethod.POST)
    @ResponseBody
    public Object showCreateForm(String id) {
    	if(id==null || id=="")
    		return "2";
    	Robot r=robotService.findByRobotId(id);
    	if(r==null){
    		return "1";
    	}else{
    		return "0";
    	}      
    }
    @RequiresPermissions("robot:create")
    @RequestMapping(value = "/selectRobotName", method = RequestMethod.POST)
    @ResponseBody
    public Object showCreateRobotName(String robotname) {
    	if(robotname==null || robotname==""){
    		return "2";
    	}
    	Robot r=robotService.findByRobotName(robotname);
    	if(r==null){
    		return "1";
    	}else{
    		return "0";
    	}      
    }
    @RequiresPermissions("robot:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String showCreateForm(Robot robot,RedirectAttributes redirectAttributes) {
    	robotService.createRobot(robot);
    	redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/robot";
    }

    @RequiresPermissions("robot:create")
    @RequestMapping(value = "/createrobot", method = RequestMethod.POST)
    public String create(String id,String robotname,String robotrole,String robotaddr,String robotpwd,RedirectAttributes redirectAttributes) {
    	Robot r = new Robot();
    	r.setId(id);
    	r.setRobotname(robotname);
    	r.setRobotrole(Integer.parseInt(robotrole));
    	r.setRobotaddr(robotaddr);
    	r.setRobotpwd(robotpwd);
    	r.setRobotuse("2");
    	robotService.createRobot(r);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/robot";
    }
    
  	@RequiresPermissions("robot:update")
    @RequestMapping(value = "/selectupdateRobot",produces={"application/json;charset=UTF-8"}, method = RequestMethod.POST)
  	@ResponseBody
    public String update(String id, Model model) {
  		Robot r = robotService.findOne(id);
  		JSONObject jo= new JSONObject();
        jo.put("id",r.getId());
        jo.put("robotname",r.getRobotname());
        jo.put("robotrole",r.getRobotrole());
        jo.put("robotaddr", r.getRobotaddr());
        jo.put("robotpwd",r.getRobotpwd());
        return jo.toString();
    }
    
  	@RequiresPermissions("robot:update")
    @RequestMapping(value = "/updaterobot", method = RequestMethod.POST)
    public synchronized String updateRobot(String id,String robotname,String robotrole,String robotaddr,String robotpwd,RedirectAttributes redirectAttributes) {
  		Robot r = robotService.findOne(id);
  		r.setId(id);
  		r.setRobotname(robotname);
  		r.setRobotrole(Integer.parseInt(robotrole));
  		r.setRobotaddr(robotaddr);
  		r.setRobotpwd(robotpwd);
  		robotService.updateRobot(r);
  		redirectAttributes.addFlashAttribute("msg", "修改成功");
    	return "redirect:/robot";
    }
  	
    @RequiresPermissions("robot:delete")
    @RequestMapping(value = "/delRobotsById", method = {RequestMethod.POST,RequestMethod.GET})
    public String showDeleteForm(String id, RedirectAttributes redirectAttributes) {
    	robotService.deleteRobot(id);
        return "redirect:/robot";
    }

    @RequiresPermissions("robot:delete")
    @RequestMapping(value = "/deleterobot", method = {RequestMethod.POST,RequestMethod.GET})
    public String delete(String id, RedirectAttributes redirectAttributes) {
    	String [] ids= id.split(",");
    	for(String i:ids){
        	robotService.deleteRobot(i);
    	}
        return "redirect:/robot";
    }
    //绑定
    @RequiresPermissions("robot:update")
    @RequestMapping(value = "/bindingUsers",produces={"application/json;charset=UTF-8"}, method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String bindingUsers(String id,HttpSession session){
    	JSONObject jo= new JSONObject();
    	Long managerId = (Long)session.getAttribute("managerId");
    	Robot robot = robotService.findByRobotId(id);
    	robot.setRobotuserid(managerId.toString());
    	User user = userService.findOne(managerId);
    	robot.setRobotusername(user.getUsername());
    	robotService.updateRobot(robot);
    	jo.put("msg","绑定成功");
    	return jo.toString();
    }
    //解绑
    @RequiresPermissions("robot:update")
    @RequestMapping(value = "/unbindUsers",produces={"application/json;charset=UTF-8"}, method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String unbindUsers(String id,HttpSession session){
    	JSONObject jo= new JSONObject();
    	Robot robot = robotService.findByRobotId(id);
    	robot.setRobotuserid(null);
    	robot.setRobotusername(null);
    	robotService.updateRobot(robot);
    	jo.put("msg","解绑成功");
    	return jo.toString();
    }
}
