package com.java8.springboot.java.inheritance;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

// if not declare accessmodify in interface it is public(no have private)
public interface interfaceA {
	public String str= "interface";
	
	@NonNull
	public String println(String x);
}
