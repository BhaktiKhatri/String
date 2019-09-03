package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode 249. Group Shifted Strings
 * https://leetcode.com/problems/group-shifted-strings/description/
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * A solution is:
 *	[
 *	  ["abc","bcd","xyz"],
 *	  ["az","ba"],
 *	  ["acef"],
 *	  ["a","z"]
 *	]
 * Explanation and Code from: @diddit https://leetcode.com/problems/group-shifted-strings/discuss/67442?page=1
 * https://www.geeksforgeeks.org/group-shifted-string/
 * Medium
 * Google, Uber
 */

public class GroupShiftedStrings {

	/*
	 	Here’s my solution and explanation for people who don’t understand.
	 	Basically we need to form some sort of key for each word to group them. (Remember the idea of group all anagrams?)
	 	Consider acf and pru. Now notice the differnce between each characters.
		acf = 0->2->3, and pru = 0->2->3. So these two form same group. So in this case, you can simply use integers ASCII difference to form key.
		Now consider corner case, az and ba, where az = 0->25 and ba = 0->-1. When it goes negative, just make it positive
		(rotate or mod equivalent) by adding 26. So it becomes, ba = 0->25, which forms same group.
	 */
	
	public static List<List<String>> groupStrings(String[] strings) {
	    List<List<String>> ret = new ArrayList<List<String>>();
	    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	    
	    System.out.println("strings: "+Arrays.toString(strings));
	    
	    for(String s: strings) {
	    	System.out.println("s: "+s);
	    	char[] ch = s.toCharArray();
	        String key = "";
	        System.out.println("ch: "+Arrays.toString(ch));
	        
	        for(int i=1; i<ch.length; i++) {
	        	System.out.println("i: "+i+" ch[i]: "+ch[i]+" ch[i-1]: "+ch[i-1]);
	            
	        	int offset = ch[i] - ch[i-1];
	            System.out.println("offset: "+offset);
	            
	            key = key + (offset < 0 ? offset + 26 : offset);
	            System.out.println("key: "+key);
	        }
	        System.out.println("map: "+map);
	        
	        if(!map.containsKey(key)) {
	        	map.put(key, new ArrayList<String>());
	        }
	        map.get(key).add(s);
	    }
	    
	    System.out.println("map: "+map);
	    
	    for(List<String> ss : map.values()) {
	        Collections.sort(ss);
	        ret.add(ss);
	    }
	    System.out.println("ret: "+ret);
	    return ret;
	}	
	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(groupStrings(strings));
	}

}
