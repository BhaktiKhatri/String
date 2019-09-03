package String;

import java.util.Arrays;

/**
 * Leetcode 556. Next Greater Element III
 * https://leetcode.com/problems/next-greater-element-iii/description/
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
 * Example 1: Input: 12, Output: 21
 * Example 2: Input: 21, Output: -1
 * Explanation and Code from: Approach #2 Linear Solution https://leetcode.com/problems/next-greater-element-iii/solution/
 * Time complexity: O(n), In worst case, only two scans of the whole array are needed. Here, n refers to the number of digits in the given number
 * Space complexity: O(n), An array a of size n is used, where n is the number of digits in the given number
 * Medium
 * Bloomberg
 */

public class NextGreaterElement3 {

	public static int nextGreaterElement(int n) {
		System.out.println("n: "+n);
		
        char[] a = (""+n).toCharArray();
        int i = a.length - 2;
        
        System.out.println("a: "+Arrays.toString(a)+" i: "+i);
        
        while(i >= 0 && a[i + 1] <= a[i]) {
        	System.out.println("i: "+i+" a[i]: "+a[i]+" a[i+1]: "+a[i+1]);
            i--;
        }
        
        if(i < 0)
            return -1;
        
        int j = a.length - 1;
        while(j >= 0 && a[j] <= a[i]) {
        	System.out.println("j: "+j+" a[i]: "+a[i]+" a[j]: "+a[j]);
            j--;
        }
        
        swap(a, i, j);
        reverse(a, i + 1);
        
        long val = Long.parseLong(new String(a));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
        
    }
	
    public static void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    
    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
	public static void main(String[] args) {
		int n = 158476531;
		System.out.println(nextGreaterElement(n));
	}

}
