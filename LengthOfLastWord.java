package String;

/**
 * Leetcode 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/description/
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string
 * If the last word does not exist, return 0. Note: A word is defined as a character sequence consists of non-space characters only
 * Example: Input: "Hello World", Output: 5
 * Explanation and Code from: @jianchaolifighter https://leetcode.com/problems/length-of-last-word/description/ 
 * @author NisuBhakti
 * Easy
 */

public class LengthOfLastWord {

	/*
	 * Well, the basic idea is very simple. Start from the tail of s and move backwards to find the first non-space character. 
	 * Then from this character, move backwards and count the number of non-space characters until we pass over the head of s or meet a space character.
	 * The count will then be the length of the last word.
	 */
	public static int lengthOfLastWord(String s) { 
        int len = 0, tail = s.length() - 1;
        
        while (tail >= 0 && s.charAt(tail) == ' ') 
        	tail--;
        
        System.out.println("tail: "+tail);
        
        while (tail >= 0 && s.charAt(tail) != ' ') {
            len++;
            tail--;
        }
        return len;
    }
	
	public static void main(String[] args) {
		String s = "Hello ";
		System.out.println(s);
		System.out.println(lengthOfLastWord(s));
	}

}
