package String;

/**
 * Leetcode 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/description/
 * Given a string, your task is to count how many palindromic substrings in this string
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters
 * Example 1: Input: "abc", Output: 3, Explanation: Three palindromic strings: "a", "b", "c"
 * Example 2: Input: "aaa", Output: 6, Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
 * Explanation and Code from: https://leetcode.com/problems/palindromic-substrings/solution/ LongestPalindromicSubstring 
 * Time Complexity: O(N), where N is the length of S. As discussed above, the complexity is linear
 * Space Complexity: O(N), the size of T and P.
 * Medium
 * Facebook, LinkedIn
 */

public class PalindromicSubstrings {

	public static int countSubstrings(String s) {
		System.out.println(s);
		char[] T = new char[s.length()*2+3];
		T[0] = '$';
		T[s.length()*2+2] = '@';
		
		for(int i=0; i<s.length(); i++) {
			T[2*i + 1] = '#';
			T[2*i + 2] = s.charAt(i);
		}
		
		T[s.length()*2 + 1] = '#';
		
		int[] P = new int[T.length];
		int center = 0;
		int right = 0;
		
		for(int i=1; i<T.length-1; i++) {
			int mirror = 2*center - i;
			
			System.out.println("i: "+i+" center: "+center+" mirror: "+mirror+" right: "+right+" P[i]: "+P[i]);
			if(i < right) {
				P[i] = Math.min(right - i,  P[mirror]);
			}
			
			System.out.println("r ele: "+(T[i + (1+P[i])])+" l ele: "+T[i - (1+P[i])]);
			while(T[i + (1+P[i])] == T[i - (1+P[i])]) {
				P[i]++;
			}
			
			if(i + P[i] > right) {
				center = i;
				right = i + P[i];
			}
		}
		
		int count = 0;
		for(int c: P) {
			count = count + (c + 1)/2;	//We are dividing by 2 because we were using half-lengths instead of lengths. For example we actually had the palindrome a#b#c#d#e#d#c#b#a, so our length is twice as big
		}
		return count;	
	}
	
	public static void main(String[] args) {
		String s = "aaa";
		System.out.println(countSubstrings(s));
	}

}
