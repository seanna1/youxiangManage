package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.zhangkaitao.shiro.chapter16.entity.Resource;
import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.service.ResourceService;
import com.github.zhangkaitao.shiro.chapter16.service.UserService;
import com.github.zhangkaitao.shiro.chapter16.web.bind.annotation.CurrentUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
@Controller
public class LoginController {
	
	 @Autowired
	    private ResourceService resourceService;
	    @Autowired
	    private UserService userService;
	
    @RequestMapping(value = "/login"    )
    public String showLoginForm(@RequestParam(value="username",required=false) String username,@RequestParam(value="passWord",required=false) String password,HttpServletRequest req, Model model,HttpSession session) {
    	if(username==null||"".equals(username))
    		return "login/login";
 	
    	String error = null;
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        boolean flag =true;
        try{
        	currentUser.login(token);
        }catch(UnknownAccountException e){
        	error = "用户名/密码错误";
        	flag=false;
        }catch(IncorrectCredentialsException e){
        	error = "用户名/密码错误";
        	flag=false;
        }catch(Exception e){
        	 error = "其他错误：" ;
        	 flag=false;
        }
        if(flag){
        	 //设置session的存活时间 18小时
        	 session.setMaxInactiveInterval(18 * 60 * 60);//单位为秒，-1为永不过期
        	 Set<String> permissions = userService.findPermissions(username);
             List<Resource> menus = resourceService.findMenus(permissions);
             model.addAttribute("menus", menus);
             //登录成功保存用户ID
             User user = userService.findByUsername(username);
             session.setAttribute("managerId",user.getId());
             return "index";
        }else{
        	model.addAttribute("error", error);
            return "login/login";
        }       
       /*String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");*
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }*/
        
    }    
}
