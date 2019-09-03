package String;

/**
 * Leetcode 408. Valid Word Abbreviation
 * https://leetcode.com/problems/valid-word-abbreviation/description/
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
 * Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 * Example 1: Given s = "internationalization", abbr = "i12iz4n": Return true.
 * Example 2: Given s = "apple", abbr = "a2e": Return false.
 * Explanation and Code from: @selim https://leetcode.com/problems/valid-word-abbreviation/discuss/89523
 * @author NisuBhakti
 * Easy
 * Google
 */

public class ValidWordAbbreviation {

	// Iterate over the characters of abbr and skip number of characters of word. Then compare ith chracter of word with jth character of abbr.
	public static boolean validWordAbbreviation(String word, String abbr) {
        System.out.println("word: "+word+" abbr: "+abbr);
		int number = 0;
        int i = 0, j = 0;
        
        while (i < word.length() && j < abbr.length()) {
        	System.out.println("i: "+i+" j: "+j+" word.charAt(i): "+word.charAt(i)+" abbr.charAt(j): "+abbr.charAt(j));
        	
        	if (Character.isDigit(abbr.charAt(j))) {
                number = number * 10 + abbr.charAt(j) - '0';
                System.out.println("number: "+number);
                
                if (number == 0) 
                	return false;
                j++;
            } 
        	else {
                i = i + number;
                System.out.println("i: "+i);
                
                if (i >= word.length() || word.charAt(i) != abbr.charAt(j)) 
                	return false;
                number = 0;
                i++; 
                j++;
            }
        }
        System.out.println("i: "+i+" j: "+j+" number: "+number);
        i = i + number;
        return i == word.length() && j == abbr.length();
    }
	
	public static void main(String[] args) {
		String word = "internationalization";
		String abbr = "i12iz4n";
		System.out.println(validWordAbbreviation(word, abbr));
	}

}
