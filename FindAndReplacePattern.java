package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;

/*
 * 890. Find and Replace Pattern
 * https://leetcode.com/problems/find-and-replace-pattern/
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), 
 * we get the desired word.
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 * Return a list of the words in words that match the given pattern. You may return the answer in any order.
 * Example 1: Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"; Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 * Note: 1 <= words.length <= 50; 1 <= pattern.length = words[i].length <= 20
 * Explanation and Code from: @lee215 https://leetcode.com/problems/find-and-replace-pattern/discuss/161288/C%2B%2BJavaPython-Normalise-Word
 */

public class FindAndReplacePattern {

	/*
	 	Normalise a string to a standard pattern.
		Yes. You can pass the F(pattern) to the sub function and return earlier in case of dismatch.
	 */
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
    	int[] p = F(pattern);
        System.out.println("p: "+Arrays.toString(p));
        
        List<String> res = new ArrayList<String>();
        
        for(String w: words) {
        	System.out.println("w: "+w+" res: "+res);
        	
        	int[] arr = F(w);
        	System.out.println("arr: "+Arrays.toString(arr));
        	
            if(Arrays.equals(arr, p)) { 
            	res.add(w);
            }
        }
        System.out.println("res: "+res);
        
        return res;
    }

    public static int[] F(String w) {
    	System.out.println("w: "+w);
        
    	HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
        	System.out.println("w.charAt(i): "+w.charAt(i)+" m: "+m);
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        System.out.println("res: "+Arrays.toString(res));

        return res;
    }

	
	public static void main(String[] args) {
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		
		System.out.println("words: "+Arrays.toString(words));
		System.out.println("pattern: "+pattern);
		
		System.out.println(findAndReplacePattern(words, pattern));
	}

}
