package String;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Leetcode 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don'root affect the one-to-one mapping relationship between the string and the original binary tree.
 * Input: Binary tree: [1,2,3,4]
 *	       1
 *	     /   \
 *	    2     3
 *	   /    
 *	  4     	
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)".
 * Input: Binary tree: [1,2,3,null,4]
 *	       1
 *	     /   \
 *	    2     3
 *	     \  
 *	      4 	
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we can'root omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 * Explanation and Code: Approach #1 Using Recursion https://leetcode.com/problems/construct-string-from-binary-tree/solution/
 * Time complexity : O(n), The preorder traversal is done over the n nodes of the given Binary Tree.
 * Space complexity : O(n), The depth of the recursion tree can go up to n in case of a skewed tree.
 * Easy
 * Amazon
 */
public class ConstructStringFromBinaryTree {

	/*
	 	Case 1: Both the left child and the right child exist for the current node. In this case, we need to put the braces () around both the left child's
	 	preorder traversal output and the right child's preorder traversal output.

		Case 2: None of the left or the right child exist for the current node. In this case, as shown in the figure below, considering empty braces for the 
		null left and right children is redundant. Hence, we need not put braces for any of them.

		Case 3: Only the left child exists for the current node. As the figure below shows, putting empty braces for the right child in this case is unnecessary 
		while considering the preorder traversal. This is because the right child will always come after the left child in the preorder traversal.
		Thus, omitting the empty braces for the right child also leads to same mapping between the string and the binary tree.
	 
	 	Case 4: Only the right child exists for the current node. In this case, we need to consider the empty braces for the left child. This is because,
	 	during the preorder traversal, the left child needs to be considered first. Thus, to indicate that the child following the current node is a right
	 	child we need to put a pair of empty braces for the left child.
	 */
	
	public TreeNode root = null;
	public static String res = "";
	
	/*
			 		       1
					     /   \
					    2     3
					   /       \
					  4     	6
	 */
	
	public static String tree2str(TreeNode root) {
        if(root == null) 
            return "";
        System.out.println("root: "+root.val);
        
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        System.out.println("stack: "+stack);
        
        while(!stack.isEmpty()) {
        	root = stack.peek();
            System.out.println("root: "+root.val+" s: "+s);
        	
            if(visited.contains(root)) {
            	System.out.println("root: "+root.val+" s: "+s);

            	TreeNode node = stack.pop();
            	System.out.println("pop node: "+node.val);
                s.append(")");
            } 
            else {
            	System.out.println("root: "+root.val+" s: "+s);
            	
                visited.add(root);
                s.append("(" + root.val);
                
                System.out.println("s: "+s);
                
                if(root.left == null && root.right != null) {
                    s.append("()");
                }
                
                if(root.right != null) {
                    stack.push(root.right);
                }
                
                if(root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return s.substring(1, s.length() - 1);
    }
	
	public static void main(String[] args) {
		ConstructStringFromBinaryTree tree = new ConstructStringFromBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(6);
		System.out.println(tree2str(tree.root));
	}

}
