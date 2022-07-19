package com.java8.springboot.java.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.thymeleaf.util.ArrayUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wrapper {
	private Integer x[];
	private int x1[] = {1,2,3,4};
	
	private static Byte[]b = {10,9,8,7,6,5};
	private static byte[]b1 = {1,2,3,4,5};
	
	// Dùng apache Common hoặc Guavua
	// Dùng Stream
	public void convertToInteger() {
//		this.setX(ArrayUtils.toIntegerArray(x1));
		this.setX(IntStream.of(this.x1).boxed().toArray(Integer[] :: new));
	}
	
	 public Byte[] toObjects(byte[] bytesPrim) {
	        Byte[] bytes = new Byte[bytesPrim.length];
	        Arrays.setAll(bytes, n -> bytesPrim[n]);
	        return bytes;
	 }
	 
	 public byte[] toPrimitives(Byte[] oBytes) {

	     byte[] bytes = new byte[oBytes.length];
	     for(int i = 0; i < oBytes.length; i++){
	         bytes[i] = oBytes[i];
	     }
	     return bytes;

	 }
	 
	public static void main(String[] args) {
		Wrapper wp = new Wrapper();
//		wp.convertToInteger();
//		Arrays.stream(wp.getX()).forEach(System.out :: print);
//		Arrays.stream(wp.toObjects(b1)).forEach(System.out :: print);
//		System.out.println();
//		for(byte i : b ) {
//			System.out.print( + i);
//		}
		
		Integer x = 9;
		int x1 = 10;
		x = x1;
		System.out.println(x + "--" + x1);
	}
}
