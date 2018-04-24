package com.sample.interview.programs;

import com.sample.interview.programs.LinkedList.Node;

public class LLPairwiseSwap {
	public void pairwiseSwapElements(Node head){
		Node temp = head;
		while(temp != null && temp.next != null){
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
	}
}
