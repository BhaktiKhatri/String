package String;

/**
 * Leetcode 536. Construct Binary Tree from String
 * https://leetcode.com/problems/construct-binary-tree-from-string/description/
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 * You always start to construct the left child node of the parent first if it exists.
 * Example: Input: "4(2(3)(1))(6(5))" Output: return the tree root node representing the following tree:
 *	       4
 *	     /   \
 *	    2     6
 *	   / \   / 
 *	  3   1 5   
 * Note: There will only be '(', ')', '-' and '0' ~ '9' in the input string. An empty tree is represented by "" instead of "()".
 * Explanation and Code from: @compton_scatter https://leetcode.com/problems/construct-binary-tree-from-string/discuss/100355?page=2
 * Medium
 * Amazon
 */

public class ConstructBinaryTreeFromString {

	public static TreeNode str2tree(String s) {
		System.out.println("s: "+s);
	    
		if(s == null || s.length() == 0)
	    	return null;
	    
	    int firstParen = s.indexOf("(");
	    System.out.println("firstParen: "+firstParen);
	    
	    int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
	    System.out.println("val: "+val);
	    
	    TreeNode cur = new TreeNode(val);
	    if(firstParen == -1)
	    	return cur;
	    
	    int start = firstParen;
	    int leftParenCount = 0;
	    System.out.println("start: "+start);
	    
	    for(int i=start; i<s.length(); i++) {
	    	System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" leftParenCount: "+leftParenCount+" start: "+start);
	    	
	    	if(s.charAt(i) == '(') {
	        	leftParenCount++;
	        }
	        else if (s.charAt(i) == ')') { 
	        	leftParenCount--;
	        }
	        
	        if(leftParenCount == 0 && start == firstParen) {
	        	cur.left = str2tree(s.substring(start+1,i)); 
	        	start = i+1;
	        }
	        else if(leftParenCount == 0) {
	        	cur.right = str2tree(s.substring(start+1,i));
	        }
	    }
	    return cur;
	}
	
	public static void main(String[] args) {
		String s = "4(2(3)(1))(6(5))";
		System.out.println("ans: "+str2tree(s).val);
	}

}
