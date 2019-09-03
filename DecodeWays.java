package String;

import java.util.Arrays;

/**
 * Leetcode 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/description/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12), The number of ways decoding "12" is 2
 * Explanation from: @p0lAris https://www.youtube.com/watch?v=aCKyFYF9_Bg
 * @eason666 https://leetcode.com/problems/decode-ways/discuss/30357/DP-Solution-(Java)-for-reference?page=4
 * Code from: https://leetcode.com/problems/decode-ways/discuss/30357?page=1
 * Time Complexity: O(N); Space Complexity: O(N)
 * Medium
 * Facebook, Microsoft, Uber
 */

public class DecodeWays {

	/*
	 * dp[i] = All possible ways to decode s.substring(0, i)
	 * dp[0] = All possible ways to decode s.substring(0, 0) = ""
	 * dp[1] = All possible ways to decode s.substring(0, 1) = first char of s
	 * All chars except '0' are valid for string of length 1
	 * 
	 * num_ways("123") => "12"(num_ways("3")) + "1"("num_ways("23")) (i.e. num_ways[i+2] + num_ways[i+1])
	 * num_ways("323") => "3"(num_ways("23")) (i.e. num_ways[i+1])
	 */
	
	/*
		s = 123
		build up from right =>

		num_ways("") => 1 (empty string can be represented by empty string) (i.e. num_ways[n] = 1) NOTE: only for build up with a valid string. 
		Empty string on it's own doesn't need to be decoded.
		
		num_ways ("3") => 1 (only one way), i.e. num_ways[n-1] = 1
		num_ways ("23") => "23" or "2"-"3",
		num_ways ("33") => "3""3"
		num_ways ("123") => "12"(num_ways("3")) + "1"("num_ways("23")) (i.e. num_ways[i+2] + num_ways[i+1])
		num_ways ("323") => "3"(num_ways("23")) (i.e. num_ways[i+1])
		
		so basically if s[i:i+1] (both included) <= 26, 
		num_ways[i+2] + num_ways[i+1]
		else:
		num_ways[i+1]
		
		case with 0:
		
		num_ways ("103")
		num_ways ("3") => 1 (only one way)
		num_ways ("03") => 0 (can't decode 0)
		num_ways ("003") => "00"(num_ways("3")) + "0"(num_ways("03")) => no way to decode "00" = 0 + 0
		num_ways ("103") => "10"(num_ways("3")) + "1"(num_ways("03")) => num_ways[i+2] + num_ways[i+1](= 0 in this case)
		num_ways ("1003") => "10"(num_ways("03")) + "1"(num_ways("003")) => same eq = 0(no way to decode "03") + 0(no way to decode 003)
		
		Therefore, if i = '0', let memo[i] = 0, also implements for a string where the ith character == '0', string[i:end] can be decoded in 0 ways.
		"""
	 */
	
	public static int numDecodings(String s) {
        int n = s.length();
        if(n == 0) 
        	return 0;
        
        int[] dp = new int[n+1]; 
        // dp[i] means ways of decoding for substring(i, end). At a certain point i, if the char is '0' then it must be combine with char i-1
        
        dp[n] = 1;									//empty string can be represented by empty string
        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1;		// This is the last character
        // If the last char of the String is '0'. It means there is no way to use it alone as a code. it has to be a part of another code 
        // If the last char is not '0', let's say it's '5', then there is 1 way to use this number as a code

        for(int i=n-2; i>=0; i--) {

        	System.out.println("i: "+i+" dp[i+1]: "+dp[i+1]+" dp[i+2]: "+dp[i+2]+" s.substring(i, i+2): "+s.substring(i, i+2));
        	// Case 1: individual 0 does not work
            // Case 2: 0 preceding any number does not work
            if(s.charAt(i) == '0') {
            	continue;
            }
            
            // dp[i+1] + dp[i+2]
            // The character pair works, so we need to add up the total ways of decoding for the two pairs.
            // dp[i+1]
            // The pair does not work, just need to move the previous total so that dp[0] will eventually have the right count.
            // Notice that we do not need to +1 here because we are counting the number of ways to separate the string.
            else {
            	System.out.println("Integer.parseInt(s.substring(i, i+2)): "+Integer.parseInt(s.substring(i, i+2)));
            	dp[i] = (Integer.parseInt(s.substring(i, i+2)) <= 26) ? dp[i+1] + dp[i+2] : dp[i+1];
            }
        }
        
        System.out.println("dp: "+Arrays.toString(dp));
        return dp[0];
    }
	
	public static int numDecodings1(String s) {
	    System.out.println("s: "+s);
		
	    if(s.length() == 0) { 
	    	return 0;
		}
		
	    int pre = 27;
	    int digit;
	    int answer = 0;
	    int first = 1;
	    int second = 1;
	    
	    for(int i = s.length()-1; i >= 0; i--) {
	        System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i));
	    	
	    	digit = s.charAt(i) - '0';
	    	System.out.println("digit: "+digit+" first: "+first+" pre: "+pre+" second: "+second+" answer: "+answer);
	        
	        if(digit == 0) { 
	        	answer = 0;
	        }
	        else { 
	        	answer = first + (digit*10 + pre < 27 ? second : 0);
	        }
	        second = first; 
	        first = answer; 
	        pre = digit;
	    }
	    System.out.println("answer: "+answer);
	    return answer;
	}
	
    public static int numDecodings2(String s) {
        int len = s.length();
        if(len == 0) {
            return 0;
        }
        System.out.println("s: "+s);

        int pre = 1;
        int cur = s.charAt(0) == '0' ? 0 : 1;
        int tmp=0;
        
        for(int i = 1; i < len && cur != 0; i++) {
        	System.out.println("cur: "+cur+" tmp: "+tmp);
        	
            tmp = cur;
            System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" s.charAt(i-1): "+s.charAt(i-1)+" cur: "+cur+" pre: "+pre+" tmp: "+tmp);
            
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                if (s.charAt(i) == '0') {
                    cur = pre;
                }
                else {
                    cur = cur + pre;
                }
            } 
            else if (s.charAt(i) == '0') {
                cur = 0;
            }
            pre = tmp;
        }
        return cur;
    }

    //https://www.youtube.com/watch?v=RiJBzjtVG3o
    //https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/grandyang/p/4313384.html&prev=search
    public static int numDecodings3(String s) {
        if(s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        System.out.println("s: "+s);
        
        int a=1;
        int b=1;
        
        for(int i=1; i<s.length(); i++) {
        	System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" s.charAt(i - 1): "+s.charAt(i - 1)+" a: "+a+" b: "+b);
        	
        	if(s.charAt(i) == '0') {
        		a = 0;
        	}
        	
        	if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
        		a = a + b;
        		b = a - b;
        	}
        	else {
        		b = a;
        	}
        }
        System.out.println("a: "+a);
        
        return a;
    }
	
	public static void main(String[] args) {
		//String s = "123"; //12-3, 1-23, 1-2-3
		String s = "1234";	//12-3-4; 1-23-4; 1-2-3-4   //22-7, 2-2-7
		System.out.println(s);
		System.out.println(numDecodings3(s));
	}
}