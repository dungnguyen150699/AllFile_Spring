package com.java8.springboot.java.inheritance;

import org.springframework.lang.NonNull;


public class A_impl extends abtractA implements interfaceA {

	@Override
	public String println(String x) {
		// TODO Auto-generated method stub
		System.out.println(x);
		return null;
	}

	@Override
	public String println1(String x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//https://www.tabnine.com/code/java/classes/org.springframework.lang.NonNull //validate method java
	@NonNull
	public Integer testNonNull() {
		return null;
	}

	public static void main(String[] args) {
		A_impl a_impl = new A_impl();
//		a_impl.println("xxx");
//		a_impl.str = "dung"; you can modify
//		a_impl.str1 = "dung1"; // can modify bc it not abtract
//		System.out.println(a_impl.str +"-------"+ a_impl.str1);
		
		// Still can Null
//		interfaceA interfaceA = new A_impl();
//		System.out.println(interfaceA.println("xx_heehe"));
//		System.out.println(a_impl.testNonNull());
	}

}
