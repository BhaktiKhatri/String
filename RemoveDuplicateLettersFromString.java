package String;

public class RemoveDuplicateLettersFromString {

	public static String RemoveDuplicateLetters(String s) {
		int[] freq = new int[26];
		
		System.out.println("s: "+s);
		
		for(int i=0; i<s.length(); i++) {
			System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i));
			freq[s.charAt(i) - 'a']++;
		}
		
		String str = "";
		for(int i=0; i<s.length(); i++) {
			//System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" s.charAt(i) - 'a': "+(s.charAt(i) - 'a')+" freq[s.charAt(i) - 'a']: "+freq[s.charAt(i) - 'a']);
			if(freq[s.charAt(i) - 'a'] > 1) {
				continue;
			}
			str = str + s.charAt(i);
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		System.out.println(RemoveDuplicateLetters("somethingelse"));
	}

}
