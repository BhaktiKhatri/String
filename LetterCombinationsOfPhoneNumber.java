package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 17. Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * Explanation and Code from: @lirensun https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
 * Medium
 * Google, Facebook, Amazon, Uber, Dropbox
 * For time complexity, adding one more letter, 4 (for number 7) times more operations, so it is O(4^n). For space complexity, final output will take O(4^n) space.
 */

public class LetterCombinationsOfPhoneNumber {

	public static List<String> letterCombinations(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    if(digits.length() == 0 || digits == null) {
	    	return ans;
	    }
	    
	    System.out.println("digits: "+digits);
	    
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    
	    for(int i=0; i<digits.length();i++) {
	    	System.out.println("i: "+i+" digits.charAt(i): "+digits.charAt(i));
	        
	    	int x = Character.getNumericValue(digits.charAt(i));
	        System.out.println("x: "+x+" ans: "+ans+" ans.peek(): "+ans.peek());
	        
	        while(ans.peek().length() == i) {
	            String t = ans.remove();
	            System.out.println("t: "+t+" mapping[x]: "+mapping[x]);
	            
	            for(char s: mapping[x].toCharArray()) {
	            	System.out.println("s: "+s);
	                ans.add(t+s);
	                System.out.println("ans: "+ans);
	            }
	        }
	    }
	    
//	    while(ans.peek().length()!=digits.length()) {
//			System.out.println("ans: "+ans+" ans.peek(): "+ans.peek());
//			String remove = ans.remove();
//			
//			System.out.println("remove: "+remove+" remove.length(): "+remove.length()+" (digits.charAt(remove.length())-'0'): "+(digits.charAt(remove.length())-'0'));
//			String map = mapping[digits.charAt(remove.length())-'0'];
//			System.out.println("map: "+map);
//				
//			for(char c: map.toCharArray()){
//				System.out.println("c: "+c);
//				ans.addLast(remove + c);
//				System.out.println("ans: "+ans);
//			}
//		}
	    
	    System.out.println("ans: "+ans);
	    return ans;
	}
	
	//Refer this: https://www.geeksforgeeks.org/iterative-letter-combinations-of-a-phone-number/
	public static List<String> letterCombinations1(String digits) {
            ArrayList<String> list = new ArrayList<>();			// To store the generated letter combinations  
            if(digits.length() == 0 || digits == null) {
                return list;
            }
            
            String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            Queue<String> q = new LinkedList<>(); 
            q.add(""); 
          
            while(!q.isEmpty())  
            { 
                 String s = q.remove(); 
                 System.out.println("s: "+s+" q: "+q+" list: "+list);
                 
                 if(s.length() == digits.length()) {	// If complete word is generated push it in the list 
                     list.add(s); 
                 }
                 else 
                 { 
                	int num = digits.charAt(s.length()) - '0';
                    String val = mapping[num];
                    
                    for(int i=0; i<val.length(); i++) 
                    { 
                        q.add(s + val.charAt(i)); 
                    } 
                 }  
            } 
            return list; 
    }
	
	
	public static void main(String[] args) {
		String digits = "23";
		System.out.println(digits);
		System.out.println(letterCombinations1(digits));
	}

}
