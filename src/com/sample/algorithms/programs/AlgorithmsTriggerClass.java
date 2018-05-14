package com.sample.algorithms.programs;

public class AlgorithmsTriggerClass {
	public void trigger() {
		MissingNumber mNo = new MissingNumber();
		int[] x = { 1, 2, 3, 5 };
		System.out.println(mNo.getMissingNumber(x));
		
		SubArrayAddition.subArraySumTrigger();
		CountZOT.sort012Trigger();
	}
}
