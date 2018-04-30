package com.sample.interview.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sample.adapter.pattern.AudioPlayer;
import com.sample.composite.pattern.Employee;
import com.sample.data.structures.BinarySearchTree;
import com.sample.data.structures.BinaryTree;
import com.sample.data.structures.Stack;
import com.sample.data.structures.TwoStacks;
import com.sample.factory.pattern.Color;
import com.sample.factory.pattern.ColorFactory;
import com.sample.interview.programs.LinkedList.Node;
import com.sample.observer.pattern.BinaryObserver;
import com.sample.observer.pattern.HexaObserver;
import com.sample.observer.pattern.OctalObserver;
import com.sample.observer.pattern.Subject;
import com.sample.threads.program.CallableTask;
import com.sample.threads.program.MultithreadingDemo;
import com.sample.threads.program.OneMoreMultithreadingDemo;
import com.sample.threads.program.PC;

public class MainApp {

	static int sum = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		System.out.println("Fibonacci series ...");
		fibonacci(7);
		System.out.println();

		System.out.println("Singleton example ...");
		Singleton single = Singleton.getInstance();
		// same object is being incremented
		single.counter();
		single.counter();
		single.counter();
		System.out.println();

		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i < 30; i++) {
			numbers.add(i);
		}
		// add duplicate number into the list
		numbers.add(22);
		System.out.println("Duplicate Number: " + findDuplicateNumber(numbers));
		System.out.println();

		System.out.println("Prime or not ...");
		if (primeCheck(17))
			System.out.println("17 is a prime");
		else
			System.out.println("17 is not a prime");

		if (primeCheck(22))
			System.out.println("22 is a prime");
		else
			System.out.println("22 is not a prime");
		System.out.println();

		System.out.println("Sum of each digit in a number is : " + getNumberSum(225));
		System.out.println();

		System.out.println("Bitwise operations demo ...");
		int a = 9; // 00001001
		int b = 10; // 00001010
		int c = 11;
		byte[] d = { 1, 0, 0, 1 };
		System.out.println("a & b " + (a & b));
		System.out.println("a | b " + (a | b));
		System.out.println("a ^ b " + (a ^ b));
		System.out.println("a << 2 " + (a << 2));
		System.out.println("a >> 2 " + (a >> 2));
		// System.out.println("a <<< 2 " + (a<<<2)); //invalid operator
		System.out.println("a >>> 2 " + (a >>> 2));
		System.out.println("c << 1 " + (c << 1));
		System.out.println("c >> 1 " + (c >> 1));
		// System.out.println("c <<< 1 " + (c<<<1)); //Invalid operator
		System.out.println("c >>> 1 " + (c >>> 1));
		System.out.println();

		System.out.println("Decimal to Binary Conversion: " + c + "->");
		decToBin(c);
		System.out.println();

		System.out.println("Binary to Decimal Conversion: " + c + "->");
		binToDec(d);
		System.out.println();

		Set<Integer> dup = countDuplicates(new int[] { 0, 0, 1, 2, 3, 3, 3, 5, 5, 7, 8, 8, 9 });
		Iterator<Integer> itr = dup.iterator();
		System.out.println("Duplicating digits in : { 0, 0, 1, 2, 3, 3, 3, 5, 5, 7, 8, 8, 9 }");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();

		System.out.println("Factory Design Pattern ...");
		ColorFactory factory = new ColorFactory();
		Color color = factory.getColor("RED");
		color.paint();
		Color color1 = factory.getColor("BLUE");
		color1.paint();
		System.out.println();

		System.out.println("Adapter Design Pattern ...");
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
		System.out.println();

		System.out.println("Composite Design Pattern ...");
		compositeDesignPatternTrigger();
		System.out.println();

		System.out.println("Observer Design Pattern ...");
		observerDesignPatternTrigger();
		System.out.println();

		int x = 23; // 00010111
		// Output is 43 (00101011)
		System.out.println(swapBits(x));

		System.out.println();
		System.out.println("Bit rotation example ...");
		int n = 16;
		int d1 = 2;
		System.out.print("Left Rotation of " + n + " by " + d1 + " is ");
		System.out.print(leftRotate(n, d1));

		System.out.print("\nRight Rotation of " + n + " by " + d1 + " is ");
		System.out.print(rightRotate(n, d1));
		System.out.println();

		System.out.println("Code to check whether a number is pallindrome ...");
		Pallindrome.isPallindrome(123);
		System.out.println();

		System.out.println("Code to find out factorial of a number ...");
		int x1 = 4;
		System.out.println("Factorial of " + x1 + " is: " + Factorial.factorial(x1));
		System.out.println();

		System.out.println("Code to reverse a String without using StringBufer...");
		String s = "HelloWorld";
		System.out.println("Input String: " + s + " its reverse: " + reverseString(s));
		System.out.println();

		System.out.println("Code to get permutations of a string ...");
		String str = "ABC";
		int n1 = str.length();
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n1 - 1);
		System.out.println();

		System.out.println("Code for BinarySearch algorithm ...");
		BinarySearch ob = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int na = arr.length;
		int xa = 10;
		int result = ob.search(arr, 0, na - 1, xa);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);
		System.out.println();

		System.out.println("Code for QuickSort algorithm ...");
		int arr1[] = { 10, 7, 8, 9, 1, 5 };
		int len = arr1.length;

		QuickSort qs = new QuickSort();
		qs.sort(arr1, 0, len - 1);

		System.out.println("sorted array");
		qs.printArray(arr1);
		System.out.println();

		System.out.println("Code for MergeSort algorithm ...");
		int arr2[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		MergeSort.printArray(arr2);

		MergeSort ms = new MergeSort();
		ms.sort(arr2, 0, arr.length - 1);

		System.out.println("\nSorted array");
		ms.printArray(arr2);
		System.out.println();

		System.out.println("Code for Detecting Loop in Linked List algorithm ...");
		LinkedList llist = new LinkedList();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);
		llist.push(34);

		System.out.println("Middle Element program ...");
		LLMiddleElement midEle = new LLMiddleElement();
		midEle.middleElement(llist.head);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		llist.detectLoop();
		System.out.println();

		System.out.println("Code for reversing Linked List ...");
		LinkedList list = new LinkedList();
		list.reverseListTrigger();
		System.out.println();
		System.out.println();

		System.out.println("Code for swapping pair wise elements in Linked list ...");
		LinkedList llist2 = new LinkedList();
		llist2.push(20);
		llist2.push(4);
		llist2.push(15);
		llist2.push(10);
		llist2.push(34);
		LLPairwiseSwap pairSwap = new LLPairwiseSwap();
		pairSwap.pairwiseSwapElements(llist2.head);
		llist2.printList(llist2.head);
		System.out.println();

		System.out.println("Code for deleting a node from linked list ...");
		LinkedList list2 = new LinkedList();
		list2.deleteNodeFromLinkedListTrigger();
		System.out.println();

		System.out.println("Code for demostrating generic class...");
		GenericTestClass<Integer> iObj = new GenericTestClass<Integer>(15);
		System.out.println(iObj.getObject());

		GenericTestClass<String> sObj = new GenericTestClass<String>("This is a test string");
		System.out.println(sObj.getObject());
		System.out.println();

		System.out.println("Code for demostrating generic method...");
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		GenericMethodTest.printArray(intArray); // pass an Integer array

		System.out.println("\nArray doubleArray contains:");
		GenericMethodTest.printArray(doubleArray); // pass a Double array

		System.out.println("\nArray characterArray contains:");
		GenericMethodTest.printArray(charArray); // pass a Character array

		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, GenericMethodTest.maximum(3, 4, 5));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
				GenericMethodTest.maximum(6.6, 8.8, 7.7));

		System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
				GenericMethodTest.maximum("pear", "apple", "orange"));
		System.out.println();

		System.out.println("Accessing non-static generic method ...");
		GenericMethodTest testObj = new GenericMethodTest();
		testObj.nonStaticPrintArray(intArray);
		testObj.nonStaticPrintArray(doubleArray);
		System.out.println();

		System.out.println("Multithreading code by extending Thread ...");
		int n2 = 8; // Number of threads
		for (int i = 0; i < n2; i++) {
			MultithreadingDemo object = new MultithreadingDemo();
			object.start();
		}
		System.out.println();
		System.out.println("Multithreading code by implementing Runnable ...");
		int n3 = 8; // Number of threads
		for (int i = 0; i < n3; i++) {
			Thread object = new Thread(new MultithreadingDemo());
			object.start();
		}

		System.out.println();
		System.out.println("Multithreading code by implementing Runnable and called by ExecutorService ...");
		/* Launching threads using Executor Service */
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		/* In this case, the Future object will not hold any value. */

		// Future future = executorService.submit(new MultithreadingDemo());
		// NOTE: executorService.execute(...) has return type as void.
		// Hence if a callable class is returning an object, we only need to use
		// executorService.submit()
		Future future = executorService.submit(new MultithreadingDemo());
		/*
		 * Another way to execute MultithreadingDemo using 'execute' API of
		 * ExecutorService
		 */
		executorService.execute(new MultithreadingDemo());
		executorService.shutdown();
		System.out.println();

		System.out.println();
		System.out.println("Multithreading code by implementing Callable ...");
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		/* https://www.geeksforgeeks.org/thread-pools-java/ */
		CallableTask task = new CallableTask(5);
		/* In this case, the Future object will hold value. */
		Future<Integer> future1 = executorService1.submit(task);
		System.out.println("Result of factorial obtained using future object: " + future1.get().intValue());
		System.out.println();

		System.out.println();
		/*
		 * The invokeAny() method takes a collection of Callable objects, or
		 * subinterfaces of Callable. Invoking this method does not return a
		 * Future, but returns the result of one of the Callable objects. You
		 * have no guarantee about which of the Callable's results you get. Just
		 * one of the ones that finish.
		 * 
		 * If one of the tasks complete (or throws an exception), the rest of
		 * the Callable's are cancelled.
		 */

		System.out.println("Code for demoing invokeAny method of ExecutorService ...");
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();

		/*
		 * Method Description newFixedThreadPool(int) Creates a fixed size
		 * thread pool. newCachedThreadPool() Creates a thread pool that creates
		 * new threads as needed, but will reuse previously constructed threads
		 * when they are available newSingleThreadExecutor() Creates a single
		 * thread.
		 * 
		 */
		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});

		String result2 = executorService2.invokeAny(callables);

		System.out.println("result = " + result2);

		executorService2.shutdown();

		System.out.println();
		/*
		 * The invokeAll() method invokes all of the Callable objects you pass
		 * to it in the collection passed as parameter. The invokeAll() returns
		 * a list of Future objects via which you can obtain the results of the
		 * executions of each Callable.
		 * 
		 * Keep in mind that a task might finish due to an exception, so it may
		 * not have "succeeded". There is no way on a Future to tell the
		 * difference.
		 */
		System.out.println("Code for demoing invokeAll method of ExecutorService ...");
		ExecutorService executorService3 = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables2 = new HashSet<Callable<String>>();

		callables2.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables2.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables2.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});

		List<Future<String>> futures = executorService3.invokeAll(callables2);

		for (Future<String> future4 : futures) {
			System.out.println("future.get = " + future4.get());
		}

		/*
		 * When you are done using the ExecutorService you should shut it down,
		 * so the threads do not keep running.
		 * 
		 * For instance, if your application is started via a main() method and
		 * your main thread exits your application, the application will keep
		 * running if you have an active ExexutorService in your application.
		 * The active threads inside this ExecutorService prevents the JVM from
		 * shutting down.
		 * 
		 * To terminate the threads inside the ExecutorService you call its
		 * shutdown() method. The ExecutorService will not shut down
		 * immediately, but it will no longer accept new tasks, and once all
		 * threads have finished current tasks, the ExecutorService shuts down.
		 * All tasks submitted to the ExecutorService before shutdown() is
		 * called, are executed.
		 * 
		 * If you want to shut down the ExecutorService immediately, you can
		 * call the shutdownNow() method. This will attempt to stop all
		 * executing tasks right away, and skips all submitted but non-processed
		 * tasks. There are no guarantees given about the executing tasks.
		 * Perhaps they stop, perhaps the execute until the end. It is a best
		 * effort attempt.
		 */
		executorService3.shutdown();
		System.out.println();

		System.out.println("Inter thread communication example code ...");
		/*
		 * wait()-It tells the calling thread to give up the lock and go to
		 * sleep until some other thread enters the same monitor and calls
		 * notify(). notify()-It wakes up one single thread that called wait()
		 * on the same object. It should be noted that calling notify() does not
		 * actually give up a lock on a resource. notifyAll()-It wakes up all
		 * the threads that called wait() on the same object.
		 */
		threadCommunicationExample();
		System.out.println();

		System.out.println(
				"If exception is not occurred in try block then control flow will be finally block followed by rest of the program");
		tryFinallyExampleWithNoException();
		System.out.println();

		System.out.println(
				" If exception has been occurred in try block  then control flow will be finally block followed"
						+ " by default exception handling mechanism.");
		// tryFinallyExampleWithException();
		System.out.println();

		System.out
				.println("Java program to demonstrate try-catch-finally when exception doesn't occurred in try block");
		tryCatchFinallyWithNoException();
		System.out.println();

		/*
		 * https://www.geeksforgeeks.org/flow-control-in-try-catch-finally-in-
		 * java/
		 */

		System.out.println("Driver program to test twoStack class");
		twoStackUsingSingleArray();
		System.out.println();

		System.out.println("Driver program to reverse string using stack");
		reverseStringUsingStack();
		System.out.println();

		/*
		 * https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
		 */
		System.out.println("Program to create a unique string...");
		System.out.println(UniqueString.unique("geeksforgeeks"));
		System.out.println();

		/*
		 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-
		 * postorder/
		 */
		System.out.println("Program to demo Depth First Traversals: tree traversal ...");
		BinaryTree.treeTraversalTriggerDFS();
		System.out.println();

		System.out.println("Program to demo Breadth First Traversal: tree traversal ...");
		BinaryTree.treeTraversalTriggerBFS();
		System.out.println();

		System.out.println("Program to demo Binary Search Tree Insert and Traversal ...");
		BinarySearchTree.bstTreeFunctionTrigger();
		System.out.println();

		System.out.println();
		System.out.println("KLargest elements from an array ...");
		KLargest kLargeObj = new KLargest();
		int arr3[] = new int[] { 1, 23, 12, 9, 30, 2, 50 };
		kLargeObj.getKLargestElements(arr3, 3);
		System.out.println();

		System.out.println();
		System.out.println(
				"Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.");
		PythagoreanTriplet tripletObj = new PythagoreanTriplet();
		int arr4[] = { 3, 1, 4, 6, 5 };
		int arr_size = arr4.length;
		if (tripletObj.findPythagoreanTriplet(arr4, arr_size) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println();

		System.out.println();
		System.out.println(
				"Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1)");
		SpecialStack sStack = new SpecialStack();
		sStack.specialStackTrigger();
		System.out.println();

		System.out.println();
		System.out.println(
				"Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.");
		NextGreaterElement nge = new NextGreaterElement();
		nge.printNGETrigger();
		System.out.println();

		System.out.println();
		System.out.println("Maximum sum such that no two elements are adjacent ...");
		MaximumSum maxSumObj = new MaximumSum();
		maxSumObj.MaximumSumTrigger();
		System.out.println();

		System.out.println("Given a string, find its first non-repeating character ...");
		FirstNonRepeatingChar obj = new FirstNonRepeatingChar();
		obj.firstNonRepeatingCharacterTrigger();
		System.out.println();

		System.out.println();
		LinkedList ll3 = new LinkedList();
		ll3.compareTwoStringsTrigger();
		System.out.println();

		System.out.println();
		System.out.println(
				"You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.");
		int a2[] = { 1, 2, 4, 5, 6 };
		int miss = getMissingNo(a2, 5);
		System.out.println(miss);
		System.out.println();

		System.out.println();
		System.out.println("Check if a given array contains duplicate elements within k distance from each other ...");
		CheckDuplicatesWithinK checkForDup = new CheckDuplicatesWithinK();
		checkForDup.CheckDuplicatesWithinKDistanceTrigger();
		System.out.println();

		System.out.println();
		System.out.println("Given an array A[] and a number x, check for pair in A[] with sum as x ...");
		PairSum pairSum = new PairSum();
		pairSum.pairSumTriggerFunction();
		System.out.println();

		System.out.println();
		System.out.println("Merge two sorted linked lists ...");
		MergeLinkedLists mLinkedLists = new MergeLinkedLists();
		mLinkedLists.mergeLinkedListsTrigger();
		System.out.println();
	}

	/*
	 * 1. Get the sum of numbers total = n*(n+1)/2 2. Subtract all the numbers
	 * from sum and you will get the missing number.
	 */
	// Function to ind missing number
	static int getMissingNo(int a[], int n) {
		int i, total;
		total = (n + 1) * (n + 2) / 2;
		for (i = 0; i < n; i++)
			total -= a[i];
		return total;
	}

	public static Set<Integer> countDuplicates(int[] arr) {
		Set<Integer> dup = new HashSet(); // can be used to remove duplicate
											// numbers as well
		for (int i = 0; i < arr.length - 1; ++i) {
			int a = arr[i];
			int b = arr[i + 1];
			if ((a ^ b) == 0) { // result of a^b will be an int
				dup.add(b);
			}
		}
		return dup;
	}

	public static void decToBin(int dec) {
		List<Integer> arr = new ArrayList<>();
		int count = 0;
		do {
			arr.add(dec % 2);
			dec = dec / 2;
			++count;
		} while (dec != 0);
		for (int i = arr.size() - 1; i >= 0; --i)
			System.out.print(arr.get(i));
	}

	public static void binToDec(byte[] bin) {
		int sum = 0;
		int j = 0;
		for (int i = bin.length - 1; i >= 0; --i) {
			sum += bin[i] * (Math.pow(2, j));
			++j;
		}
		System.out.println(sum);
	}

	public static void fibonacci(int count) {
		int a = 0;
		int b = 1;
		int c;
		List<Integer> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		for (int i = 0; i < count; i++) {
			c = a + b;
			a = b;
			b = c;
			list.add(c);
		}
		System.out.println(list);
	}

	public static int findDuplicateNumber(List<Integer> intArray) {
		int highestNo = intArray.size() - 1;
		int total = getSum(intArray);
		int duplicate = total - (highestNo * (highestNo + 1) / 2);
		// sum of N numbers is n(n+1)/2
		// Hence the present sum and expected sum difference is the duplicate
		// number
		return duplicate;
	}

	public static int getSum(List<Integer> numbers) {
		int sum = 0;
		for (int i : numbers)
			sum += i;
		return sum;
	}

	public static boolean primeCheck(int number) {
		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public static int getNumberSum(int number) {
		if (number == 0)
			return sum;
		else {
			sum += number % 10;
			getNumberSum(number / 10);
		}
		return sum;
	}

	public static void compositeDesignPatternTrigger() {
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);

		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		// print all employees of the organization
		System.out.println(CEO);

		for (Employee headEmployee : CEO.getSubordinates()) {
			System.out.println(headEmployee);

			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}
	}

	public static void observerDesignPatternTrigger() {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}

	public static int swapBits(int x) {
		// Get all even bits of x
		int even_bits = x & 0xAAAAAAAA; // ...101010

		// Get all odd bits of x
		int odd_bits = x & 0x55555555; // ...010101

		// Right shift even bits
		even_bits >>= 1;

		// Left shift even bits
		odd_bits <<= 1;

		// Combine even and odd bits
		return (even_bits | odd_bits);
	}

	static final int INT_BITS = 32;

	/* Function to left rotate n by d bits */
	static int leftRotate(int n, int d) {

		/*
		 * In n<<d, last d bits are 0. To put first 3 bits of n at last, do
		 * bitwise or of n<<d with n >>(INT_BITS - d)
		 */
		return (n << d) | (n >> (INT_BITS - d));
	}

	/* Function to right rotate n by d bits */
	static int rightRotate(int n, int d) {

		/*
		 * In n>>d, first d bits are 0. To put last 3 bits of at first, do
		 * bitwise or of n>>d with n <<(INT_BITS - d)
		 */
		return (n >> d) | (n << (INT_BITS - d));
	}

	static String reverseString(String str) {
		char c[] = str.toCharArray();
		int i = 0;
		int j = c.length - 1;
		while (i < j) {
			char tmp = c[i];
			c[i] = c[j];
			c[j] = tmp;
			i++;
			j--;
		}
		return new String(c);
	}

	static void threadCommunicationExample() throws InterruptedException {
		final PC pc = new PC();

		// Create a thread object that calls pc.produce()
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create another thread object that calls
		// pc.consume()
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();

		// t1 finishes before t2
		t1.join();
		t2.join();
	}

	public static void tryFinallyExampleWithNoException() {
		try {
			String str = "123";

			int num = Integer.parseInt(str);

			// this statement will execute
			// as no any exception is raised by above statement
			System.out.println("Inside try block");
		}

		finally {
			System.out.println("finally block executed");
		}

		// rest program will be executed
		System.out.println("Outside try-finally clause");
	}

	/*
	 * Calling this method will result in
	 * java.lang.ArrayIndexOutOfBoundsException which is not caught by catch
	 * Since there is no catch block, finally will be executed and then
	 * Exception will be given to Java environment which will throw an error and
	 * display the message
	 */
	public static void tryFinallyExampleWithException() {
		// array of size 4.
		int[] arr = new int[4];
		try {
			int i = arr[4];

			// this statement will never execute
			// as exception is raised by above statement
			System.out.println("Inside try block");
		}

		finally {
			System.out.println("finally block executed");
		}

		// rest program will not execute
		System.out.println("Outside try-finally clause");
	}

	public static void tryCatchFinallyWithNoException() {
		try {

			String str = "123";

			int num = Integer.parseInt(str);

			// this statement will execute
			// as no any exception is raised by above statement
			System.out.println("Inside try block");

		}

		catch (NumberFormatException ex) {

			System.out.println("catch block executed...");

		}

		finally {
			System.out.println("finally block executed");
		}

		System.out.println("Outside try-catch-finally clause");

	}

	public static void twoStackUsingSingleArray() {
		TwoStacks ts = new TwoStacks(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.println("Popped element from" + " stack1 is " + ts.pop1());
		ts.push2(40);
		System.out.println("Popped element from" + " stack2 is " + ts.pop2());
	}

	public static void reverseStringUsingStack() {
		// create a new string
		StringBuffer s = new StringBuffer("GeeksforGeeks");

		// call reverse method
		StringReverse strRev = new StringReverse();
		strRev.reverse(s);

		// print the reversed string
		System.out.println("Reversed string is : " + s);
	}

}
