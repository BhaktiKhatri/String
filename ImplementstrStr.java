package String;

import java.util.Arrays;

/**
 * Leetcode 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/description/
 * Implement strStr(). Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1: Input: haystack = "hello", needle = "ll" Output: 2
 * Example 2: Input: haystack = "aaaaa", needle = "bba" Output: -1
 * Explanation and Code from: https://leetcode.com/problems/implement-strstr/discuss/12807/?page=4
 * @author NisuBhakti
 * Time Complexity: O(i*j)
 * Easy
 * Facebook, Microsoft, Apple, Pocket Gems
 */

public class ImplementstrStr {

	//https://www.geeksforgeeks.org/check-string-substring-another/
	//https://leetcode.com/problems/implement-strstr/discuss/12807/Elegant-Java-solution
	public static int strStr(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0) {
            return 0;
        }
        
        if (haystack.length() == 0) {
            return -1;
        }
        
        System.out.println("haystack: "+haystack+" needle: "+needle);
        System.out.println("haystack.length(): "+haystack.length()+" needle.length(): "+needle.length());

		  for(int i = 0; ; i++) {		// The length of haystack
		    for(int j = 0; ; j++) {	// The length of needle
		    	System.out.println("i: "+i+" j: "+j);
		      
		    	if(j == needle.length()) { 
		    	  return i;	// If at this point we have navigated through entire length of needle, we have found a solution,haystack[i].
		    	}
		        
		    	if(i + j == haystack.length()) { 
		    	  return -1; // This happens when we run out of elements in haystack, but there are still elements in needle.
		    	}
		    	
		    	System.out.println("needle.charAt(j): "+needle.charAt(j)+" haystack.charAt(i + j): "+haystack.charAt(i + j));
		    	
		    	if(needle.charAt(j) != haystack.charAt(i + j)) { 
		    	  break;	// We stop comparing after needle[j], so i will be incremented and cycle repeats itself.
		    	}
		    }
		  }
		}
	
	//KMP
	public static int[] computeLps(char[] pattern) {
		int[] lps = new int[pattern.length];
		lps[0] = 0;
		
		for(int i=1; i<pattern.length; i++) {
			int j=lps[i-1];
		
			while(j>0 && pattern[i] != pattern[j]) {
				j = lps[j-1];
			}
			
			if(pattern[i] == pattern[j]) {
				j++;
			}
			
			lps[i] = j;
		}
		return lps;
	}

	//Refer this
	//https://leetcode.com/problems/implement-strstr/discuss/141414/KMP-solution-and-explaination
	public static int kmpSubstrMatch(String haystack, String needle) {
		if(haystack == null || needle == null)
			return -1;
		if(needle.isEmpty())
			return 0;
		
		int[] lps = computeLps(needle.toCharArray());
		int i=0;
		int j=0;
		
		System.out.println("lps: "+Arrays.toString(lps));
		
		while(i<haystack.length() && j<needle.length()) {
			System.out.println("i1: "+i+" j1: "+j);
			if(haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
				System.out.println("i: "+i+" j: "+j);
				if(j == needle.length()) {
					return i - j;
				}
			}
			else {
				if(j>0) {
					j=lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		String haystack = "aabaaabaaac", needle = "aabaaac";
		System.out.println("haystack: "+haystack+" needle: "+needle);
		System.out.println("haystack.length(): "+haystack.length()+" needle.length(): "+needle.length());
		System.out.println(strStr(haystack, needle));
		//System.out.println(kmpSubstrMatch(haystack, needle));
	}

}
