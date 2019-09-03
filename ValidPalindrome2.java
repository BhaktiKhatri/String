package String;

/**
 * Leetcode 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/discuss/107716
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * Example 1: Input: "aba", Output: True
 * Example 2: Input: "abca", Output: True
 * Explanation: You could delete the character 'c'.
 * Note: The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * Code from: https: @hot13399 //leetcode.com/problems/valid-palindrome-ii/discuss/107716
 * Explanation from: Approach #2: Greedy https://leetcode.com/problems/valid-palindrome-ii/solution/
 * @author NisuBhakti
 * Time Complexity: O(N) where N is the length of the string. Each of two checks of whether some substring is a palindrome is O(N).
 * Space Complexity: O(1) additional complexity. Only pointers were stored in memory.
 * Easy
 * Facebook
 */

public class ValidPalindrome2 {

	/*
	 	Judging from the ends of the string to the middle, if equal then continue to judge.
		If they are not equal, s [i]! = S [j], then it is judged whether i + 1 to j and i to j-1 are palindromic, 
		if yes, then both are satisfied.
	 */
	public static boolean validPalindrome(String s) {
		char[] sc = s.toCharArray();
	    int i = 0;
	    int j = s.length() - 1;
	    System.out.println("s: "+s);
	    
	    while(i < j) {
	    	  System.out.println("i: "+i+" j: "+j+" sc[i]: "+sc[i]+" sc[j]: "+sc[j]);
	        if(sc[i] != sc[j]) {
	          return isPalindromic(sc, i + 1, j) || isPalindromic(sc, i, j - 1);
	        }
	        i++;
	        j--;
	    }
	    return true;
    }

    public static boolean isPalindromic(char[] sc, int i, int j) {
    	while(i < j) {
    		System.out.println("i: "+i+" j: "+j+" sc[i]: "+sc[i]+" sc[j]: "+sc[j]);
            if(sc[i] != sc[j])
            	return false;
            i++; 
            j--;
          }
         return true;
    }
	
	public static void main(String[] args) {
		String s = "abcdbacb";
		System.out.println(s);
		System.out.println(validPalindrome(s));
	}

}
