package String;

import java.util.HashMap;
import java.util.Map;

/*
 	Leetcode 3. Longest Substring Without Repeating Characters
 	https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 	Given a string, find the length of the longest substring without repeating characters.
 	Examples:

	Given "abcabcbb", the answer is "abc", which the length is 3.
	Given "bbbbb", the answer is "b", with the length of 1.
	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	
	Explanation and Code from: Approach #3 Sliding Window Optimized https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
	
	Time complexity : O(n), Index j will iterate n times.
	Space complexity (HashMap) : O(min(m,n)), Same as the previous approach.
	
	String, HashTable, Two Pointers
	
	Amazon, Bloomberg, Yelp, Adobe
 */

public class LongestSubstringWithoutRepeatingCharacters {

	/*
	 the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which 
	 define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already
	 in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
	 */
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); 		// current index of character; key-character; value-index of character
        System.out.println("s: "+s);
        
        for(int j=0, i=0; j<n; j++) {						// try to extend the range [i, j]
        	System.out.println("i: "+i+" j: "+j+" s.charAt(j): "+s.charAt(j)+" map: "+map);
            
        	if(map.containsKey(s.charAt(j))) {
        		System.out.println("i: "+i+" map.get(s.charAt(j)): "+map.get(s.charAt(j)));
                i = Math.max(map.get(s.charAt(j)) + 1, i);			//if i is not increment then only j will increment and ans will take s.length(j) - 0(i)
                //map.get(s.charAt(j)) gives previous index of repeated character so if we include the current character at index j then
                //we have to remove the previous character index to get non-repeated substring
                //max(,i) because i moves only forward 
                //OR
                //if character is repeating then move i to next character after repeated character
            }
        	
        	System.out.println("j: "+j+" i: "+i);
            ans = Math.max(ans, j - i + 1);
            
            System.out.println("ans: "+ans);
            map.put(s.charAt(j), j);
            
            System.out.println("map: "+map);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String s = "tmmzuxt";  //"abbbbbbacd";
		System.out.println(lengthOfLongestSubstring(s));
	}
}