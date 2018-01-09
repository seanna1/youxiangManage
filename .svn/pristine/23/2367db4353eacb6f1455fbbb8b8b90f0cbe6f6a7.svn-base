package com.github.zhangkaitao.shiro.chapter16.util;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class SocketClientUtil {
	private static Socket server;

	public static boolean Socket(String s){
		PrintWriter out=null;
		try {
			Map<String, String> properties = LoadProperties.loadProperties("socket.properties","ip","host");
			server = new Socket(properties.get("ip"), Integer.parseInt(properties.get("host")));  
			out = new PrintWriter(server.getOutputStream());
			out.println(s);  
			out.flush();
			server.close();
			return true;
		} catch (Exception e) {
			return false;
		}finally{
			try {
				if(server!=null)
					server.close();
				if(out!=null)
					out.close();
			} catch (Exception e2) {

			}
		}
	}
}
