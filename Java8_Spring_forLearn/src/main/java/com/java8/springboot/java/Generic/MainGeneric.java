package com.java8.springboot.java.Generic;

import java.util.Arrays;
import java.util.List;

public class MainGeneric implements InterfaceGeneric<List, Void>{
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1","2","3");
		ModelGeneric<List<String>, Boolean,Boolean> model = new ModelGeneric(list,true,null,true);
		String str = model.toString();
		System.out.println(str);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void showHello() {
		// TODO Auto-generated method stub
		return null;
	}

}
