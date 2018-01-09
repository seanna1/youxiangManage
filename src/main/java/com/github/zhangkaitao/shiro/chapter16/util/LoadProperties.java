package com.github.zhangkaitao.shiro.chapter16.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadProperties {
	
	/**
     * 动态获取配置文件值(不重启获取修改后的配置文件值)
     * 效率有一定影响
     * @param propertisFile  配置文件名称（ class目录）
     * @param property 需要获取的配置项的名称
     * @return
     */
    public static Map<String,String> loadProperties(String propertisFile,String... property){
        Map<String, String> properties = null;
 
        // 获取执行根目录
        String path = Thread.currentThread().getContextClassLoader()
                .getResource(propertisFile).getPath();
        Properties props = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(new File(path));
            properties = new HashMap<String, String>();
            // 用文件流的方式加载配置文件
            props.load(is);
            // 读取配置文件，配置项
            for(String pro:property)
                properties.put(pro, props.getProperty(pro));
        } catch (IOException e) {
            
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (IOException e) {
               
            }
        }
        return properties;
    }
   
}
