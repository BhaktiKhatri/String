package String;

/**
 * Leetcode 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/description/
 * Implement regular expression matching with support for '.' and '*'. '.' Matches any single character. '*' Matches zero or more of the preceding element.
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * Time Complexity: Let T, P be the lengths of the text and the pattern respectively. The work for every call to dp(i, j) for i=0, ... ,T; j=0, ... ,P is done once,
 * and it is O(1) work. Hence, the time complexity is O(TP).
 * Space Complexity: The only memory we use is the O(TP) boolean entries in our cache. Hence, the space complexity is O(TP).
 * Explanation and Code from: https://www.youtube.com/watch?v=l3hda49XcDE&t=939s
 * Hard
 * Google, Facebook, Twitter, Uber, Airbnb
 */

public class RegularExpressionMatching {

	/*
	 * Rule-1: if * i.e a* comes, then check if 0 occurrence of a makes the pattern and string match; if not then check if the character right before the * i.e 
	 * 'a' here matches with the current character in string (check dp[i-1][j] the top value); if in any of the 2 case, both match then true otherwise false
	 * 
	 * Rule-2: if both character in string and pattern matches then check if the part previous to the current character matches or is true then this one is true;
	 * i.e. dp[i-1][j-1] is true then dp[i][j] is true; i.e. the slant/diagonal data; This is also same when pattern has a '.'   
	 */
	public static boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        
        char[] textData = text.toCharArray();
        char[] patternData = pattern.toCharArray();
        
        System.out.println("text: "+text+" pattern: "+pattern);
        
        //Deals with patterns like a* or a*b* or a*b*c*
        for(int i=1; i<dp[0].length; i++) {
        	System.out.println("i: "+i+" patternData[i-1]: "+patternData[i-1]);
        	
        	if(patternData[i-1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                
            	System.out.println("i: "+i+" j: "+j+" patternData[j - 1]: "+patternData[j - 1]+" textData[i - 1]: "+textData[i - 1]);
            	
            	if(patternData[j - 1] == '.' || patternData[j - 1] == textData[i - 1]) {
            		System.out.println("dp[i-1][j-1]: "+dp[i-1][j-1]+" dp[i][j]: "+dp[i][j]);
                    dp[i][j] = dp[i-1][j-1];
                }
            	else if (patternData[j - 1] == '*')  {
            		System.out.println("dp[i][j - 2]: "+dp[i][j - 2]+" dp[i][j]: "+dp[i][j]);
            		
            		dp[i][j] = dp[i][j - 2];
                    
            		System.out.println("patternData[j-2]: "+patternData[j-2]);
            		
                    if(patternData[j-2] == '.' || patternData[j - 2] == textData[i - 1]) {
                    	System.out.println("dp[i][j]: "+dp[i][j]+" dp[i-1][j]: "+dp[i-1][j]);
                    	
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                }
            	else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[0][0];
    }
	
	public static void main(String[] args) {
		String text = "xaabyc";
		String pattern = "xa*b.c";
		
		System.out.println(isMatch(text, pattern));
		
//		System.out.println(isMatch("aa","a"));			//false
//		System.out.println(isMatch("aa","aa"));			//true
//		System.out.println(isMatch("aaa","aa"));		//false
//		System.out.println(isMatch("aa","a*"));			//true
//		System.out.println(isMatch("aa",".*")); 		//true
//		System.out.println(isMatch("ab",".*"));			//true
//		System.out.println(isMatch("aab","c*a*b*"));	//true
	}

}
