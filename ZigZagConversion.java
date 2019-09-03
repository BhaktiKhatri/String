package String;

import java.util.Arrays;

/**
 * Leetcode 6. ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * Explanation and Code from https://leetcode.com/problems/zigzag-conversion/discuss/3403
 * Time Complexity: O(len) where len is length of input string; Auxiliary Space: O(len)
 * Medium
 */

public class ZigZagConversion {

	public static String convert(String s, int nRows) {
	    char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuilder[] sb = new StringBuilder[nRows];
	    
	    System.out.println("s: "+s+" nRows: "+nRows+" sb: "+sb);
	    
	    for(int i=0; i<sb.length; i++) {
	    	sb[i] = new StringBuilder();
	    }
	    
	    System.out.println("sb: "+Arrays.toString(sb));
	    
	    int i=0;
	    while(i < len) {
	    	System.out.println("i: "+i+" len: "+len);
	        
	    	for(int idx=0; idx<nRows && i<len; idx++) { 								// vertically down
	    		System.out.println("idx: "+idx+" sb[idx]: "+sb[idx]+" c[i]: "+c[i]);
	            sb[idx].append(c[i]);
	            i++;
	        }
	        
	        for(int idx=nRows-2; idx>=1 && i<len; idx--) {								// obliquely up
	        	System.out.println("idx: "+idx+" sb[idx]: "+sb[idx]+" c[i]: "+c[i]);
	            sb[idx].append(c[i]);
	            i++;
	        }
	    }
	    
	    System.out.println("sb: "+Arrays.toString(sb));
	    
	    for(int idx=1; idx<sb.length; idx++) {
	    	System.out.println("idx: "+idx+" sb[idx]: "+sb[idx]+" sb[0]: "+sb[0]);
	        sb[0].append(sb[idx]);
	    }
	    
	    System.out.println("sb: "+Arrays.toString(sb));
	    
	    return sb[0].toString();
	}
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(s);
		System.out.println(convert(s, 3));
	}
}