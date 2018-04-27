package com.sample.interview.programs;

import java.util.HashSet;

/*
 * 1) Initialize an empty hash table s.
	2) Do following for each element A[i] in A[]
   (a)    If s[x - A[i]] is set then print the pair (A[i], x - A[i])
   (b)    Insert A[i] into s.
 * 
 * */
public class PairSum {
	public static void pairSumTriggerFunction() {
		int[] A = { 2, 4, 6, 10, 9 };
		int x = 16;
		printPairs(A, x);
	}

	public static void printPairs(int[] arr, int x) {
		HashSet<Integer> hSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int temp = x - arr[i];
			if (temp >= 0 && hSet.contains(temp))
				System.out.println("Elements which add upto " + x + " are " + arr[i] + " & " + temp);
			hSet.add(arr[i]);
		}
	}
}
