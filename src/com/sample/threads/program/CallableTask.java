package com.sample.threads.program;

import java.util.concurrent.Callable;

/*Calculate factorial of a number*/
public class CallableTask implements Callable<Integer> {

	int number;

	public CallableTask(int i) {
		// TODO Auto-generated constructor stub
		this.number = i;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int fact = 1;
		for (int count = number; count > 1; count--) {
			fact = fact * count;
		}
		return fact;
	}

}
