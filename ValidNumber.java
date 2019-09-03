package String;

/**
 * Leetcode 65. Valid Number
 * https://leetcode.com/problems/valid-number/description/
 * Validate if a given string is numeric. Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Explanation and Code from: https://leetcode.com/problems/valid-number/discuss/23738/
 * @author NisuBhakti
 * Time Complexity: O(N)
 * LinkedIn
 */

public class ValidNumber {
	
	/*
	 	We start with trimming.
		If we see [0-9] we reset the number flags.
		We can only see . if we didn’t see e or ..
		We can only see e if we didn’t see e but we did see a number. We reset numberAfterE flag.
		We can only see + and - in the beginning and after an e
		any other character break the validation.
		At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
	 */

	public static boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        
        for(int i=0; i<s.length(); i++) {
        	
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } 
            else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            }
            else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen)
                    return false;
                numberSeen = false;
                eSeen = true;
            }
            else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            }
            else
                return false;
        }
        return numberSeen;
    }
	
	public static void main(String[] args) {
		String s = "2e10";
		System.out.println(s);
		System.out.println(isNumber(s));
	}
}