package com.java8.springboot.java.java8;

import org.springframework.util.Assert;

public class MessageFormatJava8 {
	public static void main(String[] args) {
		// Cais nayf nos gioonsg String format nhưng mà nó tự động chỉnh sửa string
		String text = 
			     java.text.MessageFormat.format("You''re about to delete {0} rows.", 5);
		System.out.println(text);
		
		// Đây là một phương pháp không yêu cầu chỉnh sửa mã và hoạt động bất kể số lượng ký tự.
		// Bời vì nó là thông điệp nên nó tự loại bỏ 1 số cái. Thêm ' ở đầu ký tự đó để nó hiện thị đầy đủ
		String text2 = 
				  java.text.MessageFormat.format(
				    "You're about to delete {0} rows.".replaceAll("'", "''"), 5);
		System.out.println(text2); // Result = "You're about to delete {0} rows."
		
		// Raw text
//		System.out.println(Assert.("You're about to delete {0} rows.");
		
//		String text ="tin;dung;;trang";
//		System.out.println(text.contains(""));
//		String []texts = text.split(";");
//		System.out.println(text.length());
//		for(String str : texts) {
//			System.out.println(str);
//			if(str.isEmpty()) System.out.println("xxx");
//		}
	}
}
