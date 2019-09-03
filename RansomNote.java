package String;

/**
 * Leetcode 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/description/
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note. Note: You may assume that both strings contain only lowercase letters.
 * Explanation and Code from: https://leetcode.com/problems/ransom-note/discuss/85783
 * @author NisuBhakti
 * Time Complexity: O(m+n)
 * Easy
 * Apple
 */

public class RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote.length() > magazine.length())
            return false;
		
		int[] arr = new int[26];
        System.out.println("ransomNote: "+ransomNote+" magazine: "+magazine);
        
        for(int i=0; i<magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<ransomNote.length(); i++) {
        	System.out.println("ransomNote.charAt(i)-'a': "+(ransomNote.charAt(i)-'a'));
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		//System.out.println(canConstruct("a", "b")); 	//false
		//System.out.println(canConstruct("aa", "ab"));   //false
		System.out.println(canConstruct("aa", "aab"));  //true
	}
}