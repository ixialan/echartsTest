package com.tecsoon.www.action;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class Test2 {
	public  void main(String[] args) {
		fun2();
		fun3();
		
	}
	public static void fun1() {
		JSONObject jc = new JSONObject();
		jc.put("name", "xialan");
	}
	
	
	public static void fun2() {
		Person p = new Person("xialan",18);
		JSONObject jc = JSONObject.fromObject(p);
		System.out.println(jc.toString());
	}
	public static void fun3() {
		String xml ="<person><name>xialan</name><age>24</age></person>";
		XMLSerializer a = new XMLSerializer();
		
		JSONObject jc = (JSONObject)a.read(xml);
		
		
		System.out.println(jc.toString());
	}

}
