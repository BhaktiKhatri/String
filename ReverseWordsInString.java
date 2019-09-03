package String;

import java.util.Arrays;

/**
 * Leetcode 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * Given an input string, reverse the string word by word.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * Code from: https://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/
 * Micorosft, Bloomberg, Apple, Snapchat, Yelp
 * Medium
 */

public class ReverseWordsInString {

	public static String reverseWordsUsingStringBuilder(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	
	//This method does not remove leading and trailing spaces. Eg if input is " the sky is blue " then output will be " blue is sky the ". But reverse string should not have
	//leading and trailing spaces
	public static String reverseWords(String s) {
        if(s == null || s.isEmpty())
            return "";
        
        if(s.split(" ").length == 0)
        	return "";
     
        System.out.println("s: "+s);
        
        // Three step to reverse
        char[] ch = s.toCharArray();				// 1, reverse the whole sentence
        System.out.println("ch: "+Arrays.toString(ch));
        
	    reverse(ch, 0, ch.length - 1);
	    System.out.println("ch: "+Arrays.toString(ch));
	    
	    int start = 0;
	    
	    for (int i=0; i<ch.length; i++) {			// 2, reverse each word
	    	System.out.println("i: "+i+" ch[i]: "+ch[i]+" start: "+start);
	        
	    	if (ch[i] == ' ') {
	            reverse(ch, start, i - 1);
	            start = i + 1;
	        }
	    }
	    
	    System.out.println("ch: "+Arrays.toString(ch)+" start: "+start);
	    
    	reverse(ch, start, ch.length - 1);			// 3, reverse the last word, if there is only one word this will solve the corner case
	    return new String(ch);
    }
    
    public static void reverse(char[] s, int start, int end) {
    	System.out.println("s: "+Arrays.toString(s)+" start: "+start+" end: "+end);
    	
        while(start < end) {
        	System.out.println("start: "+start+" end: "+end+" s[start]: "+s[start]+" s[end]: "+s[end]);
        	
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
    //Refer this
    public static String reverseWordsFinal(String s) {
        if (s == null) 
        	return null;
        
        System.out.println("s: "+s);
        
        char[] a = s.toCharArray();
        int len = a.length;
        
        System.out.println("a: "+Arrays.toString(a)+" len: "+len);
        
        // step 1. reverse the whole string
        reverseFinal(a, 0, len - 1);
        System.out.println("a: "+Arrays.toString(a));
        
        // step 2. reverse each word
        reverseEachWord(a, len);
        System.out.println("a: "+Arrays.toString(a));
        
        // step 3. clean up spaces
        String str = cleanSpaces(a, len);
        System.out.println("str: "+str);
        
        return str;
      }
      
      public static void reverseEachWord(char[] a, int len) {
        int i = 0, j = 0;
        System.out.println("a: "+Arrays.toString(a)+" len: "+len+" i: "+i+" j: "+j);  
        
        while (i < len) {
          System.out.println("i: "+i+" j: "+j+" a[i]: "+a[i]+" a[j]: "+a[j]+" a: "+Arrays.toString(a));
        	
          while (i < j || (i < len && a[i] == ' ')) {
        	  System.out.println("i: "+i+" j: "+j+" a[i]: "+a[i]+" a[j]: "+a[j]+" a: "+Arrays.toString(a));
        	  i++; // skip spaces
          }
          System.out.println(" a: "+Arrays.toString(a));
          
          while (j < i || (j < len && a[j] != ' ')) { 
        	  if(i < len && j < len)
        		  System.out.println("i: "+i+" j: "+j+" a[i]: "+a[i]+" a[j]: "+a[j]+" a: "+Arrays.toString(a));
        	  j++; // skip non spaces
          }
          
          reverseFinal(a, i, j - 1);                      // reverse the word
        }
      }
      
      // trim leading, trailing and multiple spaces
      public static String cleanSpaces(char[] ca, int len) {
    	  int index = 0;
    	  System.out.println("ca: "+Arrays.toString(ca)+" len: "+len);
    	  
    	  for(int i=0; i<len;i++) {
    		  System.out.println("ca: "+Arrays.toString(ca));
    		  if(i > 0)
    			  System.out.println("i: "+i+" ca[i]: "+ca[i]+" ca[i-1]: "+ca[i-1]+" index: "+index);
    		  
    	        if(i > 0 && ca[i] == ' ' && ca[i-1] == ' ') { 
    	        	continue;
    	        }
    	        
    	        System.out.println("index: "+index+" ca[index]: "+ca[index]+" i: "+i+" ca[i]: "+ca[i]);
    	        if(index != i) {
    	        	ca[index] = ca[i];
    	        }
    	        index++;
    	  }
    	  System.out.println("ca: "+Arrays.toString(ca)+" index: "+index+" String(ca).substring(0, index): "+new String(ca).substring(0, index)+" trim(): "+new String(ca).substring(0, index).trim());
    	  return new String(ca).substring(0, index).trim();
      }
      
      // reverse a[] from a[i] to a[j]
      private static void reverseFinal(char[] a, int i, int j) {
    	System.out.println("a: "+Arrays.toString(a)+" i: "+i+" j: "+j);
    	
        while (i < j) {
          System.out.println("i: "+i+" a[i]: "+a[i]+" a[j]: "+a[j]);
        	
          char temp = a[i];
          a[i] = a[j];
          a[j] = temp;
          
          i++;
          j--;
        }
      }
	
	public static void main(String[] args) {
		//String s = " Let's take LeetCode contest ";
		String s = " the sky   is blue ";
		System.out.println(":"+reverseWordsFinal(s)+":");
		//System.out.println(":"+reverseWordsUsingStringBuilder(s)+":");
	}

}
