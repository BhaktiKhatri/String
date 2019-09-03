package String;

import java.util.Stack;

/**
 * Leetcode 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/description/
 * Implement a basic calculator to evaluate a simple expression string. The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples: "3+2*2" = 7, " 3/2 " = 1, " 3+5 / 2 " = 5. Note: Do not use the eval built-in library function
 * Explanation and Code from: @abner https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution 
 * @xietao221 https://leetcode.com/problems/basic-calculator-ii/discuss/63003
 * Time Complexity: O(N)
 * Medium
 * Airbnb
 */

public class BasicCalculator2 {

	public static int calculate(String s) {
	    int len = s.length();
	    if(s == null || len == 0) 
	    	return 0;
	    
	    System.out.println("s: "+s+" len: "+len);
	    
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    
	    for(int i=0; i<len; i++) {
	    	System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" num: "+num+" sign: "+sign);
	    	
	    	if(Character.isDigit(s.charAt(i))) {
	            num = num * 10 + s.charAt(i) - '0';
	        }
	    	
	    	if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ')  || i == len-1) {
	            if(sign == '-') {
	                stack.push(-num);
	            }
	            else if(sign == '+') {
	                stack.push(num);
	            }
	            else if(sign == '*') {
	                stack.push(stack.pop() * num);
	            }
	            else if(sign == '/') {
	                stack.push(stack.pop() / num);
	            }
	            System.out.println("stack: "+stack+" sign: "+sign+" s.charAt(i): "+s.charAt(i));
	            
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }
	    System.out.println("stack: "+stack+" sign: "+sign);
	    
	    int result = 0;
	    for(int i: stack) {
	    	System.out.println("i: "+i+" result: "+result);
	    	result = result + i;
	    }
	    System.out.println("result: "+result);

	    return result;
	}
	
	public static void main(String[] args) {
		String s = "3+2*2"; //"3+5/2"; //"3/2"; //"3-2*2";
		System.out.println(calculate(s));
	}
}