package String;

import java.util.Arrays;

/**
 * Leetcode 459. Repeated Substring Pattern
 * https://discuss.leetcode.com/category/587/repeated-substring-pattern
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1: Input: "abab", Output: True; Explanation: It's the substring "ab" twice.
 * Example 2: Input: "aba", Output: False
 * Example 3: Input: "abcabcabcabc", Output: True; Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * Explanation and Code from: https://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 * @author NisuBhakti
 * Time Complexity: Time complexity of the above solution is O(n) as it uses KMP pre-processing algorithm which is linear time algorithm.
 * Easy
 * Amazon, Google
 */

public class RepeatedSubstringPattern {
	
	public static int[] lookupTable(char[] p) {
        int[] func = new int[p.length];
        func[0] = 0;
        
        System.out.println("p: "+Arrays.toString(p));
        
        for(int i=1, j=0; i<p.length; i++) {
        	System.out.println("i: "+i+" j: "+j);
            j = func[i-1];
            
            System.out.println("j: "+j+" p[i]: "+p[i]+" p[j]: "+p[j]);
            
            while(j > 0 && p[i] != p[j]) { 
                j = func[j-1];
            }
            
            System.out.println("j: "+j+" p[i]: "+p[i]+" p[j]: "+p[j]);
            if(p[i] == p[j])
                j++;
            
            System.out.println("j: "+j+" func[i]: "+func[i]);
            func[i] = j; 
        }
        return func;
    }
	
	/*
	 * https://leetcode.com/problems/repeated-substring-pattern/discuss/94340/Java-and-O(n)
	 * @LearnerToPro
	 * The value at last in kmp computed array has the value of the substring present.
		eg: string ="abcabc" now the value at computed array will be 3 at c.
		This we are taking and subtracting from the length of string
		length of string:"len =6"
		since it divides completely we make sure that the string is completely built with substring.
		
		Now see if the input is "abcdabc" len=7
		Our kmp array will still have 3
		now the the string cannot be divided just with substring length that means it wont be constructed with the substring alone. 
		Hope this is clear :)

 		Refer code and explanation: http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
	 */
	// Returns true if str is repetition of 
	// one of its substrings else return false.
	public static boolean repeatedSubstringPattern(String str)
	{
	    // Find length of string and create 
	    // an array to store lps values used in KMP
	    int n = str.length();
	    System.out.println("str: "+str+" n: "+n);
	    
	    // Preprocess the pattern (calculate lps[] array)
	    //computeLPSArray(str, n, lps);
	    int[] lps = lookupTable(str.toCharArray());
	 
	    // Find length of longest suffix 
	    // which is also prefix of str.
	    int len = lps[n-1];
	    System.out.println("len: "+len);
	 
	    // If there exist a suffix which is also 
	    // prefix AND Length of the remaining substring
	    // divides total length, then str[0..n-len-1] 
	    // is the substring that repeats n/(n-len)  
	    // times (Readers can print substring and 
	    // value of n/(n-len) for more clarity.
	    return (len > 0 && n%(n-len) == 0)? true: false;
	}

	public static void main(String[] args) {
		String str = "ABCABC";
		System.out.println(repeatedSubstringPattern(str));
	}

}
