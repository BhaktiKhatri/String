package String;

/**
 * Leetcode 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/description/
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example: Input: s = "abcdefg", k = 2, Output: "bacdfeg"
 * Restrictions: The string consists of lower English letters only. Length of the given string and k will in the range [1, 10000]
 * Explanation and Code from: https://leetcode.com/problems/reverse-string-ii/solution/
 * @author NisuBhakti
 * Time Complexity: O(N), where N is the size of s. We build a helper array, plus reverse about half the characters in s
 * Space Complexity: O(N), the size of a
 * Easy
 * Google
 */

public class ReverseString2 {

	/*
	 	Each block starts at a multiple of 2k: for example, 0, 2k, 4k, 6k, .... One thing to be careful about is we may not reverse each block if
	 	there aren't enough characters. To reverse a block of characters from i to j, we can swap characters in positions i++ and j--.
	 */
	public static String reverseStr(String s, int k) {
		System.out.println(s);
        char[] a = s.toCharArray();
        for(int start=0; start < a.length; start=start+2*k) {
        	
            int i = start;
            int j = Math.min(start + k - 1, a.length - 1);
            
            System.out.println("start: "+start+" i: "+i+" j: "+j);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
	
	public static void main(String[] args) {
		String s = "abcdefgrtj";
		int k = 2;
		System.out.println(reverseStr(s, k));
	}

}
