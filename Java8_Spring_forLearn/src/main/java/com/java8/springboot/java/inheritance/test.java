package com.java8.springboot.java.inheritance;

import java.io.Serializable;

public class test implements Serializable {
	private Integer x ;
		
	private String str ;
	
	private Long l;
	
	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}
	
	public test(Integer x,String str) {
		this.x = x;
		this.str= str;
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	

	public test() {};

	public static void main(String...strings ) {
//		test t = new test();
//		t.setX(null);
//		System.out.println(t.getX() != null);
//		System.out.println(t.getStr() == null);
//		System.out.println(t.getL());
		try {
			try {
			throw new Exception();
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("xxx");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("xxx");
		}
		finally {
			System.out.println("hehe");
		}
		
	}
}
