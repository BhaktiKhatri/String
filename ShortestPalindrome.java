package String;

/**
 * Leetcode 214. Shortest Palindrome
 * https://leetcode.com/problems/shortest-palindrome/description/
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * For example: Given "aacecaaa", return "aaacecaaa"; Given "abcd", return "dcbabcd"
 * Explanation and Code from: https://leetcode.com/problems/shortest-palindrome/discuss/60113 @cdai
 * @author NisuBhakti
 * Time complexity: O(n), In every iteration of the inner while loop, t decreases until it reaches 0 or until it matches. 
 * After that, it is incremented by one. Therefore, in the worst case, t can only be decreased up to n times and increased up to n times.
 * Hence, the algorithm is linear with maximum (2∗n)∗2 iterations.
 * Space complexity: O(n), Additional space for the reverse string and the concatenated string.
 * Google, Pocket Gems
 */

public class ShortestPalindrome {
	
	/*
	 	Explain KMP Algorithm: https://www.youtube.com/watch?v=cH-5KcgUcOE https://www.youtube.com/watch?v=t4xUA-aHzy8
	 	Shortest Palindrome Explanation: https://www.youtube.com/watch?v=c4akpqTwE5g
	 	KMP Code and Example from: https://leetcode.com/problems/shortest-palindrome/solution/
	 */
	//Refer: https://www.youtube.com/watch?v=GTJr8OvyEVQ
	//https://www.youtube.com/watch?v=KG44VoDtsAA
	public static String shortestPalindrome(String s) {
        String p = s +"#"+ new StringBuilder(s).reverse().toString();
        int func[] = lookupTable(p.toCharArray());
        String max = s.substring(func[func.length - 1]);
        return new StringBuilder(max).reverse().append(s).toString();
    }
    
    public static int[] lookupTable(char[] p) {
        int[] func = new int[p.length];
        func[0] = 0;
        
        for(int i=1, j=0; i<p.length; i++) {
            j = func[i-1];
            while(j > 0 && p[i] != p[j])
                j = func[j-1];
            if(p[i] == p[j])
                j++;
            func[i] = j; 
        }
        return func;
    }
	
	public static void main(String[] args) {
		String s = "accabb";
		System.out.println(s);
		System.out.println(shortestPalindrome(s));
	}

}
