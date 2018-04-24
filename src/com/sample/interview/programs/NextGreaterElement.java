package com.sample.interview.programs;

public class NextGreaterElement {
	static class Stack {
		int top = -1;
		int[] items = new int[100];

		public void push(int ele) {
			if (top == 99) {
				System.out.println("Overflow detected");
			} else {
				items[++top] = ele;
			}
		}

		public int pop() {
			if (top == -1) {
				System.out.println("Underflow detected");
				return -1;
			} else {
				int element = items[top];
				--top;
				return element;
			}
		}

		public boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}

	void printNGE(int[] arr, int n) {
		int next, ele;
		Stack stack = new Stack();
		// store the first element as reference as we have to find greater
		// elements towards right of first element
		stack.push(arr[0]);
		// start looping from next element
		for (int i = 1; i < n; i++) {
			next = arr[i];
			if (stack.isEmpty() == false) {
				// if stack is not empty, then
				// pop an element from stack
				ele = stack.pop();

				/*
				 * If the popped element is smaller than next, then a) print the
				 * pair b) keep popping while elements are smaller and stack is
				 * not empty
				 */
				while (next > ele) {
					System.out.println(ele + "--->" + next);
					if (stack.isEmpty() == true) {
						break;
					}
					ele = stack.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (ele > next) {
					stack.push(ele);
				}
			}
			/*
			 * push next to stack so that we can find next greater for it
			 */
			stack.push(next);
		}

		while (stack.isEmpty() == false) {
			ele = stack.pop();
			next = -1;
			System.out.println(ele + "--->" + next);
		}
	}

	public void printNGETrigger() {

		int arr[] = { 11, 13, 21, 3 };
		int n = arr.length;
		printNGE(arr, n);

	}
}
