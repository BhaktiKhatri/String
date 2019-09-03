package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
		[
		  "((()))",
		  "(()())",
		  "(())()",
		  "()(())",
		  "()()()"
		]
 * Explanation and Code from: Appraoach #2 Backtracking, https://leetcode.com/problems/generate-parentheses/solution/
 * Our complexity analysis rests on understanding how many elements there are in generateParenthesis(n). 
 * This analysis is outside the scope of this article, but it turns out this is the n-th Catalan number (1/n+1)binom{2n}{n}, which is bounded
 * asymptotically by 4^n/(n* sqrt(n))
 * Time Complexity : O(4^n)/(sqrt(n)), Each valid sequence has at most n steps during the backtracking procedure.
 * Space Complexity : O(4^n)/(sqrt(n)), as described above, and using O(n)O(n) space to store the sequence.
 * Medium
 * Google, Uber, Zenefits
 */

public class GenerateParentheses {
	
	/*
	 	We can start an opening bracket if we still have one (of n) left to place. And we can start a closing bracket if it would not exceed
	    the number of opening brackets.
	 */

	public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        System.out.println("n: "+n);
        int ind=1;
        backtrack(list, "", 0, 0, n, 1);
        System.out.println("ind: "+ind);
        return list;
    }
    
    public static void backtrack(List<String> list, String str, int open, int close, int max, int ind) {
        System.out.println("list: "+list+" str: "+str+" open: "+open+" close: "+close+" max: "+max+" ind: "+ind);
    	
        if(str.length() == max*2) {
        	System.out.println("open: "+open+" close: "+close+" str: "+str+" ind: "+ind);
            list.add(str);
            return;
        }
        
        System.out.println("open: "+open+" close: "+close+" max: "+max+" str: "+str+" ind: "+ind);
        if(open < max) {
            backtrack(list, str+"(", open+1, close, max, ind+1);
            System.out.println("in if open open: "+open+" close: "+close+" str: "+str+" ind: "+ind);
        }
        
        System.out.println("open: "+open+" close: "+close+" max: "+max+" str: "+str+" ind: "+ind);
        if(close < open) {
            backtrack(list, str+")", open, close+1, max, ind+1);
            System.out.println("in if close open: "+open+" close: "+close+" str: "+str+" ind: "+ind);
        }
    }
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateParenthesis(n));
	}

}
