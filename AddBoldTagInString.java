package String;

import java.util.Arrays;

/**
 * Leetcode 616. Add Bold Tag in String
 * https://leetcode.com/problems/add-bold-tag-in-string/description/
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * Example 1: Input: s = "abcxyz123" dict = ["abc","123"] Output: "<b>abc</b>xyz<b>123</b>"
 * Example 2: Input: s = "aaabbcc" dict = ["aaa","aab","bc"] Output: "<b>aaabbc</b>c"
 * Note: The given dict won't contain duplicates, and its length won't exceed 100.All the strings in input have length in range [1, 1000].
 * Explanation and Code from: @shawngao https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248
 * Medium
 * Google
 */

public class AddBoldTagInString {

	public static String addBoldTag(String s, String[] dict) {
		System.out.println("s: "+s+" dict: "+Arrays.toString(dict));
		
        boolean[] bold = new boolean[s.length()];
        
        for(int i = 0, end = 0; i < s.length(); i++) {
        	System.out.println("i: "+i+" end: "+end);
            
        	for(String word: dict) {
        		System.out.println("word: "+word+" i: "+i+" s.startsWith(word, i): "+s.startsWith(word, i));
        		if(s.startsWith(word, i)) {
        			System.out.println("end: "+end+" i + word.length(): "+(i + word.length()));
        			end = Math.max(end, i + word.length());
                }
            }
        	System.out.println("end: "+end+" i: "+i+" bold[i]: "+bold[i]);
            bold[i] = end > i;
        }
        
        System.out.println("bold: "+Arrays.toString(bold));
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            System.out.println("i: "+i+"bold[i]: "+bold[i]+" s.charAt(i): "+s.charAt(i)+" result: "+result);
        	if(!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            
        	int j = i;
            while(j < s.length() && bold[j]) { 
            	j++;
            }
            
            System.out.println("i: "+i+" j: "+j+" s.substring(i, j): "+s.substring(i, j));
            
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        System.out.println("result: "+result);
        
        return result.toString();
    }
	
	public static void main(String[] args) {
		String s = "aaabbcc";
		String[] dict = {"aaa","aab","bc"};
		System.out.println(addBoldTag(s, dict));
	}
}
