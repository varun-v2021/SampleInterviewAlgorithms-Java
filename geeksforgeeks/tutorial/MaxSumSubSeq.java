package com.sample.geeksforgeeks.tutorial;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class MaxSumSubSeq {
	public void getMaxSum(int[] arr, int n) {
		int i = 0, sum = 0;
		Stack<Integer> stack = new Stack<>();
		for (i = 0; i < n; i++) {
			sum = arr[i];
			for (int j = i + 1; j < n - 1; j++) {
				if (arr[j] < arr[j - 1]) {
					// denotes end of a sub sequence, store the result
					stack.push(sum);
					// subtract the largest of the subsequence
					sum -= arr[j - 1];
					// add the next sequence number
					sum += arr[j];
				} else {
					sum += arr[j];
				}
			}
		}
		// sort the stack in natural order to get highest at top
		Collections.sort(stack);
		if(!stack.isEmpty())
		System.out.println("Max sum of sub sequence is: " + stack.pop());
	}

	public static void main1(String[] args) {
		// Note that size of arr[] is considered 100 according to
		// the constraints mentioned in problem statement.
		int[] arr = new int[100];

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			int t = sc.nextInt();

			// One by one run for all input test cases
			while (t > 0) {
				// Input the size of the array
				int n = sc.nextInt();

				// Input the array
				for (int i = 0; i < n; i++)
					arr[i] = sc.nextInt();

				// Input the element to be searched
				int x = sc.nextInt();

				MaxSumSubSeq subSeq = new MaxSumSubSeq();
				// Compute and print result
				subSeq.getMaxSum(arr, arr.length);

				t--;
			}
		}
		sc.close();
	}
}
