package String;

/**
 * Leetcode 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * Implement atoi to convert a string to an integer.
 * Explanation: https://leetcode.com/problems/string-to-integer-atoi/discuss/4654/My-simple-solution?page=1
 * http://www.jyuan92.com/blog/leetcode-string-to-integer-atoi/
 * Code: https://leetcode.com/problems/string-to-integer-atoi/discuss/4654
 * Medium
 * Microsoft, Amazon, Uber, Bloomberg, Apple
 */

public class StringToInteger {

	/*
	 * I think we only need to handle four cases:
	 * discards all leading whitespace
	 * sign of the number
	 * overflow
	 * invalid input
	 * 
	 * As int data type is 32 bit in Java, any value that surpasses 32 bits gets rolled over.
	 * In numerical terms, it means that after incrementing 1 on 
	 * Integer.MAX_VALUE (2147483647), the returned value will be -2147483648 
	 */
	public static int myAtoi(String str) {
	    if(str.isEmpty()) {				//if string is empty then return 0
	    	return 0;
	    }
	    
	    System.out.println("str:"+str+":");
	    int sign = 1, base = 0, i = 0;
	    
	    while(str.charAt(i) == ' ') {	    // if whitespace then ignore and go to next character
	        i++;
	    }
	    System.out.println("i: "+i+" str.charAt(i): "+str.charAt(i));
	    
	    if(str.charAt(i) == '-' || str.charAt(i) == '+') {
	        sign = str.charAt(i) == '-' ? -1 : 1;
	        i++;
	    }
	    
	    System.out.println("i: "+i+" sign: "+sign);
	    
	    //INT_MIN: -2,147,483,648;  INT_MAX: +2,147,483,647
	    //Integer.MAX_VALUE + 1 == Integer.MIN_VALUE and Integer.MIN_VALUE - 1 == Integer.MAX_VALUE
	    while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	    	
	    	System.out.println("i: "+i+" str.charAt(i): "+str.charAt(i)+" base: "+base+" (Integer.MAX_VALUE / 10): "+(Integer.MAX_VALUE / 10)+" str.charAt(i) - '0': "+(str.charAt(i) - '0'));
	    	
	    	//Because INT_MAX has been divided by 10, so the tail vanishes. if the tail is 8 or 9, it will overflow
	        if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
	            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        }
	        System.out.println("i: "+i+" str.charAt(i): "+str.charAt(i)+" base: "+base);
	        
	        base = 10 * base + (str.charAt(i) - '0');	//str.charAt(i) - '0' converts character to integer
	        i++;
	    }
	    System.out.println("base: "+base+" sign: "+sign);
	    return base * sign;
	}
	
	public static void main(String[] args) {
		System.out.println(myAtoi("4193 with words"));
	}
}