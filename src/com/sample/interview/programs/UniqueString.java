package com.sample.interview.programs;

public class UniqueString {
	public static String unique(String s) {
		String str = new String();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (str.indexOf(c) < 0) {
				str += c;
			}
		}
		return str;
	}
}
