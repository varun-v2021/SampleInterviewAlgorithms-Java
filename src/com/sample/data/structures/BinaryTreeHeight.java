package com.sample.data.structures;

class Node1 {
	int data;
	Node1 left, right;

	Node1(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeHeight {
	Node1 root;

	int maxDepth(Node1 node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);

		}
	}
	
	/* Driver program to test above functions */
    public static void main1(String[] args)  
    { 
    	BinaryTreeHeight tree = new BinaryTreeHeight(); 
   
        tree.root = new Node1(1); 
        tree.root.left = new Node1(2); 
        tree.root.right = new Node1(3); 
        tree.root.left.left = new Node1(4); 
        tree.root.left.right = new Node1(5); 
   
        System.out.println("Height of tree is : " +  
                                      tree.maxDepth(tree.root)); 
    } 
}
