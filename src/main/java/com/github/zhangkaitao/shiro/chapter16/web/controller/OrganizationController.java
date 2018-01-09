package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.zhangkaitao.shiro.chapter16.entity.Organization;
import com.github.zhangkaitao.shiro.chapter16.service.OrganizationService;
import com.github.zhangkaitao.shiro.chapter16.service.RoleService;

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


@Controller
@RequestMapping("/department")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private RoleService roleService;
    
    @RequiresPermissions("organization:view")
    @RequestMapping(method = RequestMethod.GET)
    public String listDeparts(@RequestParam(value="param",required=false)String param,
    		@RequestParam(value="pageCount",required=false,defaultValue="1")Integer pageCount,
    		Model model) {
        model.addAttribute("departList", organizationService.findOrgByParams(param, pageCount));
        Map<String,Object> m= new HashMap<String,Object>();
        m.put("param", param);
        setCommonData(model);
        model.addAttribute("param", m);
        return "department/department";
    }
    //验证部门名称是否可用
    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/selectdepartname", method = RequestMethod.POST)
    @ResponseBody
    public Object showCreateForms(String name) {
    	if(name==null || "".equals(name)){
    		return "2";
    	}
    	Organization org = organizationService.findByName(name);
    	if(org==null){
    		return "1";
    	}else{
    		return "0";
    	}      
    }
    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/createdepart", method = RequestMethod.POST)
    public String createDeparts(String name,RedirectAttributes redirectAttributes) {
    	Organization org = new Organization();
    	org.setName(name);
    	/*org.setParentId(null);
    	org.setParentIds(null);
    	org.setAvailable(true);*/
    	organizationService.createOrganization(org);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/department";
    }
    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/selectUpdateDepart", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public Object showUpdateDepart(Long id,Model model) {
    	Organization org = organizationService.findOne(id);
       JSONObject jo= new JSONObject();
       jo.put("id", org.getId());
       jo.put("name", org.getName());
       return jo.toString();
    }
    
    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/updatedepart", method = RequestMethod.POST)
    public String updateDepart(Long id,String name, RedirectAttributes redirectAttributes) {
    	Organization org = organizationService.findOne(id);
    	org.setId(id);
    	org.setName(name);
    	organizationService.updateOrganization(org);
        return "redirect:/department";
    }
    @RequiresPermissions("organization:delete")
    @RequestMapping(value = "/deleteDepartmentById", method = RequestMethod.GET)
    public String showDeleteForm(Long id, Model model) {
    	organizationService.deleteOrganization(id);
        return "redirect:/department";
    }

    @RequiresPermissions("organization:delete")
    @RequestMapping(value = "/deleteDepart", method = {RequestMethod.POST,RequestMethod.GET})
    public String deleteDepart(String id, RedirectAttributes redirectAttributes) {
    	String [] ids= id.split(",");
    	for(String i:ids){
    		organizationService.deleteOrganization(Long.parseLong(i));
    	}     
        return "redirect:/department";
    }
    
    
/*    @RequiresPermissions("organization:view")
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "organization/index";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String showTree(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        return "organization/tree";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        Organization parent = organizationService.findOne(parentId);
        model.addAttribute("parent", parent);
        Organization child = new Organization();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("child", child);
        model.addAttribute("op", "新增");
        return "organization/appendChild";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
    public String create(Organization organization) {
        organizationService.createOrganization(organization);
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/maintain", method = RequestMethod.GET)
    public String showMaintainForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("organization", organizationService.findOne(id));
        return "organization/maintain";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(Organization organization, RedirectAttributes redirectAttributes) {
        organizationService.updateOrganization(organization);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        organizationService.deleteOrganization(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/organization/success";
    }


    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.GET)
    public String showMoveForm(@PathVariable("sourceId") Long sourceId, Model model) {
        Organization source = organizationService.findOne(sourceId);
        model.addAttribute("source", source);
        model.addAttribute("targetList", organizationService.findAllWithExclude(source));
        return "organization/move";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.POST)
    public String move(
            @PathVariable("sourceId") Long sourceId,
            @RequestParam("targetId") Long targetId) {
        Organization source = organizationService.findOne(sourceId);
        Organization target = organizationService.findOne(targetId);
        organizationService.move(source, target);
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "organization/success";
    }*/

    private void setCommonData(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
    }
}
