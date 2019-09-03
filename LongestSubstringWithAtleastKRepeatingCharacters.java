package String;

import java.util.Arrays;

/*
 * 395. Longest Substring with At Least K Repeating Characters
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * Example 1: Input: s = "aaabb", k = 3; Output: 3
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2: Input: s = "ababbc", k = 2; Output: 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * Explanation and Code from: @hayleyhu https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87768/4-lines-Python
 * Baidu
 * Medium
 */

public class LongestSubstringWithAtleastKRepeatingCharacters {

	/*
	 If every character appears at least k times, the whole string is ok. Otherwise split by a least frequent character (because it will always be too infrequent
	 and thus can't be part of any ok substring) and make the most out of the splits.
	 */
	public static int longestSubstring(String s, int k) {
        int len = s.length();
        
        if(len == 0 || len < k)
        	return 0;
        
        if(k == 1) 
        	return len;
        
        System.out.println("s: "+s+" k: "+k);
        
        int[] count = new int[26];
        
        for(int i=0; i<len; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        System.out.println(Arrays.toString(count));
        
        char bad = 0;
        
        for(int i=0; i<26; i++) {
        System.out.println("i: "+i+" count[i]: "+count[i]);
        	
        	if(count[i] > 0 && count[i] < k) {
        		System.out.println("bad: "+bad);
            
        		bad = (char)(i + 'a');
                
        		System.out.println("bad: "+bad);
                break;
            }
        }
        
        System.out.println("bad: "+bad);
        
        if(bad == 0)
        	return len;
        
        int index = s.indexOf(bad);
        System.out.println("index: "+index);
        
        System.out.println("s.substring(0, index): "+s.substring(0, index));
        int left = longestSubstring(s.substring(0, index), k);
        System.out.println("left: "+left);
        
        System.out.println("s.substring(index + 1): "+s.substring(index + 1));
        int right = longestSubstring(s.substring(index + 1), k);
        System.out.println("right: "+right);
        
        int res = Math.max(left, right);
        System.out.println("res: "+res);
        
        return res;
    }
	
	public static void main(String[] args) {
		String s = "aaabb";
		int k = 3;
		
		System.out.println(longestSubstring(s, k));
	}
}
