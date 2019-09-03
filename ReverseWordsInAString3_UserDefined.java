package String;

import java.util.ArrayList;

/**
 * Leetcode 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * Example 1: Input: "Let's take LeetCode contest", Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * Explanation and Code from: https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/
 * @author NisuBhakti
 * Time complexity : O(n), where n is the length of the string. Space complexity : O(n), res of size n is used.
 * Easy
 * Zappos
 */

public class ReverseWordsInAString3_UserDefined {

	public static String reverseWords(String s) {
        String words[] = split(s);
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(reverse(word) + " ");
        return res.toString().trim();
    }
	
    public static String[] split(String s) {
        ArrayList<String> words = new ArrayList<String>();
        StringBuilder word = new StringBuilder();
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(word.toString());
                word = new StringBuilder();
            } 
            else
                word.append( s.charAt(i));
        }
        words.add(word.toString());
        return words.toArray(new String[words.size()]);
    }
    
    public static String reverse(String s) {
      StringBuilder res=new StringBuilder();
        for (int i=0; i<s.length(); i++)
            res.insert(0,s.charAt(i));
        return res.toString();
    }
	
	public static void main(String[] args) {
		String input = "Let's take LeetCode contest";
		System.out.println(input);
		System.out.println(reverseWords(input));
	}
}