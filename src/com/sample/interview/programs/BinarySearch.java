package com.sample.interview.programs;

/*Binary Search is performed on sorted array*/

public class BinarySearch {
	public static int search(int[] arr, int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r-1) / 2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				return search(arr, l, mid - 1, x);
			return search(arr, mid + 1, r, x);
		}
		return -1;
	}
}
