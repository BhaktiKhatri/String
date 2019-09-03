package String;

import java.util.Arrays;

/**
 * Leetcode 186. Reverse Words in a String II
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * Explanation and Code from: https://leetcode.com/problems/reverse-words-in-a-string-ii/discuss/53775
 * Time Complexity: O(n)
 * Microsoft, Amazon, Uber
 */

public class ReverseWordsInString2 {

	/*
	 * @FreeLance not quite, it's more like 3n which is O(n). Here's the break down.
		reverse the whole string, this is n steps.
		advance right pointer to find end of word, the right pointer just advances through whole string and never backtracks, so this is n iterations.
		reverse the word found, if word is length m, this is m steps, but consider all words together will be n, so this is also n steps total for all
		words.
		total is 3n which is just O(n)
	 */
	public static char[] reverseWords(String str) {
		char[] s = str.toCharArray();

		// Three step to reverse
	    // 1, reverse the whole sentence
	    reverse(s, 0, s.length - 1);
	    
	    // 2, reverse each word
	    int start = 0;
	    for (int i=0; i<s.length; i++) {
	        if (s[i] == ' ') {
	            reverse(s, start, i - 1);
	            start = i + 1;
	        }
	    }

	    // 3, reverse the last word, if there is only one word this will solve the corner case
    	reverse(s, start, s.length - 1);
	    return s;
	}

	public static void reverse(char[] s, int start, int end) {
	    while (start < end) {
	        char temp = s[start];
	        s[start] = s[end];
	        s[end] = temp;
	        start++;
	        end--;
	    }
	}
	
	public static void main(String[] args) {
		//char[] arr = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		//System.out.println(arr);
		String str = "Let's take LeetCode contest";
		System.out.println(str);
		char[] result = reverseWords(str);
		System.out.println(":"+Arrays.toString(result)+":");
	}
}