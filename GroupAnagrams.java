package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Leetcode 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	] 
 * Note: All inputs will be in lower-case.
 * Explanation and Code from: @legendaryengineer https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution 
 * Time Complexity: O(n * s logs), n is the number of string in strs array and s is the maximum length of string in the strs array
 * Time Complexity: O(N∗K), where N is the length of strs, and K is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.
 * Space Complexity: O(N*K), the total information content stored in ans.
 * Medium
 * Facebook, Amazon, Bloomberg, Uber, Yelp
 */

public class GroupAnagrams {
		
	public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) 
        	return new ArrayList<List<String>>();
        
        System.out.println("strs: "+Arrays.toString(strs));
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s: strs) {
            System.out.println("s: "+s);
        	char[] ca = s.toCharArray();
            
        	Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            System.out.println("keyStr: "+keyStr);
            
            if(!map.containsKey(keyStr)) 
            	map.put(keyStr, new ArrayList<String>());
            
            map.get(keyStr).add(s);
            System.out.println("map: "+map);
        }
        return new ArrayList<List<String>>(map.values());
    }
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(Arrays.toString(strs));
		System.out.println(groupAnagrams(strs));
	}

}
