package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 93. Restore IP Addresses
 * 93. Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations
 * For example: Given "25525511135", return ["255.255.11.135", "255.255.111.35"] (Order does not matter)
 * Explanation and Code from: @cdai https://leetcode.com/problems/restore-ip-addresses/discuss/30949?page=3
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/higerzhang/p/4117279.html&prev=search
 * Medium
 * Amazon
 */

public class RestoreIPAddresses {
  
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        System.out.println("s: "+s+" s.length(): "+s.length());
        
        if(s.length() < 4) { 
        	return result; 
        }
        
        doRestore(result, "", s, 0);
        return result;
    }
    
    public static void doRestore(List<String> result, String path, String s, int k) {
        System.out.println("result: "+result+" path: "+path+" s: "+s+" k: "+k);
    	
    	if(s.isEmpty() || k == 4) {
            if(s.isEmpty() && k == 4) {
                result.add(path.substring(1));
            }
            return;
        }
        
        for(int i=1; i<=(s.charAt(0)=='0' ? 1 : 3) && i<=s.length(); i++) { 			// Avoid leading 0
        	System.out.println("i: "+i+" s.charAt(0): "+s.charAt(0)+" s.substring(0, i): "+s.substring(0, i));

        	String part = s.substring(0, i);
        	System.out.println("part: "+part+" Integer.valueOf(part): "+Integer.valueOf(part));
            
            if(Integer.valueOf(part) <= 255) {
            	System.out.println("i: "+i+" path: "+path+" part: "+part+" k: "+k+" result: "+result);
                doRestore(result, path + "." + part, s.substring(i), k + 1);
            }
        }
    }
	
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(s);
		System.out.println(restoreIpAddresses(s));
	}

}
