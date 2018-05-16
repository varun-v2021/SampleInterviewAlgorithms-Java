package com.sample.geeksforgeeks.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxOfSubarrayK {
	public static List<Integer> getMax(int[] arr, int k) {
		// length will remain k as counting starts from 0 ( 0 to k-1 = k)
		int counter = k;
		int startIndex = 0;
		System.out.println("arr.length "+arr.length);
		List<Integer> maxList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			// subarray exceeded 'k' length
			if (counter == 0) {
				int[] arrCopy = Arrays.copyOfRange(arr, startIndex, startIndex+k);
				sort(arrCopy, 0, arrCopy.length - 1);
				maxList.add(arrCopy[arrCopy.length - 1]);
				counter = k;
				startIndex = i;
			}
			--counter;
		}
		return maxList;
	}

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; ++j) {
			if (arr[j] <= pivot) {
				++i;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[high];
		arr[high] = arr[i + 1];
		arr[i + 1] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6, 1 };
		List<Integer> maxList = new ArrayList<>();
		int k = 2;
		maxList = getMax(arr, k);
		System.out.println(maxList.toString());
	}
}
