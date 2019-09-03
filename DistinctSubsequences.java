package String;

/**
 * Leetcode 115. Distinct Subsequences
 * https://leetcode.com/problems/distinct-subsequences/description/
 * Given a string s and a string t, count the number of distinct subsequences of s which equals t.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example: s = "rabbbit", t = "rabbit" Return 3.
 * Explanation and Code from: https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://blog.csdn.net/fly_yr/article/details/50408457&prev=search
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://blog.csdn.net/MebiuW/article/details/52704694&prev=search
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/higerzhang/p/4133793.html&prev=search
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/grandyang/p/4294105.html&prev=search
 * Final Ans: https://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/
 * https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
 * Hard
 */

public class DistinctSubsequences {

	/*
	 * The first row must be filled with 1. That's because the empty string is a subsequence of any string but only 1 time. So mem[0][j] = 1 for every j. 
	 * So with this we not only make our lives easier, but we also return correct value if T is an empty string.
	 * the first column of every rows except the first must be 0. This is because an empty string cannot contain a non-empty string as a substring -- 
	 * the very first item of the array: mem[0][0] = 1, because an empty string contains the empty string 1 time.
	 * 
	 * First, if the original string and subsequence are all empty, return 1 because the empty string is also a subsequence of an empty string. 
	 * If the original string is not empty and the subsequence is empty, 1 is also returned because the empty string is also a subsequence of an arbitrary 
	 * string. When the original string is empty and the subsequence is not empty, 0 is returned because non-empty strings cannot be subsequences of empty 
	 * strings. To sort this out, the edges of the two-dimensional array dp can be initialized, and as soon as the recursion is found, the entire dp array 
	 * can be updated. By observing the above two-dimensional array, we can see that dp[i][j] >= dp[i][j - 1] always holds when updating to dp[i][j]. 
	 * When T[i - 1] == S[j - 1], dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1], if not equal , dp[i][j] = dp[i][j - 1].
	 */
	public static int numDistinct(String s, String t) {
		System.out.println("s: "+s+" t: "+t); 
		
		 if(s.isEmpty() || t.isEmpty()) {
			 return 0;
		 }
		 else if (s.length() < t.length()) {
			 return 0;
		 }
		 else
		 {
			 // dynamic programming int ls = s.length (), lt = t.length ();
			 //Saves the number of methods represented by the string s (0, i) -> t (0, j)
			 int[][] dp = new int[s.length()+1][t.length()+1];
			 dp[0][0] = 1;
			 
			 for(int i=0; i<s.length(); i++)
			 {
				//s (0, i) The number of methods converted to t (0) is 1 
				 dp[i][0] = 1;
			 } 
			 for(int i=1; i<=s.length(); ++ i)
			 {
				 for (int j=1; j<=t.length(); ++ j)
				 {
					 //First regardless of whether the current character is the same as initial value dp [i] [j]
					 dp[i][j] = dp[i - 1][j];
					 if(s.charAt(i-1) == t.charAt(j-1))
					 {
						 // If the current characters of s and t are the same, there are two options to retain or not to retain
						 dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
					 } 
				 } 
			 } 
			 return dp[s.length()][t.length()];
		 }
	 }
	
	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		
		System.out.println(numDistinct(S, T));
	}

}
