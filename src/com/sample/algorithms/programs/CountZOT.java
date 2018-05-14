package com.sample.algorithms.programs;

public class CountZOT {
	static void sort012(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0, temp;
		while (mid <= hi) {
			switch (arr[mid]) {
			case 0:
				temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp;
				hi--;
				break;
			}
		}
	}

	/* Utility function to print array arr[] */
	static void printArray(int arr[], int arr_size) {
		int i;
		for (i = 0; i < arr_size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	/* Driver function to check for above functions */
	public static void sort012Trigger() {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		sort012(arr);
		System.out.println("Array after seggregation ");
		printArray(arr, arr_size);
	}
}
