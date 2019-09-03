package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 929. Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
	Besides lowercase letters, these emails may contain '.'s or '+'s.
	If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
	If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
	It is possible to use both of these rules at the same time.
	Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 
	Example 1:
	Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
	Output: 2
	Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
	Note:
	1 <= emails[i].length <= 100
	1 <= emails.length <= 100
	Each emails[i] contains exactly one '@' character.
	Explanation and Code from: Approach 1: Canonical Form https://leetcode.com/problems/unique-email-addresses/solution/
	Time Complexity: O(C), where C is the total content of emails.
	Space Complexity: O(C)
	Let n be the total characters in the input array emails. The HashSet normalized and the for loop both cost O(n), in terms of space and time, respectively.
 */

public class UniqueEmailAddress {

	public static int numUniqueEmails(String[] emails) {
	    Set<String> s = new HashSet<>();
	    System.out.println("emails: "+Arrays.toString(emails));
	    
	    for(String email: emails) {
	    	System.out.println("email: "+email);
	        
	    	String split[] = email.split("@");
	    	System.out.println("split: "+Arrays.toString(split));
	    	
	        String localName = split[0].replace(".", "");
	        System.out.println("localName: "+localName);
	        
	        String domainName = split[1];
	        System.out.println("domainName: "+domainName);
	        
	        if (localName.contains("+")) {
	        	int i = localName.indexOf('+');
	        	System.out.println("i: "+i+" localName.substring(0, i): "+localName.substring(0, i));
	        	localName = localName.substring(0, i);
	        }
	        System.out.println("localName: "+localName+" domainName: "+domainName);
	        
	        s.add(localName + "@" + domainName);
	        System.out.println("s: "+s);
	    }
	    System.out.println("s: "+s);
	    return s.size();
	}

	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
	}

}
