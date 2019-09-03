package String;

/**
 * Leetcode 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Input: "babad", Output: "bab"; Note: "aba" is also a valid answer.
 * Explanation and Code from: https://www.youtube.com/watch?v=nbTSfrEfo6M http://www.ideserve.co.in/learn/longest-palindromic-substring-manachers-algorithm
 * https://articles.leetcode.com/longest-palindromic-substring-part-ii/
 * Time Complexity is O(n), Space Complexity is O(n)
 * String
 * Micorsoft, Amazon, Bloomberg
 */

public class LongestPalindromicSubstring {
	
	//Manacher's Algo
    public static String longestPalindrome(String s) {
    	char[] T = new char[s.length()*2 + 3];	//add # in place of empty spaces to consider the case of even length palindrome
        T[0] = '$';								//to mark start of the string
        T[s.length()*2 + 2] = '@';				//to mark end of the string
        
        for(int i=0; i<s.length(); i++) {
            T[2*i + 1] = '#';
            T[2*i + 2] = s.charAt(i);
        }
         
        T[s.length()*2 + 1] = '#';
         
        int[]  P = new int[T.length];
        int center = 0;	//center of the main palindrome
        int right = 0;  //right boundary of the main palindrome
         
        for (int i=1; i<T.length-1; i++) {
            int mirror = 2*center - i;				//mirror location for i
 
          if (i < right) {							//if i lies within the boundary of R(right), then copy the mirror length(P[mirror]) into P[i]
              P[i] = Math.min(right - i, P[mirror]);
          }
             
          while (T[i + (1 + P[i])] == T[i - (1 + P[i])]) {	//compare the left and right elements of i, if they are equal than expand the palindrome ie P[i]++
              P[i]++;
          }
          
          if (i + P[i] > right) {	//check if the palindrome centered at i expands beyond the boundary of R
              center = i;			// if it does then put the center to i
              right = i + P[i];		//then make R as the boundary of i
          }
      }
       
     //Find the maximum element in P
      int maxLen = 0;   // length of longest palindromic substring
      center = 0;   // center of longest palindromic substring
      for (int i=1; i<P.length-1; i++) {
          if (P[i] > maxLen) {		
        	  maxLen = P[i];
              center = i;
          }
      }
      System.out.println("maxLen: "+maxLen);
      //System.out.println(s.substring((center - 1 - length) / 2, (center - 1 + length) / 2));
      return s.substring((center - 1 - maxLen) / 2, maxLen);
    }
    
    //Refer this: @cdai https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution
    //https://medium.com/@bhprtk/longest-palindromic-substring-a8190fab03ff
    //https://www.youtube.com/watch?v=nbTSfrEfo6M&t=810s
    /*
     * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n−1 
     * such centers. You might be asking why there are 2n−1 but not nn centers? The reason is the center of a palindrome can be in between
     * two letters. Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
     */
    public static String longestPalindrome1(String s) {
    	System.out.println("s: "+s);
        String max = "";
        String s2 = "";
        
        for(int i=0; i<s.length(); i++) {
        	System.out.println("i: "+i);
            
        	String s1 = extend(s, i, i);	//for odd length string; example: ABABABA; //assume odd length, try to extend Palindrome as possible
        	System.out.println("s1: "+s1);
        	
        	if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
        		s2 = extend(s, i, i + 1); 	//empty for odd length string //assume even length
        	}
            System.out.println("s1: "+s1+" s2: "+s2+" max: "+max);
            
            if(s1.length() > max.length()) { 
            	max = s1;
            }
            
            if(s2.length() > max.length()) { 
            	max = s2;
            }
        }
        return max;
    }
    
    private static String extend(String s, int i, int j) {
    	System.out.println("s: "+s+" i: "+i+" j: "+j+" s.charAt(i): "+s.charAt(i)+" s.charAt(j): "+s.charAt(j));
    	
    	while(i >= 0 && j <= s.length()-1 && s.charAt(i) == s.charAt(j)) {
    		System.out.println("i: "+i+" j: "+j);
    		i--;
    		j++;
    	}

    	System.out.println("s: "+s+" i: "+i+" j: "+j+" s.substring(i + 1, j): "+s.substring(i + 1, j));
        return s.substring(i + 1, j);
    }
	/*
	 * for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
	 */
    
    
	public static void main(String[] args) {
		String s = "ABABABA"; //"ABBBBA";
		System.out.println(s);
		System.out.println(longestPalindrome1(s));
	}
}