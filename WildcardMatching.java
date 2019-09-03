package String;

/**
 * Leetcode 44. Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/description/
 * Implement wildcard pattern matching with support for '?' and '*'
 * '?' Matches any single character
 * '*' Matches any sequence of characters (including the empty sequence)
 * The matching should cover the entire input string (not partial)
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * Some examples: isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * @author NisuBhakti
 * Google, Facebook, Twitter, Snapchat, Two Sigma
 */

public class WildcardMatching {

	public static boolean isMatch(String str, String pattern) {
		System.out.println("str: "+str+" pattern: "+pattern);
        int s = 0, p = 0;
        int match = 0; 						//stores the position of the previous matched char in s after a *
        int starIdx = -1;					//stores the position of last * in p            
        while (s < str.length()) {
        	System.out.println("s: "+s+" p: "+p+" starIdx: "+starIdx+" match: "+match);
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aa","a"));			//false
		System.out.println(isMatch("aa","aa")); 		//true
		System.out.println(isMatch("aaa","aa")); 		//false
		System.out.println(isMatch("aa", "*"));  		//true
		System.out.println(isMatch("aa", "a*"));  		//true
		System.out.println(isMatch("ab", "?*") );  		//true
		System.out.println(isMatch("aab", "c*a*b")); 	//false
	}

}
