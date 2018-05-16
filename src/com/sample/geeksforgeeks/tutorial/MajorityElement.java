package com.sample.geeksforgeeks.tutorial;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Write a program to find the majority element in the array. A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).  If input array doesn't contain a majority element, then output "NO Majority Element"
 * */
class ElementCount {
	public int count;

	ElementCount() {
		this.count = 1;
	}

	public void incCount() {
		++this.count;
	}
}

public class MajorityElement {
	public int getElement(int[] arr, int n) {
		HashMap<Integer, ElementCount> hMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hMap.containsKey(arr[i])) {
				hMap.get(arr[i]).incCount();
			} else {
				hMap.put(arr[i], new ElementCount());
			}
		}
		for (Entry<Integer, ElementCount> entry : hMap.entrySet()) {
			if (entry.getValue().count > n / 2)
				return entry.getKey();
		}
		return -1;
	}

	public static void main5(String[] args) {
		int[] arr = { 1, 2, 3 };// {3, 1, 3 ,3 ,2};
		int n = arr.length;
		MajorityElement obj = new MajorityElement();
		if (obj.getElement(arr, n) != -1) {
			System.out.println(obj.getElement(arr, n));
		} else {
			System.out.println("NO Majority Element");
		}
	}
}
