package String;

import java.util.Arrays;

/**
 * Leetcode 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example, "A man, a plan, a canal: Panama" is a palindrome, "race a car" is not a palindrome.
 * Explanation and Code from: https://leetcode.com/problems/valid-palindrome/discuss/40029
 * @author NisuBhakti
 * Time Complexity: 
 * Easy
 * Facebook, Microsoft, Uber, Zenefits
 */

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        System.out.println("s: "+s);
        System.out.println("c: "+Arrays.toString(c));
        
        for(int i=0, j=c.length-1; i<j; ) {
        	System.out.println("i: "+i+" j: "+j);
        	System.out.println("c[i]: "+c[i]+" c[j]: "+c[j]);
            
        	if (!Character.isLetterOrDigit(c[i])) {
            	i++;
        	}
            else if (!Character.isLetterOrDigit(c[j])) { 
            	j--;
            }
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--])) { 
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(s);
		System.out.println(isPalindrome(s));
	}

}
