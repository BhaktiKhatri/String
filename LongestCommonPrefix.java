package String;

import java.util.Arrays;

/**
 * Leetcode 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Explanation and Code from: Approach #2 Vertical Scanning https://leetcode.com/problems/longest-common-prefix/solution/
 * @author NisuBhakti
 * Time complexity : O(S), where S is the sum of all characters in all strings. In the worst case there will be n equal strings with length m
 * and the algorithm performs S=m∗n character comparisons. Even though the worst case is still the same as Approach #1, in the best case there are 
 * at most n*minLen comparisons where minLen is the length of the shortest string in the array.
 * pace complexity : O(1), We only used constant extra space.
 * Easy
 * Yelp
 */

public class LongestCommonPrefix {

	/*
	 	Algorithm: Imagine a very short string is at the end of the array. The above approach will still do S comparisons. 
	 	One way to optimize this case
	 	is to do vertical scanning. We compare characters from top to bottom on the same column (same character index of the strings) 
	 	before moving on
	 	to the next column.
	 */
	public static String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0) 
	    	return "";
	    
	    System.out.println("strs: "+Arrays.toString(strs));
	    
	    for(int i=0; i<strs[0].length(); i++) {
	    	System.out.println("i: "+i+" strs[0]: "+strs[0]);
	        
	    	char c = strs[0].charAt(i);
	        System.out.println("c: "+c);
	        
	        for(int j=1; j<strs.length; j++) {
	        	System.out.println("i: "+i+" j: "+j+" strs[j]: "+strs[j]+" strs[j].charAt(i): "+strs[j].charAt(i));
	        	
	            if(i == strs[j].length() || strs[j].charAt(i) != c) {
	                return strs[0].substring(0, i);             
	            }
	        }
	    }
	    return strs[0];
	}
	
	public static void main(String[] args) {
		String[] strs = {"leetcode", "leets", "leett"};
		System.out.println(longestCommonPrefix(strs));
	}
}
