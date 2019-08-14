package com.tecsoon.www.action;


public class C {

	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		B b =new B();
//		b.haha();
	Class<?> c=Class.forName("");
//		Method[] m = c.getMethods();
//		for(Method mt:m) {
//			
//		}
	B ob=(B)c.newInstance();
	ob.haha();
	}
}
