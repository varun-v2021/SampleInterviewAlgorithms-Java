package com.sample.interview.programs;

import java.util.Stack;

//https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

/*Algorithm
 * 
 * 
 * When we insert 18, both stacks change to following.
Actual Stack
18 <--- top     
Auxiliary Stack
18 <---- top

When 19 is inserted, both stacks change to following.
Actual Stack
19 <--- top     
18
Auxiliary Stack
18 <---- top
18

When 29 is inserted, both stacks change to following.
Actual Stack
29 <--- top     
19
18
Auxiliary Stack
18 <---- top
18
18

When 15 is inserted, both stacks change to following.
Actual Stack
15 <--- top     
29
19 
18
Auxiliary Stack
15 <---- top
18
18
18

When 16 is inserted, both stacks change to following.
Actual Stack
16 <--- top     
15
29
19 
18
Auxiliary Stack
15 <---- top
15
18
18
18
 * 
 * */
public class SpecialStack extends Stack<Integer> {

	Stack<Integer> min = new Stack<Integer>();

	/*public void push(int x) {
		if (isEmpty() == true) {
			super.push(x);
			min.push(x);
		} else {
			super.push(x);
			int y = min.pop(); // storing the top element for comparison purpose
			min.push(y);
			if (x > y)
				min.push(y);
			else
				min.push(x);
		}
	}*/
	
	/*public Integer pop() {
		int x = super.pop();
		min.pop();
		return x;
	}*/
	
	/*Space optimised version*/
	/* SpecialStack's member method to insert an element to it. This method
	makes sure that the min stack is also updated with appropriate minimum
	values */
	 
	void push(int x)
	{
	    if(isEmpty() == true)
	    {
	        super.push(x);
	        min.push(x);
	    }
	    else
	    {
	        super.push(x);
	        int y = min.pop();
	        min.push(y);
	     
	        /* push only when the incoming element of main stack is smaller 
	        than or equal to top of auxiliary stack */
	        if( x <= y )
	            min.push(x);
	    }
	}

	/* SpecialStack's member method to remove an element from it. This method
	removes top element from min stack also. */
	public Integer pop()
	{
	    int x = super.pop();
	    int y = min.pop();
	     
	    /* Push the popped element y back only if it is not equal to x */
	    if ( y != x )
	        min.push(y);
	    return x;
	}
	/**/

	// will get the top value. Since its not a pop(), the element must not be
	// popped out of auxiliary stack 'min' as well
	// i.e. why we push the element again onto min.
	public int getMin() {
		int x = min.pop();
		min.push(x);
		return x;
	}
	
	public void specialStackTrigger(){
		SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
	}
}
