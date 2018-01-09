package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.zhangkaitao.shiro.chapter16.entity.Robot;
import com.github.zhangkaitao.shiro.chapter16.service.RobotService;
import com.github.zhangkaitao.shiro.chapter16.service.TranslateService;
import com.github.zhangkaitao.shiro.chapter16.util.SocketClientUtil;

@Controller
@RequestMapping("/translate")
public class TranslateController {
	@Autowired
	private TranslateService translateService;
	@Autowired
	private RobotService robotService;
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
    public String listTranslates(@RequestParam(value="params",required=false)String params,
    		@RequestParam(value="pageCount",required=false,defaultValue="1")Integer pageCount,
    		Model model) {
        model.addAttribute("translateList", translateService.findAllByParam(params, pageCount)); 
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("params", params);
        model.addAttribute("params", map);
        return "translate/translate";
    }
	//发送开始录入消息到c
	@RequestMapping(value = "/beginsendmsg",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String sendToCMessages(@RequestParam(value="tobeg")String tobeg,HttpSession session){
		JSONObject objJson= new JSONObject();
		JSONObject objJson2= new JSONObject();
		/*//写死的上线robotId
		objJson2.put("id", "6001");*/
		//取出用户登录成功后存入session的userID
		Long managerId = (Long)session.getAttribute("managerId");
		Robot robot = robotService.findRobotByUserId(managerId.toString());
		String robotId = robot.getId();
		//System.out.println(robotId+"----robotId----");
		objJson2.put("id", robotId);
		
		List<Object> lists = new ArrayList<Object>();
		lists.add(objJson2);
		//System.out.println(lists);
		objJson.put("flag", "true");
		objJson.put("toids", lists);
		String str="@@@c:147;l:"+objJson.toString().length()+";\r\n"+objJson.toString();
		boolean boo = SocketClientUtil.Socket(str);
		//System.out.println(str+"===开始翻译消息===="+boo);
		JSONObject jo= new JSONObject();
		if(boo==true){
			jo.put("msg",boo+"开始翻译");
		}else{
			jo.put("msg",boo+"开始翻译失败！");
		}
		return jo.toString();
	}
	//发送结束消息到C端
	@RequestMapping(value = "/toendsendmesgs",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String endToCMSG(@RequestParam(value="toend")String toend,HttpSession session){
		//发送结束录入的消息到c
		JSONObject objJson= new JSONObject();
		JSONObject objJson2= new JSONObject();
		//objJson2.put("id", "6001");
		Long managerId = (Long)session.getAttribute("managerId");
		Robot robot = robotService.findRobotByUserId(managerId.toString());
		String robotId = robot.getId();
		//System.out.println(robotId+"----robotId----");
		objJson2.put("id", robotId);
		
		List<Object> lists = new ArrayList<Object>();
		lists.add(objJson2);
		objJson.put("flag", "false");
		objJson.put("toids", lists);
		String strs="@@@c:147;l:"+objJson.toString().length()+";\r\n"+objJson.toString();
		boolean boo = SocketClientUtil.Socket(strs);
		//System.out.println(strs+"===结束翻译消息===="+boo);
		JSONObject jo= new JSONObject();
		if(boo==true){
			jo.put("msg", boo+"结束翻译");
		}else{
			jo.put("msg", boo+"结束翻译失败！");
		}
		return jo.toString();
	}	
    @RequestMapping(value = "/deleteTranslateById", method = {RequestMethod.POST,RequestMethod.GET})
  	public String deleteCustomers(Long id, RedirectAttributes redirectAttributes) {
    	translateService.deleteById(id);
        return "redirect:/translate";
    }
    @RequestMapping(value = "/deletetranslate", method = {RequestMethod.POST,RequestMethod.GET})
  	public String deleteCus(String id, RedirectAttributes redirectAttributes) {
    	String [] ids= id.split(",");
    	for(String i:ids){
    		translateService.deleteById(Long.valueOf(i));
    	}     
        return "redirect:/translate";
    }
}
