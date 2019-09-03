package String;

/**
 * Leetcode 67. Add Binary
 * https://leetcode.com/problems/add-binary/description/
 * Given two binary strings, return their sum (also a binary string).
 * a = "11", b = "1", Return "100".
 * Explanation: https://www.geeksforgeeks.org/program-to-add-two-binary-strings/ Code: https://leetcode.com/problems/add-binary/discuss/24488?page=3
 * @author NisuBhakti
 * Time Complexity: O(m+n) where m is the length of the binary string a and n is the length of the binary string b.
 * Easy
 * Facebook
 * https://www.tutorialspoint.com/computer_logical_organization/binary_arithmetic.htm
 * https://github.com/yokostan/Leetcode-Solutions/issues/14
 */

public class AddBinary {
	
	/*
	 	The algorithmic solution should be basically retrieve the last char from both the strings, get the integer value, add it to the sum, 
	 	check if there's a carry, append the rest of the value to resultant string.
	 */
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() -1;
        int carry = 0;
        
        System.out.println("a: "+a+" b: "+b+" i: "+i+" j: "+j);
        
        while (i >= 0 || j >= 0) {
        	System.out.println("carry: "+carry+" i: "+i+" j: "+j);
            
        	int sum = carry;
        	System.out.println("sum: "+sum);
            
            if (j >= 0) {							// Compute sum of last digits and carry
            	sum = sum + b.charAt(j) - '0';	// char - '0' => char converted to int
            	j--;
            }
            System.out.println("sum: "+sum);
            
            if (i >= 0) { 
            	sum = sum + a.charAt(i) - '0';
            	i--;
            }
            System.out.println("sum: "+sum);
            
            sb.append(sum % 2);						// If current digit sum is 1 or 3, add 1 to result
            System.out.println("sb: "+sb);
            
            carry = sum / 2;						//Compute carry
            System.out.println("carry: "+carry);
        }
        System.out.println("sb: "+sb+" carry: "+carry);
        
        if (carry != 0) 
        	sb.append(carry);
        
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println("a: "+a+" b: "+b);
		System.out.println(addBinary(a, b));
	}

}
