package com.github.zhangkaitao.shiro.chapter16.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class StringUtil {
	private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat sdf6 = new SimpleDateFormat("HH:mm:ss");
	private static final SimpleDateFormat sdf7 = new SimpleDateFormat("EEEE");
	private static final SimpleDateFormat sdf8 = new SimpleDateFormat("MM-dd");

	/**
	 * 月份相减
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int monthSpace(String str1,String str2 )  {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar bef = Calendar.getInstance();
			Calendar aft = Calendar.getInstance();
			bef.setTime(sdf.parse(str1));
			aft.setTime(sdf.parse(str2));
			int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
			int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR))*12;
			//System.out.println(month+result );
			return month+result;
		} catch (Exception e) {

		}
		return 0;		
		}
	/**
	 * 获取某月第一天
	 * @return
	 */
	public static String getMonthFirstDay(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}

	/**
	 * 获取某月最后一天
	 * @return
	 */
	public static String getMonthLastDay(Date date) {  
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat simpleFormate = new SimpleDateFormat("yyyy-MM-dd");
		return simpleFormate.format(calendar.getTime());  
	}
	
	/**
	 * 年月日计算
	 * @param StrDate
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
		public static String GetSysDate(String StrDate,int year,int month,  
		            int day)   {  
		Calendar   cal   =   Calendar.getInstance();  
		SimpleDateFormat   sFmt   =   new   SimpleDateFormat("yyyy-MM-dd");  
		cal.setTime(sFmt.parse(   (StrDate),   new  ParsePosition(0)));  
		
		if   (day   !=   0)   {  
		cal.add(cal.DATE,   day);  
		}  
		if   (month   !=   0)   {  
		cal.add(cal.MONTH,   month);  
		}  
		if   (year   !=   0)   {  
		cal.add(cal.YEAR,   year);  
		
		}  
		return   sFmt.format(cal.getTime());  
		}   
		
		
		
		/**
		 * 根据某一天获取周几
		 * @param day
		 * @return
		 * @throws Exception
		 */
		/*public static String getMonth(String month){
			String week=month;
			   switch(month) {  
			   case "01": week="一月"; break; 
			   case "02": week="二月"; break; 
			   case "03": week="三月"; break; 
			   case "04": week="四月"; break; 
			   case "05": week="五月"; break; 
			   case "06": week="六月"; break; 		   
			   case "07": week="七月"; break; 		   
			   case "08": week="八月"; break; 		   
			   case "09": week="九月"; break; 		   
			   case "10": week="十月"; break; 		   
			   case "11": week="十一月"; break; 		   
			   case "12": week="十二月"; break;			    
			  }
			  return week;

		}*/
	
	
	/**
	 * 获取当前时间：yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String getDate() {
		String format = "yyyy-MM-dd HH:mm:ss";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);
	}
	/**
	 * 获取当月有多少天
	 * @param date yyyy-MM格式
	 * @return
	 */
	public static int getCountDate(String date){
		Calendar cal = Calendar.getInstance();
		int year=Integer.parseInt(date.substring(0, 4));
		int month=Integer.parseInt(date.substring(5, 7));
		cal.set(Calendar.YEAR,year); 
		cal.set(Calendar.MONTH, month - 1);//Java月份才0开始算 
		int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
		return dateOfMonth;
	}
	/**
	 * 获取当月的每一天
	 * @param date
	 * @return
	 */
	public static List<String> getEveryDay(String date){
		List<String>result=new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		int year=Integer.parseInt(date.substring(0, 4));
		int month=Integer.parseInt(date.substring(5, 7));
	    //设置年份
	    cal.set(Calendar.YEAR,year);
	    //设置月份
	    cal.set(Calendar.MONTH, month-1);
	    //设置日历中月份的某天
	    for(int i=1;i<=StringUtil.getCountDate(date);i++){
	    	cal.set(Calendar.DAY_OF_MONTH, i);
		    //格式化日期
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String firstDayOfMonth = sdf.format(cal.getTime());
		    result.add(firstDayOfMonth);
	    }
	    return result;	    
	}
	/**
	 * 根据某一天获取周几
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static String getWeekDay(String day){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  Calendar c = Calendar.getInstance();
		  try {
			c.setTime(format.parse(day));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		  String week="";
		  int dayForWeek = 0;
		  if(c.get(Calendar.DAY_OF_WEEK) == 1){
		   dayForWeek = 7;
		   week="日";
		  }else{
		   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		   switch(dayForWeek) {  
		   case 1: week="一"; break; 
		   case 2: week="二"; break; 
		   case 3: week="三"; break; 
		   case 4: week="四"; break; 
		   case 5: week="五"; break; 
		   case 6: week="六"; break; 		   
		   }  
		  }
		  return week;

	}
	/**
	 * 获取当前时间：yyyy-MM-dd
	 * @return
	 */
	public static String getDate2() {
		String format = "yyyy-MM-dd";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);
	}
	
	/**
	 * 日期格式转换：yyyy-MM-dd
	 * @return
	 */
	public static String changDate2(Date date) {
		String format = "yyyy-MM-dd";
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 日期格式转换：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String changDate3(Date date) {
		String format = "yyyy-MM-dd HH:mm:ss";
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 *String转日期：yyyy-MM
	 * @return
	 * @throws ParseException 
	 */
	public static Date stringToDate1(String date) throws ParseException {
		String format = "yyyy-MM";
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = sdf.parse(date);
		return d;
	}
	
	/**
	 *String转日期：yyyy-MM-dd
	 * @return
	 * @throws ParseException 
	 */
	public static Date stringToDate2(String date) throws ParseException {
		String format = "yyyy-MM-dd";
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = sdf.parse(date);
		return d;
	}
	
	/**
	 *String转日期：yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException 
	 */
	public static Date stringToDate3(String date) throws ParseException {
		String format = "yyyy-MM-dd HH:mm:ss";
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = sdf.parse(date);
		return d;
	}
	
	public static String stringToDate33(String date) throws ParseException {
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf2.format(sdf1.parse(date));
	}
	

	/**
	 * 获取当前时间：yyyy-MM
	 * @return
	 */
	public static String getDate3() {
		String format = "yyyy-MM";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);
	}

	/**
	 * 获取当前时间：yyyy
	 * @return
	 */
	public static String getDate_Year() {
		String format = "yyyy";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);
	}


	/**
	 * 获取当前时间：MM
	 * @return
	 */
	public static String getDate_Month() {
		String format = "MM";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);
	}

	/**
	 * 获取月：MM
	 * @return
	 */
	public static String getDate_Month2() {
		String format = "MM";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		int month=Integer.parseInt(sdf.format(dt));
		return String.valueOf(month);
	}

	/**
	 * 指定日期字符串天数加1
	 * 
	 * @param dateStr
	 * @return String
	 */
	@SuppressWarnings("static-access")
	public static String getDate3(String dateStr) {
		Calendar dayc1 = new GregorianCalendar();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date daystart = null;
		try {
			daystart = df.parse(dateStr);
			dayc1.setTime(daystart);
			dayc1.add(dayc1.DATE, 1);
			daystart = dayc1.getTime();
		} catch (ParseException e) {
		} // start_date是类似"2013-02-02"的字符串
		return df.format(daystart);
	}
	
	/**
	 * 指定日期字符串天数减1
	 * 
	 * @param dateStr
	 * @return String
	 */
	@SuppressWarnings("static-access")
	public static String getDate4(String dateStr) {
		Calendar dayc1 = new GregorianCalendar();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date daystart = null;
		try {
			daystart = df.parse(dateStr);
			dayc1.setTime(daystart);
			dayc1.add(dayc1.DATE, -1);
			daystart = dayc1.getTime();
		} catch (ParseException e) {
		} // start_date是类似"2013-02-02"的字符串
		return df.format(daystart);
	}

	/**
	 * 获取当前时间到小时
	 * @return
	 */
	public static String getDateToHour() {
		String format = "yyyy-MM-dd HH";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);
	}

	/**
	 * 获取当前时间,返回小时
	 */
	public static int getCurrentHour(){
		String format = "HH";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String H=sdf.format(dt);
		String temp=H.substring(1);
		if(!"0".equalsIgnoreCase(temp)){
			H=H.replace("0","");//如果是1-9 去掉前面的0
		}		
		return Integer.parseInt(H);
	}

	/**
	 * 获取当前月第一天
	 * @return
	 */
	public static String getCurMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();   
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}

	/**
	 * 获取当前月最后一天
	 * @return
	 */
	public static String getCurMonthLastDay() {  
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat simpleFormate = new SimpleDateFormat("yyyy-MM-dd");
		return simpleFormate.format(calendar.getTime());  
	}

	/**
	 * 获取当前日期的下一个日期
	 * @param day
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getDateLater(int day) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, day);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	/**
	 * 获取当前时间的前一个小时
	 * @param hour
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getDateBeforeHour(int hour) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.HOUR, hour);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
		return formatter.format(date);
	}

	/**
	 * 比较两个字符串类型的日期的大小
	 * 
	 * @param date1
	 *            "2014-02-12"
	 * @param date2
	 *            "2014-02-13"
	 * @return 1.date1>date2 0.date1=date2 -1.date1<date2
	 */
	public static int dateComparator(String date1, String date2) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		long s1 = 0L;
		long s2 = 0L;
		try {
			Date dateFirst = sd.parse(date1);
			Date dateSecond = sd.parse(date2);
			s1 = dateFirst.getTime();// 时间的毫秒
			s2 = dateSecond.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (s1 > s2) {
			return 1;
		} else if (s1 == s2) {
			return 0;
		} else {
			return -1;
		}
	}


	/**
	 * 比较两个字符串类型的日期的大小
	 * 
	 * @param date1
	 *            "2014-02-12 00:00:00"
	 * @param date2
	 *            "2014-02-13 00:00:00"
	 * @return 1.date1>date2 0.date1=date2 -1.date1<date2
	 */
	public static int dateComparator2(Date dateFirst, String date2) {
		//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		long s1 = 0L;
		long s2 = 0L;
		try {
			//Date dateFirst = sdf4.parse(date1);
			Date dateSecond = sdf4.parse(date2);
			s1 = dateFirst.getTime();// 时间的毫秒
			s2 = dateSecond.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (s1 >= s2) {
			return 1;
		} else {
			return -1;
		}
	}

	public static int dateComparator3(Date dateFirst, Date dateSecond) {	
		long s1 = dateFirst.getTime();
		long s2 = dateSecond.getTime();
		if (s1 > s2) {
			return 1;
		}else {
			return -1;
		}
	}
	/**
	 * 比较两个字符串类型的日期的大小
	 * 
	 * @param date1
	 *            "2014-02-12 00:00:00"
	 * @param date2
	 *            "2014-02-13 00:00:00"
	 * @return 1.date1>date2 0.date1=date2 -1.date1<date2
	 */
	public static int dateComparator4(String date1, String date2) {
		//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		long s1 = 0L;
		long s2 = 0L;
		try {
			Date dateFirst = sdf4.parse(date1);
			Date dateSecond = sdf4.parse(date2);
			s1 = dateFirst.getTime();// 时间的毫秒
			s2 = dateSecond.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (s1 >= s2) {
			return 1;
		} else {
			return -1;
		}
	}


	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取访问域名
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request){
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		String domain = url.replace(uri,"");
		return domain+"/";
	}

	/**
	 * 判断是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str) {
		try {
			Float.parseFloat(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}



	/**
	 * 判断字符串是否由数字组成
	 * @param str
	 * @return
	 */
	public static boolean judgeNumber(String str){
		boolean isNum = str.matches("[0-9]+"); 
		return isNum;
	}




	/**
	 *单位换算
	 * @return
	 */
	public static double unitConversion(String unit,int price){
		double rePrice=0L;
		if("元".equalsIgnoreCase(unit)){
			rePrice= (double)price;
		}else if("角".equalsIgnoreCase(unit)){
			rePrice=(double)price/(double)10;
		}else if("分".equalsIgnoreCase(unit)){
			rePrice=(double)price/(double)100;
		}	 
		return rePrice ;
	}

	/**
	 *获取前天的日期--yyyy-MM--dd
	 * @return
	 */
	public static String getTwoBef(){  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		//Date myDate1 = sdf.parse("2015-04-01");
		//c.setTime(myDate1);
		c.add(Calendar.DATE, -2);  
		Date day = c.getTime();
		String TwoBef = sdf.format(day);
		return TwoBef;
	}	


	/**
	 *获取昨天天的日期--yyyy-MM--dd
	 * @return
	 */
	public static String getOneBef(){  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		//Date myDate1 = sdf.parse("2015-04-01");
		//c.setTime(myDate1);
		c.add(Calendar.DATE, -1);  
		Date day = c.getTime();
		String oneBef = sdf.format(day);
		return oneBef;
	}	


	public static int getTotalDay(String year, String month) throws Exception{
		int day = 1;
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year),Integer.parseInt(month) - 1,day);
		int last = cal.getActualMaximum(Calendar.DATE);
		return last;
	}
	/**
	 * 获取指定年月的天 格式：yyyy-MM-dd
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public static String[] getTotalYearMonth(String year,String month)throws Exception{	
		if(month.length()==1){//页面js 有问题
			month="0"+month;
		}
		int monthLen=getTotalDay(year,month);
		String [] yearMonth=new String[monthLen];
		int day=1;
		for(int i=0;i<monthLen;i++){
			if(day<10){
				yearMonth[i]=year+"-"+month+"-"+"0"+day;
			}else{
				yearMonth[i]=year+"-"+month+"-"+day;
			}
			day++;
		}
		return yearMonth;
	}


	/**
	 * 获取指定年月的天 格式：yyyy-MM-dd
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public static String[] getTotalYearMonth2(String year,String month)throws Exception{	
		if(month.length()==1){//页面js 有问题
			month="0"+month;
		}
		int monthLen=getTotalDay(year,month);
		String [] yearMonth=new String[monthLen];
		int day=1;
		for(int i=0;i<monthLen;i++){
			if(day<10){
				yearMonth[i]="'"+year+"-"+month+"-"+"0"+day+"'";
			}else{
				yearMonth[i]="'"+year+"-"+month+"-"+day+"'";
			}
			day++;
		}
		return yearMonth;
	}

	/**
	 * 获取指定年月的天 格式：yyyy-MM
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public static String[] getYearMonth(String year)throws Exception{	

		String [] yearMonth=new String[12];
		int month=1;
		for(int i=0;i<12;i++){
			if(month<10){
				yearMonth[i]="'"+year+"-"+"0"+month+"'";
			}else{
				yearMonth[i]="'"+year+"-"+month+"'";
			}
			month++;
		}
		return yearMonth;
	}


	/**
	 * 获取指定年第某季月份 格式：yyyy-S
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public static String[] getYearSeason(String year,int seasonOrder)throws Exception{	
		String [] yearMonth=new String[3];
		if(1==seasonOrder){
			yearMonth[0]="'"+year+"-"+"01'";
			yearMonth[1]="'"+year+"-"+"02'";
			yearMonth[2]="'"+year+"-"+"03'";
		}else if(2==seasonOrder){
			yearMonth[0]="'"+year+"-"+"04'";
			yearMonth[1]="'"+year+"-"+"05'";
			yearMonth[2]="'"+year+"-"+"06'";
		}else if(3==seasonOrder){
			yearMonth[0]="'"+year+"-"+"07'";
			yearMonth[1]="'"+year+"-"+"08'";
			yearMonth[2]="'"+year+"-"+"09'";
		}else if(4==seasonOrder){
			yearMonth[0]="'"+year+"-"+"10'";
			yearMonth[1]="'"+year+"-"+"11'";
			yearMonth[2]="'"+year+"-"+"12'";
		}
		return yearMonth;
	}

	/**
	 * 字符串时间转换成long
	 * @param Date
	 * @return
	 * @throws ParseException 
	 */
	public static Long StringToLong(String Date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(Date).getTime();
	}

	/**
	 * 字符串时间转换成long
	 * @param Date
	 * @return
	 * @throws ParseException 
	 */
	public static void StringHMS(String Date) throws ParseException{
		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String sst="2016-08-24 01:06:54";
		System.out.println(sst.length());
		System.out.println(sst.substring(11));
	}
	
	/**
	 * 打卡时间减去12整/13整 的毫秒数
	 * @param endDate
	 * @param startDate
	 * @return
	 * @throws ParseException
	 */
	public static Long StringDateSubtract2(Date date,Date date2) throws ParseException{
		Long resultDate=date.getTime()-date2.getTime();
		return Math.abs(resultDate);
	}


	/**
	 * 截取上班时间小时/分钟
	 * @param resultDate
	 * @param flag
	 * @return
	 * @throws ParseException
	 */
	public static String StringMDsubString(Date resultDate,String flag) throws ParseException{
		String btn="";
		if("M".equals(flag)){
			btn=sdf4.format(resultDate).substring(5, 7);
		}else if("D".equals(flag)){
			btn=sdf4.format(resultDate).substring(8, 10);
		}
		return btn;
	}



	/**
	 * 截取上班时间小时/分钟
	 * @param resultDate
	 * @param flag
	 * @return
	 * @throws ParseException
	 */
	public static String StringHMsubString(String resultDate,String flag) throws ParseException{
		String btn="";
		if("H".equals(flag)){
			btn=resultDate.substring(0, 1);//截取第一位数字
			if("0".equals(btn)){
				btn=resultDate.substring(1, 2);//如果第一位为0，只要第二位
			}else{
				btn=resultDate.substring(0, 2);
			}			
		}else if("M".equals(flag)){
			btn=resultDate.substring(3, 4);
			if("0".equals(btn)){
				btn=resultDate.substring(4, 5);
			}else{
				btn=resultDate.substring(3, 5);
			}			
		}
		return btn;
	}

	/**
	 * 截取打卡年月日
	 * @param workDate
	 * @param flag
	 * @return
	 * @throws ParseException
	 */
	public static String StringYMDsubString(Date workDate) throws ParseException{
		return sdf5.format(workDate);
	}

	
	/**
	 * 截取月日
	 * @param date
	 * @param flag
	 * @return
	 * @throws ParseException
	 */
	public static String StringMDsubString(Date date) throws ParseException{
		String temp = sdf8.format(date);
		return Integer.parseInt(temp.substring(0, 2))+"."+Integer.parseInt(temp.substring(3, 5));
	}


	/**
	 * 截取小时分钟
	 * @param currentDate
	 * @return
	 */
	public static String StringCurrentDateHM(Date currentDate){
		return sdf4.format(currentDate).substring(11,16);	
	}

	/**
	 * 根据指定日期获取星期几
	 * @param Date
	 * @return
	 * @throws ParseException
	 */
	public static String getWeek(Date date) throws ParseException{
		//Date date=new Date(sdf4.parse(Date).getTime());		
		return sdf7.format(date);	
	}


	public static Date convertStringToDate(String Date) throws ParseException{
		return sdf4.parse(Date);
	}
	
	public static String convertDateToString(Date date) throws ParseException{
		return sdf4.format(date);
	}

	/**
	 * 获取当天下班时间的Date
	 * @throws ParseException 
	 */
	public static Date getCurrentDayArbitrarilyDate(int hour,int minute,int second) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		Date date = new Date(cal.getTimeInMillis());
		return sdf4.parse(sdf4.format(date));	
	}
	
	/**
	 * 获取指定之日下班时间的Date
	 * @throws ParseException 
	 */
	public static Date getSpecifyDate(Date date,int hour,int minute,int second) throws ParseException{
		/*Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, hour);
		cal.add(Calendar.MINUTE, minute);
		cal.add(Calendar.SECOND, second);*/
		long totl=hour*60*60*1000+minute*60*1000+second*1000;
		Date dateTemp = new Date(date.getTime()+totl);
		return sdf4.parse(sdf4.format(dateTemp));	
	}
	/**
	 * 获取指定之日下班时间的Date
	 * @throws ParseException 
	 */
	public static Date getSpecifyDatebyStr(Date date,String timestr) throws ParseException{
		return sdf4.parse((StringYMDsubString(date)+" "+timestr));	
	}
	
	public static void test(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-i;j++){
				if(array[j]>array[j+1]){
					int temp =array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		System.out.println(array);
	}
	
	 public static void main(String[] args) throws Exception {
		 
	      /*  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	        Date date = new Date();
	        System.out.println(getSpecifyDate(date,1,0,0));*/
		
	        //System.out.println( getEveryDay("2016-11"));
	        //System.out.println(sdf.format(getLastDate(date)));
		//System.out.println(monthSpace("2017-02-22 11:27:42","2017-05-21 11:27:42")) ;
		 stringToDate33("Thu May 25 16:41:06 CST 2017");
		/* int [] array = {4,6,9,2,5,};
		 test(array);*/
	    }
	    /**
	     * 获取上个月
	     * @param date
	     * @return
	     */
	    public static Date getLastDate(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.MONTH, -1);
	        return cal.getTime();
	    }
	    //由出生日期计算年龄 utile.Date --> int age
	    public static int getAgeByBirth(Date birthday) {
	        int age = 0;
	        try {
	            Calendar now = Calendar.getInstance();
	            now.setTime(new Date());// 当前时间
	
	            Calendar birth = Calendar.getInstance();
	            birth.setTime(birthday);
	
	            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
	                age = 0;
	            } else {
	                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
	                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
	                    age += 1;
	                }
	            }
	            return age;
	        } catch (Exception e) {//兼容性更强,异常后返回数据
	           return 0;
	        }
	    }
}
