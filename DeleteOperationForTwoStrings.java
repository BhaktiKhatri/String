package String;

/**
 * Leetcode 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * Example 1: Input: "sea", "eat", Output: 2, Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note: The length of given words won't exceed 500. Characters in given words can only be lower-case letters.
 * Explanation and Code from: Approach #5 1-D Dynamic Programming https://leetcode.com/problems/delete-operation-for-two-strings/solution/
 * Time complexity : O(m*n), We need to fill in the dp array of size n, m times. Here, m and n refer to the lengths of s1 and s2.
 * Space complexity : O(n), dp array of size n is used.
 * Medium
 * Google
 */

public class DeleteOperationForTwoStrings {

	public static int minDistance(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        
        System.out.println("s1: "+s1+" s2: "+s2);
        
        for(int i = 0; i <= s1.length(); i++) {
            int[] temp=new int[s2.length()+1];
            
            for(int j = 0; j <= s2.length(); j++) {
            	System.out.println("i: "+i+" j: "+j);
               
            	if (i == 0 || j == 0) {
                    temp[j] = i + j;
            	}
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[j] = dp[j - 1];
                }
                else {
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
                }
            }
            dp=temp;
        }
        return dp[s2.length()];
    }
	
	public static void main(String[] args) {
		String s1 = "sea";
		String s2 = "eat";
		System.out.println(minDistance(s1, s2));
	}

}
