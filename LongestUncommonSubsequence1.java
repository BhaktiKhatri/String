package String;

/**
 * Leetcode 521. Longest Uncommon Subsequence I
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as 
 * the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. 
 * Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence.
 * If the longest uncommon subsequence doesn't exist, return -1.
 * Input: "aba", "cdc", Output: 3, Explanation: The longest uncommon subsequence is "aba" (or "cdc"), because "aba" is a subsequence of "aba", 
 * but not a subsequence of any other strings in the group of two strings. 
 * Note: Both strings' lengths will not exceed 100; Only letters from a ~ z will appear in input strings
 * @author NisuBhakti
 * Time complexity : O(min(x,y)), where x and y are the lengths of strings a and b respectively. Here equals method will take min(x,y) time.
 * Space complexity : O(1), No extra space required.
 * Easy
 * Google
 */

public class LongestUncommonSubsequence1 {

	//For the case of a="abc" and b="avbfc", the result should actually be 5. The longest uncommon subsequence would be "avbfc";
	//it's a subsequence of avbfc, and not of abc, fulfilling the requirement for longest uncommon subsequence.
	public static int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        else 
        	return Math.max(a.length(), b.length());
    }
	
	public static void main(String[] args) {
		String a = "abd";
		String b = "abc";
		System.out.println(findLUSlength(a, b));
	}

}
