package com.sample.interview.programs;

public class PythagoreanTriplet {

	/*
	 * We can solve this in O(n2) time by sorting the array first.
	 * 
	 * 1) Do square of every element in input array. This step takes O(n) time.
	 * 
	 * 2) Sort the squared array in increasing order. This step takes O(nLogn)
	 * time.
	 * 
	 * 3) To find a triplet (a, b, c) such that a = b + c, do following.
	 * 
	 * Fix ‘a’ as last element of sorted array. Now search for pair (b, c) in
	 * subarray between first element and ‘a’. A pair (b, c) with given sum can
	 * be found in O(n) time using meet in middle algorithm discussed in method
	 * 1 of this post. If no pair found for current ‘a’, then move ‘a’ one
	 * position back and repeat step 3.2.
	 * 
	 */
	public boolean findPythagoreanTriplet(int[] arr, int n) {

		int low = 0;
		int high = arr.length - 1;

		// Sort array elements
		sort(arr, low, high);
		
		// Square array elements
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}


		// Now fix one element one by one and find the other two
		// elements
		for (int i = n - 1; i >= 2; i--) {
			// To find the other two elements, start two index
			// variables from two corners of the array and move
			// them toward each other
			int l = 0; // index of the first element in arr[0..i-1]
			int r = i - 1; // index of the last element in arr[0..i-1]
			while (l < r) {
				// A triplet found
				if (arr[l] + arr[r] == arr[i])
					return true;

				// Else either move 'l' or 'r'
				if (arr[l] + arr[r] < arr[i])
					l++;
				else
					r--;
			}
		}

		// If we reach here, then no triplet found
		return false;
	}

	// Using quick sort technique
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
		for (int j = low; j <= high - 1; ++j) {
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

	public void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
