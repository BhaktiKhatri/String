package String;

import java.util.Arrays;

/**
 * Leetcode 522. Longest Uncommon Subsequence II
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 * Example 1: Input: "aba", "cdc", "eae", Output: 3
 * Note: All the given strings' lengths will not exceed 10. The length of the given list will be in the range of [2, 50].
 * Time complexity : O(x*n^2), where n is the number of strings and x is the average length of the strings
 * Space complexity : O(1), Constant space required
 * Medium
 * Google
 */

public class LongestUncommonSubsequence2 {

	public static boolean isSubsequence(String x, String y) {
		System.out.println("x: "+x+" y: "+y);
        int j = 0;
        
        for(int i=0; i<y.length() && j<x.length(); i++) {
            System.out.println("i: "+i+" y.charAt(i): "+y.charAt(i)+" j: "+j+" x.charAt(j): "+x.charAt(j));
        	if(x.charAt(j) == y.charAt(i)) {
                j++;
            }
        }
        System.out.println("j: "+j+" x.length(): "+x.length());
        
        return j == x.length();
    }
	
    public static int findLUSlength(String[] strs) {
        int res = -1;
        
        System.out.println("strs: "+Arrays.toString(strs));
        
        for(int i=0, j; i<strs.length; i++) {
           for(j=0; j<strs.length; j++) {
        	   System.out.println("i: "+i+" j: "+j+" strs[i]: "+strs[i]+" strs[j]: "+strs[j]);
        	   
                if(j == i) {
                    continue;
                }
                
                if(isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
           
            if(j == strs.length) {
                res = Math.max(res, strs[i].length());
                System.out.println("res: "+res);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] strs = {"bd", "e", "abc", "ab", "abc"};
		System.out.println(findLUSlength(strs));
	}

}
