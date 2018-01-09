package com.github.zhangkaitao.shiro.chapter16.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.zhangkaitao.shiro.chapter16.entity.AnswerInfo;
import com.github.zhangkaitao.shiro.chapter16.entity.QuestionInfo;
import com.github.zhangkaitao.shiro.chapter16.entity.Robot;
import com.github.zhangkaitao.shiro.chapter16.service.AnswerInfoService;
import com.github.zhangkaitao.shiro.chapter16.service.QuestionInfoService;
import com.github.zhangkaitao.shiro.chapter16.service.RobotService;
import com.github.zhangkaitao.shiro.chapter16.util.Doc;
import com.github.zhangkaitao.shiro.chapter16.util.DocUtil;
import com.github.zhangkaitao.shiro.chapter16.util.SocketClientUtil;
import com.github.zhangkaitao.shiro.chapter16.util.StringUtil;

@Controller
@RequestMapping("/answer")
public class ReceiveAnswerController {
	@Autowired
	private AnswerInfoService answerInfoService;
	@Autowired
	private RobotService robotService;
	@Autowired
	private QuestionInfoService questionInfoService;
	
	//发送开始录入消息到c
	@RequestMapping(value = "/sendmessage",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String sendMessage(@RequestParam(value="qid")Long qid,@RequestParam(value="uid")Long uid,HttpSession session){
		JSONObject objJson= new JSONObject();
		//取出用户登录成功后存入session的userID
		Long managerId = (Long)session.getAttribute("managerId");
		/*//写死的上线robotId
		JSONObject objJson2= new JSONObject();
		objJson2.put("id", "6001");*/
		
		Robot robot = robotService.findRobotByUserId(managerId.toString());
		String robotId = robot.getId();
		JSONObject objJson2= new JSONObject();
		objJson2.put("id", robotId);
		session.setAttribute("robotId", robotId);
		
		List<Object> lists = new ArrayList<Object>();
		lists.add(objJson2);
		//System.out.println(lists);
		
		objJson.put("userId", uid.toString());
		objJson.put("questionId", qid.toString());
		objJson.put("flag", "true");
		objJson.put("toids", lists);
		
		String str="@@@c:146;l:"+objJson.toString().length()+";\r\n"+objJson.toString();
		boolean boo = SocketClientUtil.Socket(str);
		if(boo==true){
			System.out.println("开始消息发送成功！");
			JSONObject jo= new JSONObject();
			jo.put("message","");
			return jo.toString();
		}else{
			System.out.println("开始消息发送失败！");
			JSONObject jo= new JSONObject();
			jo.put("message","服务异常，请重试");
			return jo.toString();
		}
	}
	//发送结束消息到C端
	@RequestMapping(value = "/endFormInto",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
	public String FormIntoKeyword(@RequestParam(value="qid")Long qid,@RequestParam(value="uid")Long uid,HttpSession session){
		JSONObject objJson= new JSONObject();
		JSONObject objJson2= new JSONObject();
		Long managerId = (Long)session.getAttribute("managerId");
		Robot robot = robotService.findRobotByUserId(managerId.toString());
		String robotId = robot.getId();
		objJson2.put("id", robotId);
		//objJson2.put("id", "6001");
		List<Object> lists = new ArrayList<Object>();
		lists.add(objJson2);
		objJson.put("userId", uid.toString());
		objJson.put("questionId", qid.toString());
		objJson.put("flag", "false");
		objJson.put("toids", lists);
		String strs="@@@c:146;l:"+objJson.toString().length()+";\r\n"+objJson.toString();
		boolean boo = SocketClientUtil.Socket(strs);
		JSONObject jo= new JSONObject();
		if(boo==true){
				AnswerInfo answer = answerInfoService.findAnswerByUidAndQidAndCtime(uid, qid,StringUtil.getDate2());
				if(answer==null){
					jo.put("keyword", "");
				}else{
					jo.put("keyword",answer.getKeyword());
				}
				System.out.println("结束消息发送成功！");
		}else{
				AnswerInfo answer = answerInfoService.findAnswerByUidAndQidAndCtime(uid, qid,StringUtil.getDate2());
				if(answer==null){
					jo.put("keyword", "");
				}else{
					jo.put("keyword",answer.getKeyword());
				}
				System.out.println("结束消息发送失败！");
		}
		return jo.toString();
	}
	//轮询查询答案
	@RequestMapping(value = "/quarts",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
	public String quartsTextarea(@RequestParam(value="qid")Long qid,@RequestParam(value="uid")Long uid){
		JSONObject jo= new JSONObject();
		AnswerInfo answer = answerInfoService.findAnswerByUidAndQidAndCtime(uid, qid,StringUtil.getDate2());
		if(answer==null){
			jo.put("keywords", "");
		}else{
			jo.put("keywords",answer.getKeyword());
		}
		return jo.toString();
	}
	//表单导出word文档
	@RequestMapping(value = "/outword",produces={"application/json;charset=UTF-8"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String Formderivation(String tablename,String uid,String fname,String fgender,String fage,
    		String fheight,String fweight,String fcreatetime,String myString,HttpServletRequest request,HttpServletResponse response){
			JSONObject jo= new JSONObject();
			//导出word
			DocUtil docUtil=new DocUtil();
			Map<String, Object> dataMap=new HashMap<String, Object>();
	        if(tablename!=null&&fname!=null){
	        	String time = StringUtil.getDate2();
	        	dataMap.put("fromName",time+tablename+fname);
	        	dataMap.put("name", fname);
	        }
	        if(fgender!=null){
	        	dataMap.put("gender",fgender);
	        }
	        if(fage!=null){
	        	dataMap.put("age", fage);
	        }
	        if(fheight!=null){
	        	dataMap.put("height", fheight);
	        }
	        if(fweight!=null){
	        	dataMap.put("weight", fweight);
	        }
	        if(fcreatetime!=null){
	        	dataMap.put("time",fcreatetime);
	        }
	        
	        if(myString!=null){
	        	List<Doc> fromlist = new ArrayList<Doc>();
	        	//System.out.println(myString);
	        	String[] str1 = myString.split("@");
	        	for (int i = 0; i < str1.length; i++) {
					System.out.println(str1[i]);
					String[] ss1 = str1[i].split("#");
					Doc doc = new Doc();
					QuestionInfo question = questionInfoService.findById(Long.valueOf(ss1[0]));
					doc.setQuest((i+1)+"."+question.getQuestionName());
					doc.setAnswer(ss1[1]);
					fromlist.add(doc);
					AnswerInfo ans = answerInfoService.findAnswerByUidAndQidAndCtime(Long.valueOf(uid), Long.valueOf(ss1[0]),StringUtil.getDate2());
					if(ans!=null && ss1[1]!=null){
						ans.setKeyword(ss1[1]);
						answerInfoService.update(ans);
					}else{
						AnswerInfo an = new AnswerInfo();
						an.setUserid(uid);
						an.setQuestionid(question.getQuestionId().toString());
						an.setKeyword(ss1[1]);
						an.setCreatetime(new Date());
						answerInfoService.insert(an);
					}
				
	        	//更新答案到数据库
	        	/*for(int i=0;i<myArray.length;i++){
	        		System.out.println(myArray.length);
	        		System.out.println(myArray[i]);
	        		String str = myArray[i].replace("[","").replace("\"", "").replace("]","");
	        		//String str = myArray[i];
					String[] split = str.split("#");
					Doc doc = new Doc();
					QuestionInfo question = questionInfoService.findById(Long.valueOf(split[0]));
					//doc.setQuest(question.getQuestionId()+"."+question.getQuestionName());
					doc.setQuest((i+1)+"."+question.getQuestionName());
					doc.setAnswer(split[1]);
					fromlist.add(doc);
					AnswerInfo ans = answerInfoService.findAnswerByUidAndQidAndCtime(Long.valueOf(uid), Long.valueOf(split[0]),StringUtil.getDate2());
					if(ans!=null && split[1]!=null){
						ans.setKeyword(split[1]);
						answerInfoService.update(ans);
					}else{
						AnswerInfo an = new AnswerInfo();
						an.setUserid(uid);
						an.setQuestionid(question.getQuestionId().toString());
						an.setKeyword(split[1]);
						an.setCreatetime(new Date());
						answerInfoService.insert(an);
					}*/
				}
				dataMap.put("fromList",fromlist);
				// 导出
				String url = docUtil.createWord(dataMap,request,response);
				//下载路径
				System.out.println(url);
				jo.put("msg","请求成功！");
				jo.put("url",url);
	        }
	        else{
	        	jo.put("error", "有问题未录入");
	        }
		return jo.toString();
	}
}
