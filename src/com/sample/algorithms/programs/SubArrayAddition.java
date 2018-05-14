package com.sample.algorithms.programs;

import java.util.ArrayList;
import java.util.List;

import com.sample.interview.programs.QuickSort;

public class SubArrayAddition {
	public int subArray(int[] arr, int sum) {
		int n = arr.length;
		int start = 0;
		int curr_sum = arr[0];
		for (int i = 1; i <= n; i++) {
			while (curr_sum > sum && start < i - 1) {
				// removing trailing number if curr_sum exceeds sum
				curr_sum = curr_sum - arr[start];
				start++;
			}
			if (curr_sum == sum) {
				// indexing starts from 0
				// since we are printing only index of sub array
				// we are decrementing by 1 to reflect the same in output
				int p = i - 1;
				System.out.println("Subarray which equals sum is between " + start + " and " + p);
				return 1;
			}
			if(i<n)
			curr_sum += arr[i];
		}
		return 0;
	}
	
	public static void subArraySumTrigger(){
		SubArrayAddition subArrAdd = new SubArrayAddition();
		int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
		subArrAdd.subArray(arr, sum);
	}
}
