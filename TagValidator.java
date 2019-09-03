package String;

import java.util.Stack;

/*
 * 591. Tag Validator
 * https://leetcode.com/problems/tag-validator/description/
 * Explanation and Code from: Approach #1 Using Stack https://leetcode.com/problems/tag-validator/solution/
 * Time complexity: O(n), We traverse over the given code string of length n
 * Space complexity: O(n), The stack can grow upto a size of n/3 in the worst case. e.g. In case of <A><B><C><D>, n=12 and number of tags = 12/3 = 4.
 * Microsoft
 * >Medium
 */

public class TagValidator {

	public static Stack<String> stack = new Stack<>();
    public static boolean contains_tag = false;
    
    public static boolean isValidTagName(String s, boolean ending) {
    	System.out.println("s: "+s+" s.length(): "+s.length()+" ending: "+ending);
    	
    	if(s.length() < 1 || s.length() > 9) {
            return false;
    	}
        
        for(int i=0; i<s.length(); i++) {
            System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i));
        	if(!Character.isUpperCase(s.charAt(i))) {
                return false;
            }
        }
        
        if(ending) {
            if(!stack.isEmpty() && stack.peek().equals(s)) {
            	System.out.println("stack: "+stack);
            	stack.pop();
            }
            else {
                return false;
            }
        }
        else {
            contains_tag = true;
            stack.push(s);
        }
        return true;
    }
    
    public static boolean isValidCdata(String s) {
    	System.out.println("s: "+s);
    	return s.indexOf("[CDATA[") == 0;
    }
    
    public static boolean isValid(String code) {
    	System.out.println("code: "+code);
        
    	if(code.charAt(0) != '<' || code.charAt(code.length() - 1) != '>') {
            return false;
        }
        
        for(int i=0; i<code.length(); i++) {
            boolean ending = false;
            int closeindex;
            
            System.out.println("stack: "+stack+" i: "+i+" code.charAt(i): "+code.charAt(i));
            
            if(stack.isEmpty() && contains_tag) {
                return false;
            }
            
            if(code.charAt(i) == '<') {
                if(!stack.isEmpty() && code.charAt(i + 1) == '!') {
                    closeindex = code.indexOf("]]>", i + 1);
                    
                    if(closeindex < 0 || !isValidCdata(code.substring(i + 2, closeindex))) {
                        return false;
                    }
                } 
                else {
                    if (code.charAt(i + 1) == '/') {
                        i++;
                        ending = true;
                    }
                    closeindex = code.indexOf('>', i + 1);
                    if(closeindex < 0 || !isValidTagName(code.substring(i + 1, closeindex), ending)) {
                        return false;
                    }
                }
                i = closeindex;
            }
        }
        return stack.isEmpty() && contains_tag;
    }
	
	public static void main(String[] args) {
		String s = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
		System.out.println(isValid(s));
	}

}
