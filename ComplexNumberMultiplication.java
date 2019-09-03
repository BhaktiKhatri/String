package String;

import java.util.Arrays;

/**
 * Leetcode 537. Complex Number Multiplication
 * https://leetcode.com/problems/complex-number-multiplication/description/
 * Given two strings representing two complex numbers. You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * Example 1: Input: "1+1i", "1+1i", Output: "0+2i", Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2: Input: "1+-1i", "1+-1i", Output: "0+-2i", Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note: The input strings will not have extra blank. The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 * Explanation and Code from: Approach #1 Simple Solution https://leetcode.com/problems/complex-number-multiplication/solution/
 * Time Complexity: O(1), Here splitting takes constant time as length of the string is very small (<20) 
 * Space Complexity: O(1), Constant extra space is used
 * Medium
 * Amazon
 */

public class ComplexNumberMultiplication {

	/*
	 	Multiplication of two complex numbers can be done as: (a+ib) * (x+iy) = ax + i^2 by + i(bx+ay) = ax-by+i(bx+ay) 
	 	We simply split up the real and the imaginary parts of the given complex strings based on the '+' and the 'i' symbols. 
	 	We store the real parts of the two strings a and b as x[0] and y[0] respectively and the imaginary parts as x[1] and y[1] respectively.
	 	Then, we multiply the real and the imaginary parts as required after converting the extracted parts into integers. 
	 	Then, we again form the return string in the required format and return the result.
	 */
	public static String complexNumberMultiply(String a, String b) {
        System.out.println("a: "+a+" b: "+b);
		
		String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        
        System.out.println("x: "+Arrays.toString(x)+" y: "+Arrays.toString(y));
        
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        
        System.out.println("a_real: "+a_real+" b_real: "+b_real+" a_img: "+a_img+" b_img: "+b_img);
        
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";
    }
	
	public static void main(String[] args) {
		String a = "1+1i";
		String b = "1+1i";
		System.out.println(complexNumberMultiply(a, b));
	}

}
