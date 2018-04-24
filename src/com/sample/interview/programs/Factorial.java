package com.sample.interview.programs;

public class Factorial {
	public static int factorial(int number){
		if(number == 0)
			return 1;
		return number * factorial(number -1);
	}
}
