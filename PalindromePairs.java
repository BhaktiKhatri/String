package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 336. Palindrome Pairs
 * https://leetcode.com/problems/palindrome-pairs/description/
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * Example 1: Given words = ["bat", "tab", "cat"], Return [[0, 1], [1, 0]], The palindromes are ["battab", "tabbat"]
 * Explanation and Code from: @yfcheng https://leetcode.com/problems/palindrome-pairs/discuss/79199/150-ms-45-lines-JAVA-solution 
 * https://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
 * Time Complexity: O(n(k^2)), Where n is the number of words in the list and k is the maximum length that is checked for palindrome.
 *
 */

public class PalindromePairs {

	public static List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> res = new ArrayList<>(); 
	    if(words == null || words.length < 2) {
	        return res;
	    }
	    
	    System.out.println("words: "+Arrays.toString(words));
	    
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for(int i=0; i<words.length; i++) {
	        map.put(words[i], i);
	    }
	    
	    System.out.println("map: "+map);
	    
	    for(int i=0; i<words.length; i++) {
	        for(int j=0; j<=words[i].length(); j++) {
	        	System.out.println("i: "+i+" words[i]: "+words[i]+" j: "+j);
	        	
	            String str1 = words[i].substring(0, j);
	            String str2 = words[i].substring(j);
	            
	            System.out.println("str1: "+str1+" str2: "+str2);
	            addPair(map, res, str1, str2, i, false);
	            
	            System.out.println("map: "+map+" res: "+res);
	            
	            if(str2.length() != 0) {
	                addPair(map, res, str2, str1, i, true);
	            }
	        }
	    }
	    return res;
	}
	
	private static void addPair(Map<String, Integer> map, List<List<Integer>> res, String str1, String str2, int index, boolean reverse) {
	    System.out.println("str1: "+str1+" str2: "+str2+" map: "+map+" res: "+res+" index: "+index+" reverse: "+reverse);
		
		if(isPalindrome(str1)) {
	        String str2rev = new StringBuilder(str2).reverse().toString();
	        System.out.println("str2rev: "+str2rev);
	        
	        if(map.containsKey(str2rev) && map.get(str2rev) != index) {
	            List<Integer> list = new ArrayList<>();
	            if(!reverse) {
	                list.add(map.get(str2rev));
	                list.add(index);
	            } 
	            else {
	                list.add(index);
	                list.add(map.get(str2rev));
	            }
	            res.add(list);
	        }
	    }
	}
	
	private static boolean isPalindrome(String str) {
	    int i = 0;
	    int j = str.length() - 1;
	    while (i <= j) {
	        if (str.charAt(i) !=  str.charAt(j)) { 
	        	return false;
	        }
	        i++;
	        j--;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"bat", "tab", "cat"};
		System.out.println(palindromePairs(words));
	}

}
