package String;

/**
 * Leetcode 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/description/
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA". All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google". Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1: Input: "USA", Output: True
 * Example 2: Input: "FlaG", Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * Explanation and Code from: https://leetcode.com/problems/detect-capital/discuss/99248
 * @author NisuBhakti
 * Time Complexity: O(N)
 * Easy
 * Google
 */

public class DetectCapital {

	public static boolean detectCapitalUse(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) {
        	System.out.println("c: "+c+" 'Z' - c: "+('Z' - c)+" cnt: "+cnt);
        	if('Z' - c >= 0) 				//ASCII values A-Z: 65-90; a-z: 97-122
        		cnt++;
        }
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0)); 
        //cnt=0 means all letters in lower case eg leetcode; cnt=word.length() means all letters in upper case eg USA;
        //(cnt==1 && 'Z' - word.charAt(0)>=0) means first letter in uppercase eg Google
    }
	
	public static void main(String[] args) {
		String word = "Google";
		System.out.println(detectCapitalUse(word));
	}

}
