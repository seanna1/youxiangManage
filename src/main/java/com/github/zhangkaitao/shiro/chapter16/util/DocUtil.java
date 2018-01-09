package com.github.zhangkaitao.shiro.chapter16.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DocUtil {
	 private Configuration configuration = null;

	    public DocUtil() {
	        configuration = new Configuration();
	        configuration.setDefaultEncoding("UTF-8");
	    }
	    public String createWord( Map<String, Object> dataMap, HttpServletRequest request,HttpServletResponse response)  {
	        configuration.setClassForTemplateLoading(this.getClass(), "/fit");  //FTL文件所存在的位置
	        Template t = null;
	        try {
	            t = configuration.getTemplate("from.ftl"); //文件名
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        String ss = (String)dataMap.get("fromName"); //导出文件名
	        //获取项目部署所在服务器的ip 
	        Map<String, String> map = LoadProperties.loadProperties("socket.properties","ip2");
			String ip = map.get("ip2");
			//项目名(path)和服务器端口(port)
	        String path = request.getServletContext().getContextPath();
	        int port = request.getLocalPort();
	        if(ss!=null || ss==""){
	        	//File outFile = new File("D:/"+ss+".doc");
	        	/*
	        	 * 生成word文件的路径
	        	 */
	        	//获取本项目的路径 webapps/medical_treatment2
	        	String realPath = request.getSession().getServletContext().getRealPath("/");
	        	//获取上级目录
	        	//String webapps = new File(realPath).getParent();
	        	File outFile = new File(realPath+"/file/"+ss+".doc");
		        Writer out = null;
		        try {
		        	out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(outFile), "utf-8")); 
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
		        try {
		            t.process(dataMap, out);
		        } catch (TemplateException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
	        }
	        return "http://"+ip+":"+port+path+"/file/"+ss+".doc";
	    }
}
