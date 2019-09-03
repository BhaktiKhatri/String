package String;

/**
 * Leetcode 161. One Edit Distance
 * https://leetcode.com/problems/one-edit-distance/description/
 * Given two strings S and T, determine if they are both one edit distance apart.
 * Explanation and Code from: https: @cheng_zhang //leetcode.com/problems/one-edit-distance/discuss/50098 
 * Time Complexity: O(N)
 * Medium
 * Facebook, Uber, Twitter, Snapchat
 */

public class OneEditDistance {

	public static boolean isOneEditDistance(String s, String t) {
		System.out.println("s: "+s+" t: "+t);
		
		int m = s.length();
		int n = t.length();
		System.out.println(" m: "+m+" n: "+n);
		
		if(s.equals(t)) {
			return false;
		}
		
		if(Math.abs(m - n) > 1) {
			return false;
		}
		
		int minSize = Math.min(m, n);
		System.out.println("minSize: "+minSize);
		
	    for(int i=0; i<minSize; i++) {
	    	System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" t.charAt(i): "+t.charAt(i));
	    	
	    	if(s.charAt(i) != t.charAt(i)) {
	    		System.out.println("m: "+m+" n: "+n);
	    		
	    		if(m == n) {								// s has the same length as t, so the only possibility is replacing one char in s and t
	    			System.out.println("s.substring(i + 1): "+s.substring(i + 1)+" t.substring(i + 1): "+t.substring(i + 1));
	    			return s.substring(i + 1).equals(t.substring(i + 1));
	    		}
				else if (m < n) { 										// t is longer than s, so the only possibility is deleting one char from t
					System.out.println("s.substring(i): "+s.substring(i)+" t.substring(i + 1): "+t.substring(i + 1));
					return s.substring(i).equals(t.substring(i + 1));
				}
				else {												// s is longer than t, so the only possibility is deleting one char from s
					System.out.println("t.substring(i): "+t.substring(i)+" s.substring(i + 1): "+s.substring(i + 1));
					return t.substring(i).equals(s.substring(i + 1));
				}
	    	}
	    }       
	    return Math.abs(m - n) == 1;	//All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t e.g. s="a" and t=""       
	}
	
	public static void main(String[] args) {
		String s = "ab";
		String t = "acb";
		System.out.println(isOneEditDistance(s, t));
	}
}