package com.sample.algorithms.programs;

public class MissingNumber {
	public int getMissingNumber(int[] arr){
		int n = arr.length;
		int expectedSum = (n+1) * (n + 2) / 2;
		int realSum = 0;
		for(int i : arr){
			realSum += i;
		}
		System.out.println("Missing number is :");
		return expectedSum - realSum;
	}
	
}
