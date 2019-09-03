package String;

import java.util.HashMap;

/**
 * Leetcode 340. Longest Substring with At Most K Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 * Given a string, find the length of the longest substring T that contains at most k distinct characters
 * For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3
 * Explanation and Code from: https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/ @altertedtuning https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/80047
 * @author NisuBhakti
 * Time Complexity: O(N), Space Complexity: O(K)
 * Google, AppDynamics, Coupang
 */

public class LongestStringWithAtMostKDistinctCharacters {

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		System.out.println("s: "+s+" k: "+k);
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {
            	num++;
            }
            while (num > k) {     			// sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0){ 
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
	
	/*
	 	In this solution, a hashmap is used to track the unique elements in the map. When a third character is added to the map, the left pointer needs to move right.
	 */
	
	public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
		if(k==0 || s==null || s.length()==0)
	        return 0;
	 
	    if(s.length()<k)
	        return s.length();
		
	    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	    int start=0;
	    int maxLen = k;
	    
	    for(int i=0; i<s.length(); i++) {
	        char c = s.charAt(i);
	        if(map.containsKey(c)) {
	            map.put(c, map.get(c)+1);
	        }
	        else {
	            map.put(c,1);
	        }
	 
	        if(map.size() > k) {
	            maxLen = Math.max(maxLen, i-start);
	 
	            while(map.size() > k) {
	                char t = s.charAt(start);
	                int count = map.get(t);
	                if(count > 1) {
	                    map.put(t, count-1);
	                } 
	                else {
	                    map.remove(t);
	                }
	                start++;
	            }
	        }
	    }
	    maxLen = Math.max(maxLen, s.length()-start);
	    return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;
		//System.out.println(lengthOfLongestSubstringKDistinct(s, k));
		System.out.println(lengthOfLongestSubstringTwoDistinct(s, k));
	}

}
