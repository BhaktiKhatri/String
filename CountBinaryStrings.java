package String;

/**
 * Leetcode 696. Count Binary Substrings
 * https://leetcode.com/problems/count-binary-substrings/description/
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 * Substrings that occur multiple times are counted the number of times they occur.
 * Input: "00110011", Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of times they occur. Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Input: "10101", Output: 4, Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note: s.length will be between 1 and 50,000. s will only consist of "0" or "1" characters.
 * Explanation and Code from: Approach #2: Linear Scan https://leetcode.com/articles/count-binary-substrings/ https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.polarxiong.com/archives/LeetCode-696-count-binary-substrings.html&prev=search
 * @author NisuBhakti
 * Time Complexity: O(N), where N is the length of s. Every loop is through O(N) items with O(1) work inside the for-block.
 * Space Complexity: O(1), the space used by prev, cur, and ans.
 * Easy
 * Helix
 */

public class CountBinaryStrings {

	/*
	 	We can amend our Approach #1 to calculate the answer on the fly. Instead of storing groups, we will remember 
	 	only prev = groups[-2] and cur = groups[-1]. 
	 	Then, the answer is the sum of min(prev, cur) over each different final (prev, cur) we see.
	 */
	public static int countBinarySubstrings(String s) {
		System.out.println(s);
        int ans = 0, prev = 0, cur = 1;
        
        for (int i = 1; i < s.length(); i++) {
        	System.out.println("s.charAt(i-1): "+s.charAt(i-1)+" s.charAt(i): "+s.charAt(i)+" ans: "+ans+" prev: "+prev+" cur: "+cur);
        
        	if (s.charAt(i-1) != s.charAt(i)) {
                ans = ans + Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } 
        	else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
	
	/*
	 * Let's take an example, 00011 here currentLength will become 1 -> 2 ->3 because bits at index 0, 1 and 2 are same i.e. 0's. Then we encounter a 1 bit and at this point we reset the currLength and store it in prevLength.
		The most interesting part is in last if block, where result is incremented. When we are at index 3 i.e. first 1 bit then we would have seen substring 0001 and at this point 01 qualifies as a substring that could be counted towards the final result, so we increment the res. Similarly, when we encounter 2nd 1 bit at that point we would have seen substring 00011 and 0011 also qualifies as a substring that could be counted towards the final result, so we increment the res. Therefore, result is 2.
	 */
	public static int countBinarySubstrings1(String s) {
	    System.out.println("s: "+s);
		int prevRunLength = 0, curRunLength = 1, res = 0;
	    
	    for (int i=1;i<s.length();i++) {
	        System.out.println("i: "+i+" s.charAt(i-1): "+s.charAt(i-1)+" s.charAt(i): "+s.charAt(i)+" curRunLength: "+curRunLength+" prevRunLength: "+prevRunLength+" res: "+res);
	    	if (s.charAt(i) == s.charAt(i-1)) { 
	        	curRunLength++;
	        }
	        else {
	            prevRunLength = curRunLength;
	            curRunLength = 1;
	        }
	        if(prevRunLength >= curRunLength) { 
	        	res++;
	        }
	    }
	    return res;
	}

	
	public static void main(String[] args) {
		//String s = "10101";
		String s = "00011";
		System.out.println(countBinarySubstrings1(s));
	}

}
