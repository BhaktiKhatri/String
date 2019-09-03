package String;

import java.util.Stack;

/*
 * 772. Basic Calculator III
 * https://leetcode.com/problems/basic-calculator-iii/description/
 * Explanation and Code from: https://leetcode.com/problems/basic-calculator-iii/discuss/113600/Java-O(n)-Solution-Using-Two-Stacks
 * https://www.geeksforgeeks.org/expression-evaluation/
 * It should be clear that this algorithm runs in linear time – each number or operator is pushed onto and popped from Stack only once
 */

public class BasicCalculator3 {

	/*
	 	We will use l1 and o1 to denote respectively the partial result and the operator in effect for level one; l2 and o2 for level two. 
	 	The operators have the following mapping:
		o1 == 1 means +; o1 == -1 means - ;
		o2 == 1 means *; o2 == -1 means /.
		By default we have l1 = 0, o1 = 1, and l2 = 1, o2 = 1.
	*/
	public static int calculate(String s) {
		if(s == null || s.length() == 0) 
			return 0;
        Stack<Integer> nums = new Stack<>(); // the stack that stores numbers
        Stack<Character> ops = new Stack<>(); // the stack that stores operators (including parentheses)
        int num = 0;
        
        System.out.println("s: "+s);
        //2*(5+5*2)/3+(6/2+8)
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("i: "+i+" c: "+c);
            
            if(c == ' ') { 
            	continue;
            }
            
            if(Character.isDigit(c)) {
                num = c - '0';
                System.out.println("num: "+num);
                
                // iteratively calculate each number
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                System.out.println("num: "+num);
                
                nums.push(num);
                System.out.println("nums: "+nums);
                
                num = 0; // reset the number to 0 before next calculation
            } 
            else if(c == '(') {
                ops.push(c);
                System.out.println("ops: "+ops);
            }
            else if(c == ')') {
            	System.out.println("ops: "+ops);
            	
            	// do the math when we encounter a ')' until '('
                while(ops.peek() != '(') { 
                	nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop(); // get rid of '(' in the ops stack
            
            } 
            else if(c == '+' || c == '-' || c == '*' || c == '/') {
            	System.out.println("c: "+c+" ops: "+ops+" nums: "+nums);
            	
                while(!ops.isEmpty() && precedence(c, ops.peek())) { 
                	nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                }
                ops.push(c);
                System.out.println("ops: "+ops+" nums: "+nums);
            }
        }
        System.out.println("ops: "+ops+" nums: "+nums);
        
        while(!ops.isEmpty()) {
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
	}
	
	private static int operation(char op, int b, int a) {
        System.out.println("op: "+op+" b: "+b+" a: "+a);
		
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; // assume b is not 0
        }
        return 0;
    }
	
	//// Returns true if 'op2' has higher or same precedence as 'op1', otherwise returns false.
    // helper function to check precedence of current operator and the uppermost operator in the ops stack 
    private static boolean precedence(char op1, char op2) {
        System.out.println("op1: "+op1+" op2: "+op2);
    	
    	if(op2 == '(' || op2 == ')') {
        	return false;
    	}
        
    	if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) { 	//+,/; /,*
    		return false;
    	}
    	
        return true;
    }

	
	public static void main(String[] args) {
		String s = "2*(5+5*2)/3+(6/2+8)";
		System.out.println(calculate(s));
	}
}