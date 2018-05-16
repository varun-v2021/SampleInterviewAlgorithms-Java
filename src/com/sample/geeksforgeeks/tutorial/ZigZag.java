package com.sample.geeksforgeeks.tutorial;

import java.util.Arrays;

public class ZigZag {
	public static void zigZagArrangement(int[] arr) {
		boolean flag = true;
		for (int i = 0; i <= arr.length - 2; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag;
		}
	}

	public static void main1(String[] args) {
		int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
		ZigZag.zigZagArrangement(arr);
		System.out.println(Arrays.toString(arr));
	}
}
