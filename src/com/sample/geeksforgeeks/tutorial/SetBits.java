package com.sample.geeksforgeeks.tutorial;

public class SetBits {
	public static int getNoOfSetBits(int number){
		int count = 0;
		while(number > 0){
			count = count + (number & 1);
			number = number >> 1;
		}
		return count;
	}
	
	public static void main6(String[] args){
		System.out.println(getNoOfSetBits(6));
	}
}
