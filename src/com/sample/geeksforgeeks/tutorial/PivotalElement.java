package com.sample.geeksforgeeks.tutorial;

public class PivotalElement {
	public static int getElement(int[] arr, int n) {
		int left = 0;
		int right = n - 1;
		int i = 1;
		// since 'i' cannot be first or last element according to requirement
		// for (int i = 1; i < n - 2; i++) {
		while (left < right) {
			if (i < right - 2 && i > left) {
				if (arr[i] > arr[left] && arr[i] < arr[right]) {
					// break condition as we have obtained the required element
					// by
					// comparing with all others
					// if (left == i - 1 && right == i + 1){
					// iteration through all the 'n' elements is complete
					if (left + right == n - 1) {
						return arr[i];
					}
					++left;
					--right;
				} else {
					// reset traversal indexes to original values and start
					// comparing the same with next 'i' element
					left = 0;
					right = n - 1;
					++i;
				}
			} else {
				return -1;
			}
		}
		return -1;
	}

	public static void main3(String[] args) {
		int[] arr ={7, 14 ,16 ,18};
		int n = arr.length;
		System.out.println(getElement(arr, n));
	}
}
