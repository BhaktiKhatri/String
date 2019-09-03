package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given: s: "barfoothefoobarman", words: ["foo", "bar"], You should return the indices: [0,9] (order does not matter)
 * Explanation and Code from: @qlan2 https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13656?page=1 
 * @author NisuBhakti
 * Time Complexity is O(KN), K = L[0].length(), N = S.length()
 */

public class SubstringWithConcatenationOfAllWords {

	// Sliding Window 360ms
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0)  
        	return res;
        
        int N = S.length(), M = L.length, K = L[0].length();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> curMap = new HashMap<>();
        
        for (String s : L) {
            if (map.containsKey(s))   
            	map.put(s, map.get(s) + 1);
            else                      
            	map.put(s, 1);
        }
        
        String str = null, tmp = null;
        
        for (int i = 0; i < K; i++) {					        // travel all sub string combinations
            int count = 0;  // remark: reset count 
            for (int l = i, r = i; r + K <= N; r = r + K) {
                str = S.substring(r, r + K);
                System.out.println("i: "+i+" l: "+l+" r: "+r+" str: "+str);

                if (map.containsKey(str)) {						// a valid word, accumulate results
                    if (curMap.containsKey(str))   
                    	curMap.put(str, curMap.get(str) + 1);
                    else                           
                    	curMap.put(str, 1);
                    
                    if (curMap.get(str) <= map.get(str))    
                    	count++;
                    
                    while (curMap.get(str) > map.get(str)) {	// a more word, advance the window left side possiablly
                        tmp = S.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += K;
                        if (curMap.get(tmp) < map.get(tmp)) 
                        	count--;
                    }
                    if (count == M) {							// come to a result
                        res.add(l);
                        tmp = S.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);	// advance one word
                        l = l + K;
                        count--;
                    }
                }
                else {
                    curMap.clear();								// not a valid word, reset all vars
                    count = 0;
                    l = r + K;
                }
            }
            curMap.clear();
        }
        return res;
    }
	
	public static void main(String[] args) {
		String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";						//"lingmindraboofooowingdingbarrwingmonkeypoundcake"
		String[] L = {"fooo","barr","wing","ding","wing"};						//["fooo","barr","wing","ding","wing"]
		System.out.println("S: "+S+" L: "+Arrays.toString(L));
		System.out.println(findSubstring(S, L));
		//"barfoofoobarthefoobarman"		["bar","foo","the"] [6,9,12]
	}

}