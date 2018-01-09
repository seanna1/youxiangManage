package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.service.OrganizationService;
import com.github.zhangkaitao.shiro.chapter16.service.RoleService;
import com.github.zhangkaitao.shiro.chapter16.service.UserService;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private RoleService roleService;

    @RequiresPermissions("user:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value="param",required=false)String param,
    		@RequestParam(value="pageCount",required=false,defaultValue="1")Integer pageCount,
    		Model model) {
        model.addAttribute("userList", userService.findUsersByParams(param, pageCount));
        Map<String,Object> m= new HashMap<String,Object>();
        m.put("param", param);
        setCommonData(model);
        model.addAttribute("param", m);
        return "users/userQuery";
    }

    /*@RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("user", new User());
        model.addAttribute("op", "新增");
        return "user/edit";
    }*/
    
    /**
     * 验证帐号是否可用
     * @param name
     * @return
     */
    @RequiresPermissions("user:create")
    @RequestMapping(value = "/selectusername", method = RequestMethod.POST)
    @ResponseBody
    public Object showCreateForm(String name) {
    	if(name==null || "".equals(name))
    		return "2";
    	User u=userService.findByUsername(name);
    	if(u==null){
    		return "1";
    	}else{
    		return "0";
    	}      
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(User user, RedirectAttributes redirectAttributes) {
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/user";
    }
    
    @RequiresPermissions("user:create")
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String createUser(String username,String passward,String orgId,String roleId, 
    		RedirectAttributes redirectAttributes) {
    	User user = new User();
    	user.setUsername(username);
    	user.setPassword(passward);
    	user.setOrganizationId(Long.parseLong(orgId));
    	List list= new ArrayList<Long>();
    	list.add(Long.parseLong(roleId));
    	user.setRoleIds(list);
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/user";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "修改");
        return "user/edit";
    }
    
    @RequiresPermissions("user:update")
    @RequestMapping(value = "/selectupdateUser", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public Object showUpdateUser(Long id, Model model) {
       User u = userService.findOne(id);
       JSONObject jo= new JSONObject();
       jo.put("id", u.getId());
       jo.put("username", u.getUsername());
       jo.put("password", u.getPassword());
       jo.put("orgId", u.getOrganizationId());
       jo.put("roleId", u.getRoleIds().get(0));
       return jo.toString();
    }
    
    @RequiresPermissions("user:update")
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateUser(Long userId,String username,String passward,Long orgId,Long roleId, RedirectAttributes redirectAttributes) {
    	User u = userService.findOne(userId);
    	//u.setUsername(username); //配合页面 disabled="disabled"属性使用，禁用input标签
		u.setOrganizationId(orgId);
		List<Long> l=new ArrayList<Long>();
		l.add(roleId);
		u.setRoleIds(l);
    	if(passward==null || passward.equals(u.getPassword())){    		
    		 userService.updateUser(u);
    	}else{
    		userService.updateUser(u);
    		userService.changePassword(userId, passward);  		
    	}       
        return "redirect:/user";
    }
    

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(User user, RedirectAttributes redirectAttributes) {
        userService.updateUser(user);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/user";
    }

    @RequiresPermissions("user:delete") 
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
    public String showDeleteForm(Long id, Model model) { //@PathVariable("id") 
    	userService.deleteUser(id);
        return "redirect:/user";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/deleteuser", method = {RequestMethod.POST,RequestMethod.GET})
    public String delete(String id, RedirectAttributes redirectAttributes) {
    	String [] ids= id.split(",");
    	for(String i:ids){
    		userService.deleteUser(Long.parseLong(i));
    	}     
        return "redirect:/user";
    }


   /* @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.GET)
    public String showChangePasswordForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "修改密码");
        return "user/changePassword";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.POST)
    public String changePassword(@PathVariable("id") Long id, String newPassword, RedirectAttributes redirectAttributes) {
        userService.changePassword(id, newPassword);
        redirectAttributes.addFlashAttribute("msg", "修改密码成功");
        return "redirect:/user";
    }*/

    private void setCommonData(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
    }
}
