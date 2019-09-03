package String;

/**
 * Leetcode 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/discuss/
 * The idea is simple. It creates a size 26 int arrays as buckets for each letter in alphabet. It increments the bucket value with String s 
 * and decrement with string t. So if they are anagrams, all buckets should remain with initial value which is zero. So just checking that and return
 * @author NisuBhakti
 * Time complexity : O(n) because accessing the counter table is a constant time operation
 * Space complexity : O(1) Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is
 */

public class ValidAnagrams {
	
	public static boolean isAnagram(String s, String t) {
		System.out.println("s: "+s+" t: "+t);
		
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] alphabet = new int[26];
		for(int i=0; i<s.length(); i++) {
			//System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i));
			int index = s.charAt(i) - 'a';
			alphabet[index]++;
		}
		
		for(int i=0; i<t.length(); i++) {
			//System.out.println("i: "+i+" t.charAt(i): "+t.charAt(i));
			int index = t.charAt(i) - 'a';
			alphabet[index]--;
		}
		
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i] != 0) {
				return false;
			}
		}
		
//		for(int i: alphabet) {
//			System.out.println("i: "+i);
//			if(i != 0) {
//				return false;
//			}
//		}
		return true;
	}

	public static void main(String[] args) {
		String s = "listen";
		String t = "silent";
		ValidAnagrams va = new ValidAnagrams();
		//va.isAnagram("abc", "cba");
		
		System.out.println(isAnagram(s, t));
	}

}
