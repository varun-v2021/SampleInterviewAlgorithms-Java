package com.sample.amazon.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* This program sorts the alphanumeric value present in the string but doesn't modify the remaining string statement
 * 
 * */
public class VV2 {
	public static void lexicographSort() {
		List<String> list = new ArrayList<>();
		list.add("a1 this is a test");
		list.add("c0 12 54 76 89");
		list.add("f2 this is a nice");
		list.add("e1 this is a stupid");
		list.add("b2 34 67 12 55");
		System.out.println("Lexicographically sorting ...");
		System.out.println(list);
		List<String> sList = new ArrayList<>();
		for (String s : list) {
			sList.add(s.split(" ")[0]);
		}

		Collections.sort(sList);

		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i).replace(list.get(i).substring(0, 2), sList.get(i)));
		}

		System.out.println(list);
	}
}
