package com.sample.interview.programs;

class Node {
	public int data;
	public Node next;

	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}

public class MergeLinkedLists {

	public static Node merge(Node head1, Node head2) {
		Node mergedList = null;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.data < head2.data) {
			// point to smaller element
			mergedList = head1;
			mergedList.next = merge(head1.next, head2);
		} else { // head1 is large, so pass h
			// point to smaller element
			mergedList = head2;
			// head2 is already consider
			// now process next node of head2
			mergedList.next = merge(head1, head2.next);
		}
		return mergedList;
	}

	public static void insert(Node head, int data) {
		while (head.next != null)
			head = head.next;
		head.next = new Node(data);
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.printf("%d ", head.data);
			head = head.next;
		}
		System.out.println("");
	}

	public static void mergeLinkedListsTrigger() {
		int[] data1 = { 1, 3, 5, 9 };
		Node head1 = new Node(data1[0]);
		for (int count = 1; count < data1.length; count++)
			MergeLinkedLists.insert(head1, data1[count]);

		System.out.printf("Linked list 1 is : ");
		MergeLinkedLists.print(head1);

		int[] data2 = { 2, 4, 5, 6, 10 };
		Node head2 = new Node(data2[0]);
		for (int count = 1; count < data2.length; count++)
			MergeLinkedLists.insert(head2, data2[count]);

		System.out.printf("Linked list 2 is : ");
		MergeLinkedLists.print(head2);

		Node mergedList = MergeLinkedLists.merge(head1, head2);
		System.out.printf("Merged Linked list is : ");
		MergeLinkedLists.print(mergedList);
	}
}