package com.tecsoon.www.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.tecsoon.www.vo.Sys_user;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TSCommonUtil {
	
	/**
	 * 
	 */
	public static String nullToStr(String strParam) {
		if (null == strParam || "null".equalsIgnoreCase(strParam)) {
			return "";
		} else {
			return strParam;
		}
	}
	
	/**
	 * 判断变量是否为空
	 * @param s 
	 * @return 
	 */
	public static boolean isEmpty(String s) {
		
		// 直接用这种方式判断
		StringUtils.isBlank(s);
		
		if (null == s || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 去除字符串前后的空格
	 * @param s
	 * @return
	 */
	public static String trim(String s) {
		if(null == s) {
			return "";
		} else {
			return s.trim();
		}
	}

	/**
	 * 用来去掉List中空值和相同项的。
	 * @param list
	 * @return
	 */
	public List<String> removeSameItem(List<String> list) {
		List<String> difList = new ArrayList<String>();
		for (String t : list) {
			if (t != null && !difList.contains(t)) {
				difList.add(t);
			}
		}
		return difList;
	}

	/**
	 * 天数加一
	 * @param dateTime
	 * @return
	 * @throws Exception
	 */
	public static String dateFamte(String dateTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dateTime);
		Calendar calendar = Calendar.getInstance();//日历对象
		calendar.setTime(date);//设置当前日期
		calendar.add(Calendar.DAY_OF_MONTH, 1);//天数加一
		return format.format(calendar.getTime());
	}

	/**
	* 日期转换成字符串
	* @param date 
	* @return str
	*/
	public static String DateToString(Date date) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String str = format.format(date);
	   return str;
	}
	
	
	/** 
	 * 字符串转换为java.util.Date<br> 
	 * 支持格式为 yyyy.MM.dd G 'at' hh:mm:ss <br> 
	 * @param time String 字符串<br> 
	 * @return Date 日期<br> 
	 */ 
	public static Date stringToDate(String time){
		SimpleDateFormat formatter; 
		int tempPos=time.indexOf("AD") ; 
		time=time.trim() ; 
		formatter = new SimpleDateFormat ("yyyy.MM.dd G 'at' hh:mm:ss z"); 
		if (tempPos>-1) {
			time=time.substring(0,tempPos)+ 
					"公元"+time.substring(tempPos+"AD".length());//china 
			formatter = new SimpleDateFormat ("yyyy.MM.dd G 'at' hh:mm:ss z"); 
		}
		tempPos=time.indexOf("-"); 
		if (tempPos>-1&&(time.indexOf(" ")<0)) {
			formatter = new SimpleDateFormat ("yyyyMMddHHmmssZ"); 
		} else if ((time.indexOf("/")>-1) &&(time.indexOf(" ")>-1)) {
			formatter = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss"); 
		} else if((time.indexOf("-")>-1) &&(time.indexOf(" ")>-1)){
			formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
		} else if((time.indexOf("/")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)) {
			formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a"); 
		} else if((time.indexOf("-")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)) {
			formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a"); 
		}
		ParsePosition pos = new ParsePosition(0); 
		java.util.Date ctime = formatter.parse(time, pos); 

		return ctime; 
	}
	
	/**
     * 从一个JSON数组得到一个java对象数组，形如：
     * [{"id" : idValue, "name" : nameValue}, {"id" : idValue, "name" : nameValue}, ...]
     * @param object
     * @param clazz
     * @return
     */
    public static Object[] getDTOArray(String jsonString, Class<?> clazz){
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];
        for(int i = 0; i < array.size(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz);
        }
        return obj;
    }
	
	/** 
	 * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br> 
	 * @param time Date 日期<br> 
	 * @return String   字符串<br> 
	 */ 
	public static String dateToString(Date time){
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
		String ctime = formatter.format(time); 

		return ctime; 
	}

	/** 
	 * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss a'(12小时制)<br> 
	 * @param time Date 日期<br> 
	 * @param x int 任意整数如：1<br> 
	 * @return String 字符串<br> 
	 */ 
	public static String dateToString(Date time,int x){
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a"); 
		String ctime = formatter.format(time); 

		return ctime; 
	}

	/** 
	 *取系统当前时间:返回只值为如下形式 
	 * @return String 
	 */ 
	public static String Now(){
		return dateToString(new Date()); 
	}

	/** 
	 *取系统当前时间:返回只值为如下形式 
	 *@param hour 为任意整数 
	 *@return String 
	 */ 
	public static String nowDate(int hour){
		return dateToString(new Date(),hour); 
	}

	/** 
	 *取系统当前时间:返回值为如下形式 
	 *@return String 
	 */ 
	public static String getYYYY_MM_DD(){
		return dateToString(new Date()).substring(0,10); 

	}

	/** 
	 *取系统给定时间:返回值为如下形式 
	 *@return String 
	 */ 
	public static String getYYYY_MM_DD(String date){
		return date.substring(0,10); 

	}

	public static String getHour(){
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("H"); 
		String ctime = formatter.format(new Date()); 
		return ctime; 
	}

	public static String getDay(){
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("d"); 
		String ctime = formatter.format(new Date()); 
		return ctime; 
	}

	public static String getMonth(){
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("M"); 
		String ctime = formatter.format(new Date()); 
		return ctime; 
	}

	public static String getYear(){
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("yyyy"); 
		String ctime = formatter.format(new Date()); 
		return ctime; 
	}

	public static String getWeek(){
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("E"); 
		String ctime = formatter.format(new Date()); 
		return ctime; 
	}

	/**
	* 字符串转换成日期
	* @param str
	* @return date
	*/
	public static Date StringToDate(String str) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   Date date = null;
	   try {
	    date = format.parse(str);
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}

	/**
	 * 根据key值输出异常配置文件中异常信息。
	 * @param key 要输出的异常信息key值
	 * @return 异常信息
	 * @throws IOException
	 */
	public static String getExceptionPropertiesText(String key) {
        String path = TSCommonUtil.class.getClassLoader().getResource("ApplicationResources.properties").getPath();
        
        FileInputStream in;
        Properties prop = null;
		try {
			in = new FileInputStream(path);
			prop = new Properties();
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
		String strVal = prop.getProperty(key);
		
		if (isEmpty(strVal)) {
			return "没有找到与该键对应的值！";
		}
		
		return strVal;
	}
	
	/**
	 * 根据properties文件名和key值输出异常配置文件中异常信息。
	 * @param propName 文件名
	 * @param key 异常信息key值
	 * @return 异常信息
	 */
	public static String getPropertiesText(String propName, String key) {
        String path = TSCommonUtil.class.getClassLoader().getResource(propName).getPath();
        
        FileInputStream in;
        Properties prop = null;
		try {
			in = new FileInputStream(path);
			prop = new Properties();
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
		String strVal = prop.getProperty(key);
		
		if (isEmpty(strVal)) {
			return "没有找到与该键对应的值！";
		}
		
		return strVal;
	}
	
//	public static Map<String, Object> getLoginInfo() {
//    	Map<String, Object> attibutes = ActionContext.getContext().getSession();
//    	UserInfo user = null;
//    	if (attibutes != null && attibutes.size() != 0) {
//    		user = new UserInfo();
//    		user.setUserName(attibutes.get("username").toString());
//    		user.setUserPass(attibutes.get("password").toString());
//    	}
//		return attibutes;
//	}
	
	public static Map<String, Object> getLoginInfo() {
	Map<String, Object> attibutes = ActionContext.getContext().getSession();
	Sys_user user = null;
	if (attibutes != null && attibutes.size() != 0) {
		user = new Sys_user();
		user.setUser_nm(attibutes.get("username").toString());
		user.setPassword(attibutes.get("password").toString());
	}
	return attibutes;
}
	
	public static Sys_user getLoginUser() {
    	Map<String, Object> attibutes = ActionContext.getContext().getSession();
    	if (attibutes != null && attibutes.size() != 0) {
    		return (Sys_user) attibutes.get("user");
    	} else {
    		return new Sys_user();
    	}
	}
	
}
