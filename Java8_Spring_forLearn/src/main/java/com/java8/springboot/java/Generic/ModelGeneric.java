package com.java8.springboot.java.Generic;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelGeneric<K, T, N> implements Serializable {
	/**
	 * Author Dũng T - Type (Kiểu dữ liệu bất kỳ thuộc Wrapper class: String,
	 * Integer, Long, Float, …) E – Element (phần tử – được sử dụng phổ biến trong
	 * Collection Framework) K – Key (khóa) V – Value (giá trị) N – Number (kiểu số:
	 * Integer, Double, Float, …) U,S,I,G, … (tùy theo kiểu của người dùng đặt) Sự
	 * thật là bạn đặt tên méo gì cũng đc tuy nhiên nên theo quy tắc trên này
	 * Genneric ko support kiểu nguyên thủy premitive
	 */
	K allowEkyc;
	T allowAdvanceEkyc;
	Boolean test;
//	E E;
	N N;
//	V V;

	public String toString() {
		return allowEkyc.toString() + allowAdvanceEkyc.toString() + test + "" + N;
	}

	// <K,V> : Nói rằng phương thức này có 2 kiểu tham số K,V
	// Phương thức trả về một đối tượng kiểu V.
	public static <K1, V> V getValue(Map<K1, V> entry) {
		V value = entry.values().stream().collect(Collectors.toList()).get(0);
		return value;
	}
	
	public static void main(String[] args) {
		Map map = new HashMap<Integer,String>();
		map.put(1, "mot");
		System.out.println(getValue(map));
	}
}
