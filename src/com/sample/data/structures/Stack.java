package com.sample.data.structures;

public class Stack {
	int size;
	int top;
	char arr[];

	public Stack(int n) {
		size = n;
		top = -1;
		arr = new char[n];
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public boolean push(char ele) {
		if (top < size) {
			top++;
			arr[top] = ele;
			return true;
		} else {
			System.out.println("Stackoverflow detected");
			return false;
		}
	}

	public char pop() {
		if (top >= 0) {
			char x = arr[top];
			top--;
			return x;
		} else {
			System.out.println("Stackunderflow detected");
			return 0;
		}
	}
}
