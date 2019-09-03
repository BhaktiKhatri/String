package String;

/**
 * how to determine if a string is a palindrome
 * @author NisuBhakti
 * Time Complexity: O(n)
 */
public class IsStringPalindrome {

	public static boolean isPalindromeIgnoreCases(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} 
        	else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} 
        	else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        return true;
    }
	
	public static boolean isPalindrome(String s) {
		if(s.length() == 0 || s == null)
			return true;
        String s_rev="";
        for(int rev=s.length()-1; rev>=0; rev--) {
           s_rev = s_rev + s.charAt(rev);
        }
        if (s.equalsIgnoreCase(s_rev))
            return true;
        else
          return false;
    }
	
	public static void main(String args[]) {
		System.out.println(isPalindromeIgnoreCases("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

}
