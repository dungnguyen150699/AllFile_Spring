package com.java8.springboot.java.javareflection;

import java.lang.reflect.Field;

public class ReadMe {
	/* 
	 * * Attention! Field in Reflect is Intance not in Class
	 * Field []fields = this.clazz.getFields(); // Only get all field have access modify is PUBLIC
	 * Field field = this.clazz.getDeclaredField("longValue"); // Can get Field althrought it is private access;
	 * field.setAccessible(true); // After you get field by name should set Access it is ignor access(public,private,protect) by this way.
	 * field.get(model)  get Field value in Object class have Field
	 * field.set(model, 4l); set Field value in Object have Field
	 */

}
