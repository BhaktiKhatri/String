package String;

import java.util.Arrays;

/**
 * Leetcode 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * Example 1: Input: "Let's take LeetCode contest", Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * Explanation and Code from: https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/
 * @author NisuBhakti
 * Time complexity : O(n), Single loop up to n is there, where n is the length of the string. 
 * Space complexity : O(n), result and word size will grow up to n.
 * Easy
 * Zappos
 */

public class ReverseWordsInAString3 {

	public static String reverseWords1(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse()+" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
	
	public static String reverseWords(String s) {
		System.out.println("s: "+s);
        
		String[] str = s.split(" ");
        System.out.println("str: "+Arrays.toString(str));
        
        for(int i=0; i<str.length; i++) { 
        	System.out.println("i: "+i+" str[i]: "+str[i]);
        	str[i] = new StringBuilder(str[i]).reverse().toString();
        }
        System.out.println("str: "+Arrays.toString(str));
        
        StringBuilder result = new StringBuilder();
        for(String st : str) { 
        	System.out.println("st: "+st+" result: "+result);
        	result.append(st + " ");
        }
        System.out.println("result: "+result);
        
        return result.toString().trim();
    } 
	
	public static void main(String[] args) {
		String input = " Let's take LeetCode contest ";
		System.out.println(input);
		System.out.println(":"+reverseWords(input)+":");
	}

}
