package com.sample.amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VV {

	public void maxOccurence(String wordText, List<String> wordsExcept) {
		String[] input = wordText.split(" ");
		List<String> inputLst = new ArrayList<>();
		// inputLst = Arrays.asList(wordText);
		// inputLst.removeAll(wordsExcept);

		HashMap<String, Integer> hMap = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			if (hMap.get(input[i]) == null) {
				hMap.put(input[i], 1);
			} else {
				int value = hMap.get(input[i]).intValue();
				value++;
				hMap.put(input[i], value);
			}
		}

		List<String> topOccurence = findMaxOccurrence(hMap, 2);
		System.out.println("Max frequency words in the string ...");
		System.out.println(topOccurence);
	}

	public static List<String> findMaxOccurrence(Map<String, Integer> hMap, int count) {
		List<MyComparable> l = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : hMap.entrySet()) {
			l.add(new MyComparable(entry.getKey(), entry.getValue()));
		}

		Collections.sort(l);
		List<String> list = new ArrayList<>();
		// count : no of required max occurrences
		for (MyComparable my : l.subList(0, count)) {
			list.add(my.wordFromString);
		}
		return list;
	}

	public static void maxOccurenceTrigger() {
		VV vv = new VV();
		List<String> except = new ArrayList<>();
		except.add("and");
		except.add("up");
		except.add("the");
		String str = "jack and jill went up the hill jack jill";
		vv.maxOccurence(str, except);
	}
}


class MyComparable implements Comparable<MyComparable> {
	public String wordFromString;
	public int noOfOccurence;

	MyComparable(String word, int noOfOccurence) {
		this.wordFromString = word;
		this.noOfOccurence = noOfOccurence;
	}

	@Override
	public int compareTo(MyComparable arg) {
		int myCompare = Integer.compare(arg.noOfOccurence, this.noOfOccurence);
		return myCompare != 0 ? myCompare : wordFromString.compareTo(arg.wordFromString);
	}
}
