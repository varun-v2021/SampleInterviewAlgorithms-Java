package com.sample.interview.programs;

import java.util.HashSet;

public class CheckDuplicatesWithinK {
	public static void CheckDuplicatesWithinKDistanceTrigger() {
		int[] arr = { 1, 2, 3, 1, 4 };
		boolean duplicatesPresent = check(arr, 3);
		if (duplicatesPresent)
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.println("another array for testing ...");
		int[] arr1 = { 1, 2, 3, 4, 1, 2, 3, 4 };
		duplicatesPresent = check(arr1, 3);
		if (duplicatesPresent)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static boolean check(int[] arr, int k) {
		HashSet<Integer> hSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (hSet.contains(arr[i]))
				return true;

			hSet.add(arr[i]);

			// Remove the k+1 distant item
			if (i >= k) {
				hSet.remove(arr[i - k]); // removing elements if the distance is
											// more than k
											// as they are not required
			}
		}
		return false;
	}
}
