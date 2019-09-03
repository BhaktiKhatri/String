package String;

import java.util.Arrays;

/**
 * Leetcode 387. First Unique Character in a String
 * Create an algorithm to find the first non repetitive character in words like 'television' and 'arizona'  
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * @author NisuBhakti
 * Time Complexity: O(n)
 */

public class FirstUniqueCharacter {
	
	public static char firstUniqChar(String s) {
        int freq [] = new int[26]; //256 to store other kinds of characters
        
        //Get the frequency of each character.
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(freq));
        
        //Get the first character that has a frequency of one
        for(int i=0; i<s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);	//return i; if question asks to return index
            }
        }
        
        return 0;	//return -1;  if question asks to return index
    }

	public static void main(String[] args) {
		System.out.println(firstUniqChar("arizona"));
	}

}
