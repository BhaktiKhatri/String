package String;

import java.util.Stack;

/**
 * Leetcode 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4
 * Explanation/Example and Code from: Approach #3 Using Stack https://leetcode.com/problems/longest-valid-parentheses/solution/
 * Time complexity : O(n), n is the length of the given string; Space complexity : O(n), The size of stack can go up to n
 */

public class LongestValidParentheses {

	/*
	 	Algorithm:
	 	Instead of finding every possible string and checking its validity, we can make use of stack while scanning the given string to check 
	 	if the string scanned so far is valid, and also the length of the longest valid string. 
	 	In order to do so, we start by pushing -1−1 onto the stack. For every \text{‘(’}‘(’ encountered, we push its index onto the stack.
	 	For every \text{‘)’}‘)’ encountered, we pop the topmost element and subtract the current element's index from the top element of the stack,
	 	which gives the length of the currently encountered valid string of parentheses. If while popping the element, the stack becomes empty, 
	 	we push the current element's index onto the stack.
	 	In this way, we keep on calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.
	 */
	
	public static int longestValidParentheses(String s) {
		int maxAns = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}
			else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				}
				else {
					maxAns = Math.max(maxAns, i - stack.peek());
				}
			}
		}
		return maxAns;
	}
	
	public static void main(String[] args) {

	}

}
