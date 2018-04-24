package com.sample.interview.programs;

public class KLargest {
	public void getKLargestElements(int[] arr, int k) {
		int l = 0;
		int r = arr.length;
		sort(arr, l, r - 1);

		for (int i = r-1; i > k; --i) {
			System.out.println(arr[i]);
		}

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
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
