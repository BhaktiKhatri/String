package String;

/**
 * Leetcode 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/description/
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * Explanation and Code from: https://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/
 * Time Complexity: O(1)
 * Medium
 * Twitter
 */

public class IntegerToRoman {

	//% gives leftmost digit and / gives rightmost digit
	public static String intToRoman(int num) {
	    String M[] = {"", "M", "MM", "MMM"};										//1000-3000			// storing roman values of digits from 0-9 when placed at different places
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};  //100-900
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};	//10-90
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};	//1-9
	    
	    String thousands = M[num/1000];				//3549/1000 = 3	=> M[3] = MMM
	    String hundereds = C[(num%1000)/100];		//(3549 % 1000) = 549/100 = 5 => C[5] = D
	    String tens =  X[(num%100)/10];				//(3549 % 100) = 49/10 = 4 => X[4] = XL
	    String ones = I[num%10];					//(3549 % 10) = 9 => I[9] = IX
	    
	    String ans = thousands + hundereds + tens + ones;	//MMMDXLIX
	    return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(intToRoman(3549));
	}

}