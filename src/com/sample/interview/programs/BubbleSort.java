package com.sample.interview.programs;

public class BubbleSort {
	public static void sort(int[] arr){
		for(int i =0;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				if(arr[j] < arr[i]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void BubbleSortTrigger(){
		int[] arr = {9,8,7,6,5};
		System.out.println("Input array ...");
		for(int i:arr){
			System.out.print(i+" ");
		}
		System.out.println();
		sort(arr);
		System.out.println("Sorted array ...");
		for(int i:arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
