package String;

import java.util.HashMap;

/*
 * Leetcode 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
 * Explanation and Code from: https://leetcode.com/problems/minimum-window-substring/discuss/26808
 * Facebook, Uber, LinkedIn, Snapchat
 * >Medium
 */

public class MinimumWindowSubString {

	/*
	 	1. Use two pointers: start and end to represent a window.
		2. Move end to find a valid window.
		3. When a valid window is found, move start to find a smaller window.
	 */
	public static String minWindow(String s, String t) {
	    HashMap<Character,Integer> map = new HashMap<Character, Integer>();	//To check if a window is valid, we use a map to store (char, count) for chars in t
	    
	    System.out.println("s: "+s+" t: "+t);
	    
	    for(char c: s.toCharArray()) {
	        map.put(c,0);
	    }
	    System.out.println("map: "+map);
	    
	    for(char c: t.toCharArray()) {
	    	System.out.println("c: "+c);
	        
	    	if(map.containsKey(c)) {
	            map.put(c, map.get(c)+1);		//use counter for the number of chars of t to be found in s
	        }
	    }
	    System.out.println("map: "+map);
	    int start=0, end=0, minStart=0, minLen=Integer.MAX_VALUE, counter=t.length();	// counter represents the number of chars of t to be found in s
	    
        //String s = "ADOBECODEBANC"; String t = "ABC";
	    while(end < s.length())					// Move end to find a valid window
	    {
	    	System.out.println("end: "+end+" s.length(): "+s.length());

	    	char c1 = s.charAt(end);
	        System.out.println("c1: "+c1+" map.get(c1): "+map.get(c1)+" counter: "+counter);
	        
	        if(map.get(c1) > 0)	{				// If char in s exists in t, decrease counter
	            counter--;				
	        }
	        
	        map.put(c1, map.get(c1)-1);		//This is the key part. We decrease count for each char in s. If it does not exist in t, the count will be negative
	        end++;
	        
	        System.out.println("map: "+map+" end: "+end+" counter: "+counter);
	        
	        //String s = "ADOBECODEBANC"; String t = "ABC";
	        while(counter == 0)				// When we found a valid window, move start to find smaller window
	        {
	        	System.out.println("minLen: "+minLen+" end: "+end+" start: "+start+" end-start: "+(end-start));
	            if(minLen > end-start)
	            {
	                minLen = end - start;
	                minStart = start;
	            }
	            
	            char c2 = s.charAt(start);
	            System.out.println("c2: "+c2);
	            
	            map.put(c2, map.get(c2)+1);
	            System.out.println("map: "+map);
	            
	            if(map.get(c2) > 0) {
	                counter++;				// When char exists in t, increase counter
	            }
	            start++;
	        }
	    }
	    
	    System.out.println("minLen: "+minLen+" minStart: "+minStart+" s.substring(minStart,minStart+minLen): "+s.substring(minStart, minStart+minLen));
	    
	    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println("s: "+s+" t: "+t);
		System.out.println(minWindow(s, t));
	}

}
