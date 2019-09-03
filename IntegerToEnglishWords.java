package String;

/**
 * Leetcode 273. Integer to English Words
 * https://leetcode.com/problems/integer-to-english-words/description/
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Time Complexity - O(n)， Space Complexity - O(n)
 * > Medium
 * Facebook, Microsoft
 */

public class IntegerToEnglishWords {

	private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

	public static String numberToWords(int num) {
	    if (num == 0) 
	    	return "Zero";
	    System.out.println("num: "+num);
	    
	    int i = 0;
	    String words = "";
	    
	    while(num > 0) {
	    	System.out.println("num: "+num+" i: "+i+" num % 1000: "+(num % 1000)+" num / 1000: "+(num / 1000));
	        if(num % 1000 != 0) {
	    	    words = helper(num % 1000) +THOUSANDS[i] + " " + words;
	        }
	        System.out.println("num: "+num+" num / 1000: "+(num / 1000));
	    	num = num / 1000;
	    	i++;
	    }
	    return words.trim();
	}

	public static String helper(int num) {
	    System.out.println("num: "+num);
		
		if(num == 0) {
	        return "";
	    }
	    else if (num < 20) {
	        return LESS_THAN_20[num] + " ";
	    }
	    else if (num < 100) {
	    	System.out.println("num / 10: "+(num / 10)+" num % 10: "+(num % 10));
	        return TENS[num / 10] + " " + helper(num % 10);
	    }
	    else {
	    	System.out.println("num / 100: "+(num / 100)+" num % 100: "+(num % 100));
	        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(numberToWords(1000));
	}
}
