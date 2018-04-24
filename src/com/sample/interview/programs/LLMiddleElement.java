package com.sample.interview.programs;

import com.sample.interview.programs.LinkedList.Node;

public class LLMiddleElement {
	public void middleElement(Node head) {
		Node slow_ptr = head;
		Node fast_ptr = head;
		if (head != null) {
			while (fast_ptr != null && fast_ptr.next != null) {
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next.next;
			}
			System.out.println("Middle element is : " + slow_ptr.data);
		}
	}
}
