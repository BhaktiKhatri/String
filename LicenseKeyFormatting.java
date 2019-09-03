package String;

/*
 * 482. License Key Formatting
 * https://leetcode.com/problems/license-key-formatting/
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
	Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
	Given a non-empty string S and a number K, format the string according to the rules described above.
	Example 1:
	Input: S = "5F3Z-2e-9-w", K = 4
	Output: "5F3Z-2E9W"
	Explanation: The string S has been split into two parts, each part has 4 characters.
	Note that the two extra dashes are not needed and can be removed.
	Example 2:
	Input: S = "2-5g-3-J", K = 2
	Output: "2-5G-3J"
	Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
	Note:
	The length of string S will not exceed 12,000, and K is a positive integer.
	String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
	String S is non-empty.
	Explanation and Code from: @zzhai https://leetcode.com/problems/license-key-formatting/discuss/96512/Java-5-lines-clean-solution
 */

public class LicenseKeyFormatting {

	 //Refer this
	 public static String licenseKeyFormatting(String S, int K) {
		 	System.out.println("S: "+S+" K: "+K);
		    S = S.replace("-", "").toUpperCase();
		    System.out.println("S: "+S);
		    
		    StringBuilder sb = new StringBuilder(S);
		    System.out.println("sb: "+sb);
	
		    // Starting from the end of sb, and going backwards. 
		    int i = sb.length() - K;
		    System.out.println("i: "+i);

		    while(i > 0) {
		    	System.out.println("i: "+i+" sb: "+sb);
		        sb.insert(i, '-');
		        i = i - K;
		    }
		    System.out.println("sb: "+sb);
		    return sb.toString();
		}
	 
	    public static String licenseKeyFormatting1(String s, int k) {
	    	System.out.println("s: "+s+" k: "+k);
	        StringBuilder sb = new StringBuilder();
	        
	        for(int i=s.length()-1; i>=0; i--) {
	        	System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i));
	        	
	            if(s.charAt(i) != '-') {
	            	System.out.println("sb: "+sb+" sb.length(): "+sb.length()+" (k + 1): "+(k + 1)+" sb.length() % (k + 1): "+(sb.length() % (k + 1)));
	            	
	            	if(sb.length() % (k + 1) == k) {
	            		sb.append("-");
	            	}
	            	System.out.println("sb: "+sb);

	            	sb.append(s.charAt(i));
	            }
	        }
	        System.out.println("sb: "+sb);
	        return sb.reverse().toString().toUpperCase();
	    } 

	public static void main(String[] args) {
		String S = "2-5g-3-J";
		int K = 2;
		System.out.println(licenseKeyFormatting(S, K));
	}
}