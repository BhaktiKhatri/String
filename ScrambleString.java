package String;

/**
 * Leetcode 87. Scramble String
 * https://leetcode.com/problems/scramble-string/description/
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively. Below is one possible representation of s1 = "great":
 * To scramble the string, we may choose any non-leaf node and swap its two children. For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * We say that "rgeat" is a scrambled string of "great". Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * We say that "rgtae" is a scrambled string of "great". Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * Explanation and Code from: @kennethliaoke https://leetcode.com/problems/scramble-string/discuss/29392  https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/ganganloveu/p/4148000.html&prev=search
 * @author NisuBhakti
 *
 */

public class ScrambleString {

	/*
	 	we know, we can divide the given first string into two parts i.e if the first string and second string given in input are already same then no need to divide it else we the first string was divided from atleast a place … hence division index itself ranges from 1 to len-1 (both inclusive) and on each division… we have to chances.
		Chance 1:-
		Left part of s1 could me made equal to left part of s2 and similarly right part of s1 could be made equal to right part of s2 i.e. we have to call function like this:-
		if(isScramble(s1.substr(0,i),s2.substr(0,i)) && isScramble(s1.substr(i),s2.substr(i))) return true.
		
		Chance 2:-
		if Chance 1 dont proves to be correct… then the second case be… left part of one is present in right part of other and vice versa i.e.
		if(isScramble(s1.substr(0,i),s2.substr(len-i)) && isScramble(s1.substr(i),s2.substr(0,len-i))) return true.
		
		return false… if neither chance 1 nor chance 2 helps.
	 */
	
	public static boolean isScramble(String s1, String s2) {
	    int len1 = s1.length(), len2 = s2.length();
	    System.out.println("s1: "+s1+" s2: "+s2+" len1: "+len1+" len2: "+len2);
	    
	    if (len1 != len2)
	    	return false;
	    if (len1 == 0) 
	    	return true;
	    // pruning 
	    if (s1.equals(s2))
	    	return true;
	    int[] count = new int[256];
	    
	    for (int i = 0; i < len1; i++) {
	        count[s1.charAt(i)]++;
	        count[s2.charAt(i)]--;
	    }
	    
	    for (int i = 0; i < len1; i++) {
	        if (count[s1.charAt(i)] != 0) 
	        	return false;
	    }
	    
	    for (int i = 1; i < len1; i++) {
	    	
	    	String s11 = s1.substring(0, i);							
	        String s12 = s1.substring(i);								
	        String s21 = s2.substring(0, i);							
	        String s22 = s2.substring(i);								
	        String s23 = s2.substring(0, len1-i);						
	        String s24 = s2.substring(len1 - i);
	        
	        System.out.println("i: "+i+" s11: "+s11+" s21: "+s21+" s12: "+s12+" s22: "+s22+" s24: "+s24+" s23: "+s23);
	        
	        if (isScramble(s11, s21) && isScramble(s12, s22))	//s11-g s21-r, s12-reat s22-geat	
	            return true;
	        if (isScramble(s11, s24) && isScramble(s12, s23))	//s11-g s24-t, s12-reat s22-rgea
	            return true;
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgeat";
		System.out.println(isScramble(s1, s2));
	}

}
