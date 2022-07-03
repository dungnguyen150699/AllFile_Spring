package com.java8.springboot.java.java8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Regex {
	/*
	 * Link học:https://www.w3schools.com/java/java_regex.asp
	 *  https://viettuts.vn/java/su-dung-regex-trong-java
	 * Lớp Matcher
		Nó implements interface MatchResult, cung cấp bộ máy xử lý biểu thức chính quy để thao tác với chuỗi ký tự.
		
		No.	Phương thức	Mô tả
		1	boolean matches()	kiểm tra xem biểu thức chính quy có khớp với mẫu hay không.
		2	boolean find()	tìm biểu thức tiếp theo khớp với mẫu.
		3	boolean find(int start)	tìm biểu thức tiếp theo khớp với mẫu từ số bắt đầu đã cho.
		4	String group()	trả về chuỗi con phù hợp.
		5	int start()	trả về vị trí bắt đầu của chuỗi con phù hợp.
		6	int end()	trả về vị trí kết thúc của chuỗi con phù hợp.
		7	int groupCount()	trả về tổng số các chuỗi con phù hợp.
	 * Lớp Pattern
		Đây là phiên bản được biên dịch của một biểu thức chính quy. Nó được sử dụng để xác định một mẫu cho bộ máy regex.
		
		No.	Phương thức	Mô tả
		1	static Pattern compile(String regex)	biên dịch regex đã cho và trả về thể hiện của Pattern.
		2	Matcher matcher(CharSequence input)	tạo một matcher khớp với đầu vào đã cho với mẫu.
		3	static boolean matches(String regex, CharSequence input)	Nó biên dịch biểu thức chính quy và tìm kiếm các chuỗi con từ chuỗi input phù hợp với mẫu regex.
		4	String[] split(CharSequence input)	chia chuỗi input đã cho thành mảng các kết quả trùng khớp với mẫu đã cho.
		5	String pattern()	trả về mẫu regex.
	 */
	
	public static String normalizerPhone(String phone) {
//		$ means "Match the end of the string" (the position after the last character in the string). 
//	^ vs $	Both are called anchors and ensure that the entire string is matched instead of just a substring.
        String regxCheckPhone = "^(84|\\+84|0+)[0-9]{9,10}$";
        String regxTakePhoneBody = "(?<=84|\\+84|0)[0-9]{9,10}$"; //Đừng quan tầm ?<= nó ghi sai đấy và nó dùng find nên ko lỗi thôi
        String regexCheckPhoneNoHead = "^[0-9]{9,10}$";
        try {
            if (!phone.matches(regxCheckPhone)) {
                if (phone.matches(regexCheckPhoneNoHead)) {
                    return String.format("%s%s", "84", phone);
                }
                return null;
            }

            Pattern pattern = Pattern.compile(regxTakePhoneBody, Pattern.MULTILINE);
            System.out.println(pattern);
            Matcher matcher = pattern.matcher(phone);
            System.out.println(matcher);
//            matcher.find();
            System.out.println(matcher.find());
            String phoneBody = matcher.group(0);
            System.out.println(phoneBody);
            String regexCheckZeros = "^0+[0-9]{9,10}";
            if (phoneBody.matches(regexCheckZeros)) {
                phoneBody = phoneBody.replaceFirst("^0+", "");
            }

            return String.format("%s%s", "84", phoneBody);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }


	public static void main(String[] args) {
//		sleep(10);
//		String str = normalizerPhone("84844311365");
//		System.out.println(str);
//		String str_test = "(\\+84|0)[0-9]{9,10}$";
//	    Pattern pattern = Pattern.compile(str_test, Pattern.MULTILINE);
//        Matcher matcher = pattern.matcher("0394311365");
//        System.out.println(matcher.find());
//		System.out.println("0394311365".matches(str_test));
		
		String regex = "\\s+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("\n");
		System.out.println(matcher.find());
		int c= 65279 , c1 = 8234;
		System.out.println((char) c + "----" + (char)c1 +"--");
	}
//	 public static void main(String[] args) {
//		    Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
//		    Matcher matcher = pattern.matcher("Visit W3Schools!");
//		    boolean matchFound = matcher.find();
//		    System.out.println(matcher.group(0));
//		    if(matchFound) {
//		      System.out.println("Match found");
//		    } else {
//		      System.out.println("Match not found");
//		    }
//		  }
}
