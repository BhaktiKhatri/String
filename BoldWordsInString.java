package String;

import java.util.Arrays;

/**
 * Leetcode 758. Bold Words in String
 * https://leetcode.com/problems/bold-words-in-string/description/
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 * Note: words has length in range [0, 50]. words[i] has length in range [1, 10]. S has length in range [0, 500]. All characters in words[i] and S are lowercase letters.
 * @author NisuBhakti
 * Easy
 * Google
 */

public class BoldWordsInString {

	public static String boldWords(String[] dict, String s) {
		System.out.println("s: "+s+" dict: "+Arrays.toString(dict));
		boolean[] bold = new boolean[s.length()];
		
		for(int i=0, end=0; i<s.length(); i++) {
			System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i));
			for(String word: dict) {
				System.out.println("word: "+word);
				if(s.startsWith(word, i)) {
					System.out.println("end: "+end);
					end = Math.max(end, i + word.length());
				}
			}
			System.out.println("end: "+end+" i: "+i+" end > i: "+(end>i));
			bold[i] = end > i;
		}
		System.out.println("bold: "+Arrays.toString(bold));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < s.length(); i++) {
			System.out.println("i: "+i+" bold[i]: "+bold[i]);
			if(!bold[i]) {
				System.out.println("sb: "+sb+" s.charAt(i): "+s.charAt(i));
				sb.append(s.charAt(i));
				continue;
			}
			int j = i;
			System.out.println("j: "+j+" bold[j]: "+bold[j]);
			while(j< s.length() && bold[j]) {
				j++;
			}
			System.out.println("i: "+i+" j: "+j+" s.substring(i, j): "+s.substring(i, j));
			sb.append("<b>"+s.substring(i, j)+"</b>");
			i = j - 1;
		}
		System.out.println("sb: "+sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] dict = {"ab", "bc"};
		String S = "aabcd";
		System.out.println(boldWords(dict, S));
	}

}
