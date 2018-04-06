package com.dev.java.java8.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMaptoQuery {

	public static void main(String args[]) {
/*
 * Use Case : Convert the content of Map into name and value pair concatenate with '&' symbol
 * Ex : key : name :: value :: Dev
 * 		key : age :: value :: 28
 * 
 * Output = name=Dev&age=28
 * 
 * */
		
		Map<String, String> map = new HashMap<>();
		
		map.put("name", "Dev");
		map.put("MobileNo", "1234567890");
		
		String query = map.entrySet().stream().map(s->s.getKey()+"="+s.getValue()).collect(Collectors.joining("&"));
		System.out.println(query);
	}
}
