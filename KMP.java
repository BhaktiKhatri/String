package String;

import java.util.Arrays;
/*
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
 * https://leetcode.com/problems/shortest-palindrome/solution/
 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 * http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
 */

public class KMP {

	public static int[] computeLps(char[] pattern) {
		System.out.println("pattern: "+Arrays.toString(pattern));
		
		int[] lps = new int[pattern.length];
		lps[0] = 0;
		
		for(int i=1; i<lps.length; i++) {
			int j = lps[i-1];
			
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
	
	public static boolean kmpSubstrMatch(String text, String pattern) {
		int[] lps = computeLps(pattern.toCharArray());
		int i = 0;
		int j = 0;
		
		System.out.println("lps: "+Arrays.toString(lps));
		
		while(i < text.length() && j < pattern.length()) {
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			else {
				if(j > 0) {
					j = lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		System.out.println("j: "+j);
		
		if(j == pattern.length())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String text = "";//"abcxabcdabcdabcy";
		String pattern = "abcdabcy";
		System.out.println(kmpSubstrMatch(text, pattern));
	}

}
