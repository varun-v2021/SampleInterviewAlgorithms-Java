package com.sample.interview.programs;

public class Permutation {
	/**
     * permutation function
     * @param str string to calculate permutation for
     * @param left starting index
     * @param right end index
     */
    public void permute(String str, int left, int right)
    {
    	System.out.println("permute: "+str+" "+left+" "+right);
        if (left == right)
            System.out.println(str);
        else
        {
            for (int i = left; i <= right; i++)
            {
            	System.out.println("swapping: "+str+" "+left+" "+i);
                str = swap(str,left,i);
                permute(str, left+1, right);
                System.out.println("re-swapping: "+str+" "+left+" "+i);
                str = swap(str,left,i); //get back the original string
            }
        }
    }
    
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
