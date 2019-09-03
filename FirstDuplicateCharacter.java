package String;

/**
 * Write a code to detect the first number having duplicate in array
 * @author NisuBhakti
 * Time Complexity: O(n)
 */

public class FirstDuplicateCharacter {

	public static char firstDuplicate(String s) {
		int[] freq = new int[26];
		
		System.out.println("s: "+s);
		
		for(int i=0; i<s.length(); i++) {
			System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" s.charAt(i) - 'a': "+(s.charAt(i) - 'a'));
			freq[s.charAt(i) - 'a']++;
		}
		
		for(int i=0; i<s.length(); i++) {
			System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" s.charAt(i) - 'a': "+(s.charAt(i) - 'a')+" freq[s.charAt(i) - 'a']: "+freq[s.charAt(i) - 'a']);
			if(freq[s.charAt(i) - 'a'] > 1) {
				return s.charAt(i);
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(firstDuplicate("ariizroon"));
	}
}
