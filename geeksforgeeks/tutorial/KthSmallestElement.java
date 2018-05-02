package com.sample.geeksforgeeks.tutorial;

import java.util.Scanner;

public class KthSmallestElement {
	public int getKthSmallestElement(int[] arr, int n, int k) {
		sort(arr, 0, n-1);
		for (int i = 0; i < n; i++) {
			if (i == k - 1)
				return arr[i];
		}
		return -1;
	}

	public void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j <= high-1; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		/*KthSmallestElement obj = new KthSmallestElement();
		//int[] arr = { 7, 10, 4, 3, 20, 15 };
		int[] arr = {7 ,10 ,4 ,20 ,15};
		int k = 4;
		System.out.println(obj.getKthSmallestElement(arr, arr.length, k));*/
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = s.nextInt();
			}
			int k = s.nextInt();
			KthSmallestElement obj = new KthSmallestElement();
			// Compute and print result
			System.out.println(obj.getKthSmallestElement(arr, arr.length, k));
		}
	}
}
