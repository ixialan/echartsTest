package com.tecsoon.www.common;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import org.apache.commons.beanutils.Converter;

/**
* 重写日期转换
*
* @author XXX
*/
//public class DateConvert implements Converter {
//
//   public Object convert(Class arg0, Object arg1) {
////       String p = (String) arg1;
//       String dateStr = "";
//       if (arg1 instanceof java.util.Date) {
//    	   java.util.Date date = (java.util.Date) arg1;
//    	   dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
//       }
//       
//       if (arg1 instanceof java.sql.Date) {
//    	   java.sql.Date date = (java.sql.Date) arg1;
//    	   dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
//       }
//       
//       if (dateStr == null || dateStr.trim().length() == 0) {
//           return null;
//       }
//       
//       try {
//           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//           return df.parse(dateStr.trim());
//       } catch (Exception e) {
//           try {
//               SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//               return df.parse(dateStr.trim());
//           } catch (ParseException ex) {
//               return null;
//           }
//       }
//
//   }
//
//}