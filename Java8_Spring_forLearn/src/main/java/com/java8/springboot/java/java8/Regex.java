package com.java8.springboot.java.java8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;


// Nguồn // https://viblo.asia/p/regular-expressions-regex-khong-he-kho-nhu-nhung-gi-ban-thay-ii-L4x5xg3YlBM
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
		6   ?=.* Dùng để check nó có ký thứ nào phù hợp ko
		7   ?= Bằng với ==, equal trong java
		8   ?! Bằng với != java
	 */
	
	// Biển số xe bao gồm ít nhất 1 chữ và 1 số           ?=.*
	public static final String REGISTER_NO_OTHER = "(?=.*\\d)(?=.*[a-zA-Z])(([a-zA-Z0-9]{1,8})-([a-zA-Z0-9]{1,8}))";
	public static final String CHECK_REVESER = "(\\w)(\\w)\\2\\1";
	public static final String CHECK_DUPLICATE_2C= "(\\w)\\1";
	public static final String CHECK_NO_DUPLICATE_2C= "(?:(\\w)(?!\\1))+$";
	/*
	let e=/(\w)(\w)\2\1/; // Biểu thức trong () được nghi nhớ , Biểu thức /1 ghi nhớ () thứ nhất /2() ghi nhớ () thứ 2
	e.test("aabb"); //false // Và tóm lại cái này sẽ đảo ngược thì nó mới đúng
	e.test("abba"); //true 
	e.test("abab"); //false
	
	\w đại diện cho tất cả các ký tự chữ và số, nếu bạn viết hoa w thành W, điều đó có nghĩa là \W đại diện cho tất cả các ký tự không phải số và chữ.
	( ) biểu thức trong dấu ngoặc đơn được ghi nhớ cho lần sử dụng sau.
	\1 ghi nhớ và sử dụng kết quả phép match của biểu thức đầu tiên ở trong dấu ngoặc đơn, \2 sử dụng cho cặp dấu ngoặc đơn thứ 2.
	a(?!b) một tập hợp của dấu ngoặc đơn, dấu hỏi chấm và dấu chấm than (?!), gọi là biểu thức look ahead, nó match với a khi và chỉ khi a không được theo sau bởi b.
	a(?=b) match với a khi và chỉ khi a được theo sau bởi b.
	(?:a) nhóm mà nó có thể quên, nó tìm kiếm a nhưng không ghi nhớ nó, bạn không thể sử dụng \1 để dùng lại kết quả phép match.
	*/
	
	public boolean matcher(String str ,String regex) {
		return str.matches(regex);
	}
	
	public static void main(String[] args) {		
		Regex rg = new Regex();
		System.out.println(rg.matcher("abba", CHECK_REVESER)); // true
		System.out.println(rg.matcher("ab", CHECK_DUPLICATE_2C)); // false
		System.out.println(rg.matcher("bb", CHECK_DUPLICATE_2C)); // true
		System.out.println(rg.matcher("bb", CHECK_NO_DUPLICATE_2C)); // false
		System.out.println(rg.matcher("ab", CHECK_NO_DUPLICATE_2C)); // false
	}

}

class RegexPattern {
    public static void main(String[] args) {
        String strTest = "Regex 15-05-2020, Nguyen Minh Duc 16/02/1998. Deadline 18_02_2020";
        Pattern patternDate = Pattern.compile("\\d{2}[-|/]\\d{2}[-|/]\\d{4}");
        Matcher matcher = patternDate.matcher(strTest);
         
        System.out.println("Ngày tháng năm trong chuỗi đầu vào: " + strTest +" là:");
        while(matcher.find()) {
            System.out.println(strTest.substring(matcher.start(), matcher.end()));
        }         
        String strTest2 = "15/05/2020";
        String strTest3 = "16/02/mdse";
        patternDate = Pattern.compile("^\\d{2}[-|/]\\d{2}[-|/]\\d{4}$");
        System.out.println("Chuỗi " + strTest2 + " có định dạng ngày tháng: "
                + patternDate.matcher(strTest2).matches());
         
        System.out.println("Chuỗi " + strTest3 + " có định dạng ngày tháng: "
                + patternDate.matcher(strTest3).matches());
    } 
}


class RegexCheck_RequireByCondition{

//    public boolean checkIfHaveNumber_AnyWhereInString(String str){
//        Pattern pattern =
//    }
}