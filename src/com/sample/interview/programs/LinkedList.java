package com.sample.interview.programs;

import com.sample.interview.programs.LinkedList.Node;

public class LinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * /* This function is in LinkedList class. Inserts a new Node at front of
	 * the list. This method is defined inside LinkedList class shown above
	 */
	public void push(int d) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(d);
		/* 3. Make next of new Node as head */
		new_node.next = head;
		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	public void insertAfter(Node prev_node, int new_data) {
		if (prev_node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		Node new_node = new Node(new_data);
		/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;
		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
	}

	public void append(int new_data) {
		/*
		 * 1. Allocate the Node & 2. Put in the data 3. Set next as null
		 */
		Node new_node = new Node(new_data);
		/*
		 * 4. If the Linked List is empty, then make the new node as head
		 */
		if (head == null) {
			head = new Node(new_data);
			return;
		}
		/*
		 * 4. This new node is going to be the last node, so make next of it as
		 * null
		 */
		new_node.next = null;
		Node last = head;
		/* 5. Else traverse till the last node */
		while (last.next != null) {
			last = last.next;
		}
		/* 6. Change the next of last node */
		last.next = new_node;
		return;
	}

	public void deleteNode(Node node, Node n) {
		if (node == n) {
			if (n.next == null) {
				System.out.println("There is only one node and deletion not possible");
				return;
			}
			node.data = node.next.data;
			n = node.next;
			node.next = node.next.next;
			System.gc();
			return;
		}
		Node prev = node;
		while (prev.next != null && prev.next != n) {
			prev = prev.next;
		}
		prev.next = prev.next.next;
		System.gc();
		return;
	}

	/* Function to reverse the linked list */
	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	public boolean detectLoop() {
		Node slow_p = head, fast_p = head;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				System.out.println("Found loop in LL");
				return true;
			}
		}
		System.out.println("Found no loop in LL");
		return false;
	}

	/* Recursive Function to reverse the linked list */
	public Node reverseUtil(Node curr, Node prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return null;
		}
		Node next1 = curr.next;
		curr.next = prev;
		reverseUtil(next1, curr);
		return head;

	}

	/*
	 * Function to get the nth node from the last of a linked list
	 */
	void printNthFromLast(int n) {
		int len = 0;
		Node temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n)
			return;

		temp = head;

		// 2) get the (len-n+1)th node from the begining
		// is same as getting nth from last ;)
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.next;

		System.out.println(temp.data);
	}

	static int compare(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return 1;
		}
		while (node1 != null && node2 != null && node1.data == node2.data) {
			node1 = node1.next;
			node2 = node2.next;
		}

		// if the list are different in size
		if (node1 != null && node2 != null) {
			return (node1.data > node2.data ? 1 : -1);
		}

		// if either of the list has reached end
		if (node1 != null && node2 == null) {
			return 1;
		}
		if (node1 == null && node2 != null) {
			return -1;
		}
		return 0;
	}

	// prints content of double linked list
	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void reverseListTrigger() {
		LinkedList list = new LinkedList();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);

		System.out.println("\nUsing Recursive reverse function for linked list");
		LinkedList list1 = new LinkedList();
		list1.head = new Node(85);
		list1.head.next = new Node(15);
		list1.head.next.next = new Node(4);
		list1.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list1.printList(head);
		head = list1.reverseUtil(head, null);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);

		System.out.println("\nSimple Java program to find n'th node from end of linked list");
		LinkedList llist = new LinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);
		llist.printNthFromLast(3);
		System.out.println();
	}

	public static void deleteNodeFromLinkedListTrigger() {
		LinkedList list = new LinkedList();
		list.head = new Node(12);
		list.head.next = new Node(15);
		list.head.next.next = new Node(10);
		list.head.next.next.next = new Node(11);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(2);
		list.head.next.next.next.next.next.next.next = new Node(3);

		System.out.println("Given Linked List :");
		list.printList(head);
		System.out.println("");

		// Let us delete the node with value 10
		System.out.println("Deleting node :" + head.next.next.data);
		list.deleteNode(head, head.next.next);

		System.out.println("Modified Linked list :");
		list.printList(head);
		System.out.println("");

		// Lets delete the first node
		System.out.println("Deleting first Node");
		list.deleteNode(head, head);
		System.out.println("Modified Linked List");
		list.printList(head);
	}

	public static void compareTwoStringsTrigger() {

		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		Node result = null;

		list1.head = new Node(1);
		list1.head.next = new Node(2);
		list1.head.next.next = new Node(3);
		list1.head.next.next.next = new Node(4);
		list1.head.next.next.next.next = new Node(5);
		list1.head.next.next.next.next.next = new Node(6);

		list2.head = new Node(1);
		list2.head.next = new Node(2);
		list2.head.next.next = new Node(3);
		list2.head.next.next.next = new Node(4);
		list2.head.next.next.next.next = new Node(5);
		list2.head.next.next.next.next.next = new Node(7);

		int value;
		value = compare(list1.head, list2.head);
		System.out.println(value);

	}
}
