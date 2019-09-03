package String;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * Example 1: Input: S = "aab"; Output: "aba"
 * Example 2: Input: S = "aaab"; Output: ""
 * Note: S will consist of lowercase letters and have length in range [1, 500]
 * Code from: @diddit https://leetcode.com/problems/reorganize-string/discuss/113440/Java-solution-PriorityQueue
 */

public class ReorganizeString {

	public static String reorganizeString(String S) {
	    System.out.println("S: "+S);
		
	    //https://stackoverflow.com/questions/11003155/change-priorityqueue-to-max-priorityqueue
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]); //b-a => max priority queue
		
	    int[] m = new int[26];
	    
	    for(int i=0; i<S.length(); i++) {
	    	System.out.println("i: "+i+" S.charAt(i): "+S.charAt(i));
	    	m[S.charAt(i) - 'a']++; // map of char counts
	    }
	    System.out.println("m: "+Arrays.toString(m));

	    for(int i=0; i<26; i++) {
	    	System.out.println("i: "+i+" m[i]: "+m[i]);
	        if(m[i] != 0) {
	            q.offer(new int[] {i, m[i]}); // add char counts to priority queue
	        }
	    }
	    System.out.println("q: "+q);

	    int[] prev = new int[] {-1,0};
	    StringBuilder sb = new StringBuilder();
	    
	    while(!q.isEmpty()) {
	        
	    	int[] cur = q.poll();
	        System.out.println("cur: "+Arrays.toString(cur)+" prev[1]: "+prev[1]);
	        
	        if(prev[1] > 0) {
	        	q.offer(prev); // add back last used character
	        }
	        System.out.println("q: "+q+" cur[0]: "+cur[0]+" (cur[0] + 'a'): "+(cur[0] + 'a')+" sb: "+sb);

	        sb.append((char)(cur[0] + 'a')); 	// append current character
	        cur[1]--; 							// decrease count of current char since it's used
	        prev = cur; 						// set this character as previous used
	        
	        System.out.println("prev: "+Arrays.toString(prev)+" prev[1]: "+prev[1]+" sb: "+sb);
	        
	        if(q.isEmpty() && prev[1] > 0) 
	        	return ""; // if we left with anything return ""
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		String S = "bcc";
		System.out.println(reorganizeString(S));
	}

}
