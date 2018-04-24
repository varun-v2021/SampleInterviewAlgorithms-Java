package com.sample.interview.programs;

import com.sample.data.structures.Stack;

public class StringReverse {
	public static void reverse(StringBuffer str) {
		int n = str.length();
		Stack stack = new Stack(n);
		int i;
		for (i = 0; i < n; i++) {
			stack.push(str.charAt(i));
		}

		for (i = 0; i < n; i++) {
			char ch = stack.pop();
			str.setCharAt(i, ch);
		}
	}
}
