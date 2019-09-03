package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1: Given s = "hello", return "holle"
 * Example 2: Given s = "leetcodi", return "liotcede"
 * Note: The vowels does not include the letter "y"
 * Explanation and Code from: https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.jianshu.com/p/670c0d205c4f&prev=search
 * @author NisuBhakti
 * Time Complexity: O(1)
 * Easy
 * Google
 */

public class ReverseVowelsOfAString {

	public static String reverseVowels(String s) {
		Character[] ch = new Character[]{'a','e','i','o','u','A','E','I','O','U'};
		Set<Character> vowels = new HashSet<>(Arrays.asList(ch));
		System.out.println(vowels);
		char[] list = s.toCharArray();
		
		System.out.println("list: "+Arrays.toString(list));
		
		for (int i=0, j=list.length-1; i<j;) {
			System.out.println("i: "+i+" list[i]: "+list[i]+" j: "+j+" list[j]: "+list[j]);
			
			if (!vowels.contains(list[i])) {
				i++; 
				continue; 
			} 
			
			if (!vowels.contains(list[j])) { 
				j--; 
				continue; 
			}
			
			char temp=list[i]; 
			list[i]=list[j]; 
			list[j]=temp;
			i++;
			j--; 
		} 
		return String.valueOf(list); 
	} 
	
	public static void main(String[] args) {
		String s = "leetcodi";
		System.out.println(reverseVowels(s));
	}

}
