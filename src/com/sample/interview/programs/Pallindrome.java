package com.sample.interview.programs;

public class Pallindrome {
	public static void isPallindrome(int number){
		int temp = number;
		int reverse = 0;
		while(number !=0 ){
			int rem = number % 10;
			reverse = reverse * 10 + rem;
			number = number/10;
		}
		if(temp ==  reverse)
			System.out.println("Number: "+temp+" is pallindrome");
		else
			System.out.println("Number: "+temp+" is not pallindrome");
	}
}
