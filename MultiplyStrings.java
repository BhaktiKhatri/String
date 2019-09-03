package String;

import java.util.Arrays;

/**
 * Leetcode 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/description/
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * Note: The length of both num1 and num2 is < 110. Both num1 and num2 contains only digits 0-9. Both num1 and num2 does not contain any leading zero. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Explanation and Code: https://leetcode.com/problems/multiply-strings/discuss/17627/easiest-solution-with-explanation
 * https://leetcode.com/problems/multiply-strings/discuss/17605?page=3 
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/yrbbest/p/4436340.html&prev=search
 * Time Complexity - O (mn), Space Complexity - O (m + n)
 * Medium
 * Facebook, Twitter
 */

public class MultiplyStrings {

	public static String multiply(String num1, String num2) {
	    int m = num1.length();
	    int n = num2.length();
	    int[] pos = new int[m + n];
	   
	    System.out.println("num1: "+num1+" nums2: "+num2);
	    
	    for(int i=m-1; i>=0; i--) {
	        for(int j=n-1; j >= 0; j--) {
	        	System.out.println("i: "+i+" num1.charAt(i): "+num1.charAt(i)+" j: "+j+" num2.charAt(j): "+num2.charAt(j));
	        	
	            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
	            System.out.println("mul: "+mul);
	            
	            //the product of ith and jth number will be stroed in position i+j and i+j+1; https://leetcode.com/problems/multiply-strings/discuss/17627/easiest-solution-with-explanation
	            int p1 = i + j;			//used to store the carry
	            int p2 = i + j + 1;		//used to store the rightmost digit of the sum
	            
	            System.out.println("p1: "+p1+" p2: "+p2+" pos[p1]: "+pos[p1]+" pos[p2]: "+pos[p2]);
	            int sum = mul + pos[p2];		//calculate the sum of the product and the carry
	            System.out.println("sum: "+sum);
	            
	            pos[p1] = pos[p1] + sum / 10;	//[i+j+1] value plus the carry
	            pos[p2] = (sum) % 10;			//carry of previous round of calculation; pos2 refers to the last round of pos[p1] which is the carry value
	            
	            System.out.println("p1: "+p1+" p2: "+p2+" pos[p1]: "+pos[p1]+" pos[p2]: "+pos[p2]);
	            System.out.println("mul: "+mul+"==========================pos: "+Arrays.toString(pos));
	        }
	    }  
	    
	    System.out.println("pos: "+Arrays.toString(pos));
	    
	    StringBuilder sb = new StringBuilder();
	    for(int p: pos) {
	    	System.out.println("p: "+p);
	    	
	    	if(!(sb.length() == 0 && p == 0)) { 	//Ignore all initial zeros
	    		sb.append(p);
	    	}
	    }
	    System.out.println("sb: "+sb);
	    
	    return sb.length() == 0 ? "0" : sb.toString();
	}
	
	public static void main(String[] args) {
		String num1 = "123";
		String num2 = "45";
		
		System.out.println(multiply(num1, num2));
	}
}