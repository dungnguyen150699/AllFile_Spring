package com.java8.springboot.java.inheritance;

import java.util.Arrays;
import java.util.Date;

import com.java8.springboot.java.inheritance.abtractA;
import com.java8.springboot.java.inheritance.interfaceA;

public class implementA implements interfaceA{
	
	public implementA() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public String println(String x) {
		// TODO Auto-generated method stub
//		System.out.println(super.str);
		return null;
	}
	
	public static void main(String...strings ) {
		new implementA().println("");
		abtractA a = new abtractA() {
			
			@Override
			public String println1(String x) {
				// TODO Auto-generated method stub
				return null;
			}
		};
/*		cant print by str is default
  		default u not need declare like public,private,protect
  		u cant declare variable abtract(interface ,abstract)
 * */

//		System.out.println(a.str); 
		
		System.out.println(status.exports.code);
//		System.out.println();
		implementA implementA = new implementA();
		
		System.out.println(Arrays.asList(1,0).contains(1));
	}
	
	private Date date;
	
	public void setDate(Date date) {
		this.date = date;
	}
}
enum status{
	exports(1), imports(2);
	public int code;
	status(int code){
		this.code = code;
	}
}