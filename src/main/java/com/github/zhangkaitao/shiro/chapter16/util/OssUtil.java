package com.github.zhangkaitao.shiro.chapter16.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

/**
 * 阿里云存储服务（Open Storage Service，简称OSS）操作工具类
 * 
 * @author yuandalong
 * 
 */
public class OssUtil {
	private static OSSClient client = null;
	private static final Logger log =  LoggerFactory.getLogger(OssUtil.class);

	static{
		Properties pps = new Properties();
		try {
			pps.load(OssUtil.class.getClassLoader().getResourceAsStream("ossConfig.properties"));
		} catch (IOException e) {
			log.error("读取配置文件错误",e);
		}
		log.info("END_POINT="+pps.getProperty("END_POINT"));
		log.info("ACCESS_ID="+pps.getProperty("ACCESS_ID"));
		log.info("ACCESS_KEY="+pps.getProperty("ACCESS_KEY"));
		client = new OSSClient(pps.getProperty("END_POINT"),pps.getProperty("ACCESS_ID"), pps.getProperty("ACCESS_KEY"));
	}

	/**
	 * 文件上传
	 * 
	 * @param fileName
	 *            文件名 在使用UTF-8编码后长度必须在 1-1023字节之间，而且不能包含回车、换行、以及xml1.0不支持的字符，同时也不能以“/”或者“\”开头。
	 * @param inputStream
	 *            文件流
	 * @param bucketName
	 *            OSS的Bucket名称，Bucket是OSS全局命名空间，相当于数据的容器
	 * @throws Exception
	 */
	public static boolean uploadFile(String fileName, InputStream inputStream, String bucketName) throws Exception {
		if(client == null){
			throw new Exception("oss客户端为空！");
		}
		// 创建上传Object的Metadata
		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentLength(Long.valueOf(Objects.toString(inputStream.available())));
//		meta.setHeader("Content-Type", "image/jpeg");
		PutObjectResult result = client.putObject(bucketName, fileName, inputStream, meta);
		inputStream.close();
		if(StringUtils.isNoneBlank(result.getETag())){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 取文件内容，需关闭inputStream
	 * @param bucketName
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public static InputStream getFileStream(String bucketName, String key) throws Exception{
		 OSSObject object = client.getObject(bucketName, key);
		 InputStream inputStream = object.getObjectContent();
		 return inputStream;
	}
	/**
	 * 取文件内容，返回byte数组
	 * @param bucketName
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] getFileByteArray(String bucketName, String key) throws Exception{
		OSSObject object = client.getObject(bucketName, key);
		InputStream inputStream = object.getObjectContent();
		byte [] data = IOUtils.toByteArray(inputStream);
		inputStream.close();
		return data;
	}
	/**
	 * 取文件列表
	 * @param bucketName
	 * @return
	 */
	public static List<String> getFileList(String bucketName){
		// 获取指定bucket下的所有Object信息
	    ObjectListing listing = client.listObjects(bucketName);
	    List<String> nameList = new ArrayList<String>();
	    for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
	    	nameList.add(objectSummary.getKey());
	    }
		return nameList;
	}
	/**
	 * 取文件临时url
	 * @param bucketName
	 * @param key 文件名
	 * @param days url有效期，单位为天
	 * @return
	 */
	public static String getUrl(String bucketName, String key, int days){
		Date expiration = new Date(new Date().getTime() + 3600*1000*24*days);
		// 生成URL
		URL url = client.generatePresignedUrl(bucketName, key, expiration);
		return url.toString();
	}
	/**
	 * byte数组生成文件
	 * @param data
	 * @param filePath 文件路径
	 * @param fileName 文件名
	 */
	public static void saveFile(byte[] data, String filePath,String fileName) {  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
            File dir = new File(filePath);  
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
                dir.mkdirs();  
            }  
            file = new File(filePath+"\\"+fileName);  
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(data);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bos != null) {  
                try {  
                    bos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        }  
    }
	
	
	/** 
	 * Description: 判断OSS服务文件上传时文件的  1:image  2：video 3:audio 4:file 5:other
	 * @Version1.0 
	 * @param FilenameExtension 文件后缀 
	 * @return String  
	 */  
	public static String contentType(String FilenameExtension){  
		//图片
		if(FilenameExtension.equalsIgnoreCase("BMP")||FilenameExtension.equalsIgnoreCase("JPEG")||FilenameExtension.equalsIgnoreCase("JPG")
			||FilenameExtension.equalsIgnoreCase("PNG")||FilenameExtension.equalsIgnoreCase("GIF")){
			return "robot-imagefile";
		}  
		//语音 
		if(FilenameExtension.equalsIgnoreCase("MP3")||FilenameExtension.equalsIgnoreCase("WMA")||FilenameExtension.equalsIgnoreCase("WAV")
			||FilenameExtension.equalsIgnoreCase("MOD")||FilenameExtension.equalsIgnoreCase("RA")||FilenameExtension.equalsIgnoreCase("CD")	
			||FilenameExtension.equalsIgnoreCase("MD")||FilenameExtension.equalsIgnoreCase("ASF")||FilenameExtension.equalsIgnoreCase("AAC")
			||FilenameExtension.equalsIgnoreCase("Mp3Pro")||FilenameExtension.equalsIgnoreCase("VQF")||FilenameExtension.equalsIgnoreCase("FLAC")		
			||FilenameExtension.equalsIgnoreCase("APE")||FilenameExtension.equalsIgnoreCase("MID")||FilenameExtension.equalsIgnoreCase("M4A")	
			||FilenameExtension.equalsIgnoreCase("AAC+")||FilenameExtension.equalsIgnoreCase("AIFF")||FilenameExtension.equalsIgnoreCase("VQF")	
				){
			return "robot-voicefile";
		}  	 
		//视频   
		if(FilenameExtension.equalsIgnoreCase("RM")||FilenameExtension.equalsIgnoreCase("RMVB")||FilenameExtension.equalsIgnoreCase("WMV")
				||FilenameExtension.equalsIgnoreCase("AVI")||FilenameExtension.equalsIgnoreCase("MP4")||FilenameExtension.equalsIgnoreCase("3GP")	
				||FilenameExtension.equalsIgnoreCase("MKV")||FilenameExtension.equalsIgnoreCase("FLV")||FilenameExtension.equalsIgnoreCase("AHD")
				||FilenameExtension.equalsIgnoreCase("MPEG")){
				return "robot-videofile";
			}  	 
		//文本
		if(FilenameExtension.equalsIgnoreCase("HTML")||FilenameExtension.equalsIgnoreCase("TXT")||FilenameExtension.equalsIgnoreCase("VSD")
			||FilenameExtension.equalsIgnoreCase("PPTX")||FilenameExtension.equalsIgnoreCase("PPT")	
			||FilenameExtension.equalsIgnoreCase("DOCX")||FilenameExtension.equalsIgnoreCase("DOC")
			||FilenameExtension.equalsIgnoreCase("XML")||FilenameExtension.equals("xml")
				){
			return "robot-textfile";
		}  
		return "other";  
	}  


	/**
	 * 获取文件后缀
	 * @param fileName
	 * @return
	 */
	public static String getFilePrefix(String fileName){ 
		String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		return prefix;
	}


	/**
	 * 在oss 上创建文件夹
	 * @param bucketName
	 * @return
	 */
	public static Bucket createBucket(String bucketName){
		// 新建一个Bucket
		Bucket bucket = client.createBucket(bucketName);
		return bucket;
	}
}
