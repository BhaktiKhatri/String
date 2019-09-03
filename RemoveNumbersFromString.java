package String;

/**
 * Remove numbers from a mix of numbers and characters
 * http://www.geeksforgeeks.org/split-numeric-alphabetic-and-special-symbols-from-a-string/
 * @author NisuBhakti
 * Time Complexity: O(n) where n is the length of the string
 */
public class RemoveNumbersFromString {

	public static void separateNumbersCharacters(String str) {
		String num = "";
		String ch = "";
		String specialChar = ""; 
		
		for(int i=0; i<str.length();i++) {
			char c = str.charAt(i);
			if(Character.isDigit(c)) {
				num = num + c;
			}
			else if(Character.isAlphabetic(c)) {
				ch = ch + c;
			}
			else {
				specialChar = specialChar + c;
			}
		}
		System.out.println("String: "+str);
		System.out.println("Numbers: "+num);
		System.out.println("Characters: "+ch);
		System.out.println("Special Characters: "+specialChar);
	}
	
	 public static void main(String args[])
	 {
	     String str = "geeks01$$for02geeks03!@!!";
	     separateNumbersCharacters(str);
	 }
}
