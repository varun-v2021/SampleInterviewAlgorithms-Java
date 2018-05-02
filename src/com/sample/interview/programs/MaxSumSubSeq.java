package com.sample.interview.programs;

import java.util.Collections;
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
					//subtract the largest of the subsequence
					sum -= arr[j - 1];
					//add the next sequence number
					sum += arr[j];
				} else {
					sum += arr[j];
				}
			}
		}
		//sort the stack in natural order to get highest at top
		Collections.sort(stack);
		System.out.println("Max sum of sub sequence is: "+stack.pop());
	}

	public static void MaxSumSubSeqTrigger() {
		int[] arr = { 1, 101, 2, 3, 110, 4, 5 };
		int size = arr.length;
		MaxSumSubSeq subSeq = new MaxSumSubSeq();
		subSeq.getMaxSum(arr, size);
	}
}
