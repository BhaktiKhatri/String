package String;

/**
 * Leetcode 678. Valid Parenthesis String
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1: Input: "()", Output: True
 * Example 2: Input: "(*)", Output: True
 * Example 3: Input: "(*))", Output: True
 * Note: The string size will be in the range [1, 100]
 * Explanation and Code from: Approach #3 Greedy https://leetcode.com/problems/valid-parenthesis-string/solution/
 * Time Complexity: O(N), where N is the length of the string. We iterate through the string once.
 * Space Complexity: O(1), the space used by our lo and hi pointers. However, creating a new character array will take O(N) space.
 * Medium
 * Alibaba
 */

public class ValidParenthesesString {

	/*
	 * Intuition:
	 * When checking whether the string is valid, we only cared about the "balance": the number of extra, open left brackets as we parsed through the string.
	 * For example, when checking whether '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0 as we parse through the string: '(' has 1 left bracket,
	 * '((' has 2, '(()' has 1, and so on. This means that after parsing the first i symbols, (which may include asterisks,) we only need to keep track of 
	 * what the balance could be.
	 * For example, if we have string '(***)', then as we parse each symbol, the set of possible values for the balance is [1] for '('; [0, 1, 2] for 
	 * '(*'; [0, 1, 2, 3] for '(**'; [0, 1, 2, 3, 4] for '(***', and [0, 1, 2, 3] for '(***)'.
	 * Furthermore, we can prove these states always form a contiguous interval. Thus, we only need to know the left and right bounds of this interval. 
	 * That is, we would keep those intermediate states described above as [lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3]
	 * Algorithm:
	 * Let lo, hi respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.
	 * If we encounter a left bracket (c == '('), then lo++, otherwise we could write a right bracket, so lo--. If we encounter what can be a left bracket
	 * (c != ')'), then hi++, otherwise we must write a right bracket, so hi--. If hi < 0, then the current prefix can't be made valid no matter what our 
	 * choices are. Also, we can never have less than 0 open left brackets. At the end, we should check that we can have exactly 0 open left brackets.
	 */
	
	public static boolean checkValidString(String s) {
	       int low = 0, high = 0;
	       System.out.println("s: "+s);
	       
	       for(char c: s.toCharArray()) {
	    	   System.out.println("c: "+c+" low: "+low+" high: "+high);
	    	   
	           low = low + (c == '(' ? 1 : -1);
	           high = high + (c != ')' ? 1 : -1);
	           
	           System.out.println("low: "+low+" high: "+high);
	           
	           if(high < 0)
	        	   break;
	           
	           low = Math.max(low, 0);
	       }
	       return low == 0;
	}
	
		/*
		 There is another simple O(n) solution with O(1) space complexity, not very intuitive like the greedy approach, but it's nice to know about it. 
		 We can rephrase the problem by listing all the valid cases. There are 3 valid cases:

			1- There are more open parenthesis but we have enough '*' so we can balance the parenthesis with ')'
			2- There are more close parenthesis but we have enough '*' so we can balance the parenthesis with '('
			3- There are as many '(' than ')' so all parenthesis are balanced, we can ignore the extra '*'
			
			 Algorithm: You can parse the String twice, once from left to right by replacing all '*' by '(' and once from right to left by replacing all '*' by ')'.
			 For each of the 2 loops, if there's an iteration where you end up with a negative count (SUM['('] - SUM[')'] < 0) then you know the parenthesis were not 
			 balanced. You can return false. After these 2 checks (2 loops), you know the string is balanced because you've satisfied all the 3 valid cases mentioned
			 above.
		 */
	  //Refer this: @softwareshortcut https://leetcode.com/articles/valid-parenthesis-string/
	  public static boolean checkValidString1(String s) {  
		    int leftBalance = 0;
		    
		    System.out.println("s: "+s);
		    
		    for(int i=0; i<s.length(); i++) {
		    	  System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" leftBalance: "+leftBalance);
			      
		    	  if((s.charAt(i) == '(') || (s.charAt(i) == '*')) {
		    		  leftBalance++;        
			      }
			      else {
			    	  leftBalance--;
			      }
		      
		    	  System.out.println("leftBalance: "+leftBalance);
		    	  
			      if (leftBalance < 0) { 
			    	  return false; // We know we have unbalanced parenthesis
			      }
		    }
		    System.out.println("leftBalance: "+leftBalance);
		    
		    // We can already check if parenthesis are valid
		    if(leftBalance == 0) { 
		    	return true;
		    }
		            
		    int rightBalance = 0;
		    for(int i=s.length()-1; i>=0; i--) {
		    	System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" rightBalance: "+rightBalance);
		    	
			      if ((s.charAt(i) == ')') || (s.charAt(i) == '*')) {
			    	  rightBalance++;
			      }
			      else {
			    	  rightBalance--;
			      }
			      
			      System.out.println("rightBalance: "+rightBalance);
			      
			      if(rightBalance < 0) { 
			    	  return false;  // We know we have unbalanced parenthesis
			      }
		    }
		    System.out.println("rightBalance: "+rightBalance);
		    
		    // Here we know we have never been unbalanced parsing from left to right e.g. ')('
		    // We've also already substituted '*' either by '(' or by ')'
		    // So we only have 3 possible scenarios here:
		    // 1. We had the same amount of '(' and ')'
		    // 2. We had more '(' then ')' but enough '*' to substitute
		    // 3. We had more ')' then '(' but enough '*' to substitute
		    return true;
		 }
	
	public static void main(String[] args) {
		String s = "(*()";
		System.out.println(checkValidString1(s));
	}
}