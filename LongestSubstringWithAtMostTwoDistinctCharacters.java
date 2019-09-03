package String;

import java.util.HashMap;

/**
 * Leetcode 159. Longest Substring with At Most Two Distinct Characters
 * 159. Longest Substring with At Most Two Distinct Characters
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”, T is "ece" which its length is 3.
 * Explanation and Code from: Leetcode 340. Longest Substring with At Most K Distinct Characters https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 * @author NisuBhakti
 * Time Complexity: O(N), Space Complexity: O(K)
 * Google
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		if(s.length() < 2)
			return s.length();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLen = 2;
		int start = 0;
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}
			else {
				map.put(ch, 1);
			}
			
			if(map.size() > 2) {
				maxLen = Math.max(maxLen, i - start);
			
				while(map.size() > 2) {
					char t = s.charAt(start);
					int count = map.get(t);
					
					if(count > 2) {
						map.put(t, count-1);
					}
					else {
						map.remove(t);
					}
					start++;
				}
			}
		}
		maxLen = Math.max(maxLen, s.length() - start);
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}

}
