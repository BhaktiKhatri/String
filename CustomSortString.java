package String;

/*
 * 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/description/
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * Return any permutation of T (as a string) that satisfies this property.
 * Example : Input: S = "cba"; T = "abcd"; Output: "cbad"
 * Explanation: "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 * Note: S has length at most 26, and no character is repeated in S. T has length at most 200. S and T consist of lowercase letters only.
 * Explanation and Code from: @rock https://leetcode.com/problems/custom-sort-string/discuss/116615/Java-5-ms-10-line-counting-solution-with-comment
 * Amazon
 * Medium
 */

public class CustomSortString {

    public static String customSortString(String S, String T) {
        int[] count = new int[26];
        System.out.println("S: "+S+" T: "+T);
        
        for(char c: T.toCharArray()) {
        	System.out.println("c: "+c);
        	++count[c - 'a'];							// count each char in T 
        }  
        
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()) {                            
        	System.out.println("c: "+c+" sb: "+sb);
        	
        	while(count[c - 'a']-- > 0) {				// sort chars both in T and S by the order of S. 
            	sb.append(c); 
            }    
        }
        
        for(char c='a'; c<='z'; ++c) {
            while(count[c - 'a']-- > 0) {				// group chars in T but not in S 
            	sb.append(c); 
            }   
        }
        return sb.toString();
   }		
	
	public static void main(String[] args) {
		String S = "cba";
		String T = "abcd";
		
		System.out.println(customSortString(S, T));
	}

}
