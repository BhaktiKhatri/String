package String;

/**
 * Leetcode 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/description/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example, Given: s1 = "aabcc", s2 = "dbbca", When s3 = "aadbbcbcac", return true; When s3 = "aadbbbaccc", return false
 * Explanation and Code from: Approach #4 https://leetcode.com/problems/interleaving-string/solution/
 * @author NisuBhakti
 * Time complexity : O(m*n), dp array of size n is filled m times. Space complexity : O(n), n is the length of the string s1.
 */

public class InterleavingString {

	 public static boolean isInterleave(String s1, String s2, String s3) {
	        if (s3.length() != s1.length() + s2.length()) {
	            return false;
	        }
	        
	        boolean dp[] = new boolean[s2.length() + 1];
	        
	        for (int i = 0; i <= s1.length(); i++) {
	            for (int j = 0; j <= s2.length(); j++) {
	        
	            	System.out.println("i: "+i+" j: "+j);
	                if (i == 0 && j == 0) {
	                    dp[j] = true;
	                } 
	                else if (i == 0) {
	                	System.out.println("s2.charAt(j - 1): "+s2.charAt(j - 1)+" s3.charAt(i + j - 1): "+s3.charAt(i + j - 1));
	                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
	                } 
	                else if (j == 0) {
	                	System.out.println("s1.charAt(i - 1): "+s1.charAt(i - 1)+" s3.charAt(i + j - 1): "+s3.charAt(i + j - 1));
	                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
	                } 
	                else {
	                	System.out.println("s1.charAt(i - 1): "+s1.charAt(i - 1)+" s3.charAt(i + j - 1): "+s3.charAt(i + j - 1)+" s2.charAt(j - 1): "+s2.charAt(j - 1));
	                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
	                }
	            }
	        }
	        return dp[s2.length()];
	    }
	
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println("s1: "+s1+" s2: "+s2+" s3: "+s3);
		System.out.println(isInterleave(s1, s2, s3));
	}

}
