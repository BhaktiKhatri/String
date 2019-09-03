package String;

/**
 * Leetcode 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1: Input: word1 = "horse", word2 = "ros"; Output: 3
 * Explanation: horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2: Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: https://www.youtube.com/watch?v=We3YDTzNXEk&t=62s
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 *
 */

public class EditDistance {
	
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		
        int dp[][] = new int[m+1][n+1];						// Create a table to store results of subproblems
      
        for (int i=0; i<=m; i++)							// Fill d[][] in bottom up manner
        {
            for (int j=0; j<=n; j++)
            {
                if (i==0)									// If first string is empty, only option is to insert all characters of second string
                    dp[i][j] = j;  							// Min. operations = j
      
                else if (j==0)								// If second string is empty, only option is to remove all characters of second string
                    dp[i][j] = i; 							// Min. operations = i
      
                else if (word1.charAt(i-1) == word2.charAt(j-1))	// If last characters are same, ignore last char and recur for remaining string
                    dp[i][j] = dp[i-1][j-1];
      
                else											// If last character are different, consider all possibilities and find minimum
                    dp[i][j] = 1 + min(dp[i][j-1],  			// Insert
                                       dp[i-1][j],  			// Remove
                                       dp[i-1][j-1]); 			// Replace
            }
        }
  
        return dp[m][n];
    }

	public static int min(int x,int y,int z)
    {
        if (x <= y && x <= z) return x;
        else if (y <= x && y <= z) return y;
        else return z;
    }
	
	public static void main(String[] args) {
		String word1 = "geeks";
		String word2 = "cheeks";
		System.out.println("word1: "+word1+" word2: "+word2);
		System.out.println(minDistance(word1, word2));
	}

}
