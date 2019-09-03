package String;

import java.util.Arrays;

/**
 * Leetcode 344. Reverse String
 * https://leetcode.com/problems/reverse-string/discuss/
 * https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://blog.csdn.net/crazy1235/article/details/51420522&prev=search
 * @author NisuBhakti
 * Time Complexity: `O(n)` (Average Case) and `O(n)` (Worst Case) where `n` is the total number character in the input string. The algorithm need to reverse the whole string.
 * Auxiliary Space: `O(n)` space is used where `n` is the total number character in the input string. Space is needed to transform string to character array.
 */

public class ReverseString {

	public static String reverseString(String s) {
        System.out.println("s: "+s+" s.length(): "+s.length());
        
        if (s == null || s.isEmpty()) {
			return "";
		}
		
		char[] word = s.toCharArray();	//Think of it as copying single char and putting it into an array. It depends on number of elements so it's O(n).
        int i = 0;
        int j = s.length() - 1;
        
        System.out.println("word: "+Arrays.toString(word)+" i: "+i+" j: "+j);
        
        while (i < j) {
        	System.out.println("i: "+i+" j: "+j+" word[i]: "+word[i]+" word[j]: "+word[j]);
        	
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        
        System.out.println("word: "+Arrays.toString(word));
        
        return new String(word);
    }
	
	public static void main(String[] args) {
		System.out.println(reverseString("hello how are you"));
	}

}
