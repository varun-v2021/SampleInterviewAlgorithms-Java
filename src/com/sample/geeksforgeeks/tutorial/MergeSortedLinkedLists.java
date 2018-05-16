package com.sample.geeksforgeeks.tutorial;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class MergeSortedLinkedLists {
	public static Node merge(Node head1, Node head2) {
		Node mergedList = null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data < head2.data) {
			mergedList = head1;
			mergedList.next = merge(head1.next, head2);
		} else {
			mergedList = head2;
			mergedList.next = merge(head2.next, head1);
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

	public static void main4(String[] args) {
		int[] data1 = { 1, 3, 5, 9 };
		Node head1 = new Node(data1[0]);
		for (int count = 1; count < data1.length; count++)
			MergeSortedLinkedLists.insert(head1, data1[count]);

		System.out.printf("Linked list 1 is : ");
		MergeSortedLinkedLists.print(head1);

		int[] data2 = { 2, 4, 5, 6, 10 };
		Node head2 = new Node(data2[0]);
		for (int count = 1; count < data2.length; count++)
			MergeSortedLinkedLists.insert(head2, data2[count]);

		System.out.printf("Linked list 2 is : ");
		MergeSortedLinkedLists.print(head2);

		Node mergedList = MergeSortedLinkedLists.merge(head1, head2);
		System.out.printf("Merged Linked list is : ");
		MergeSortedLinkedLists.print(mergedList);
	}
}
