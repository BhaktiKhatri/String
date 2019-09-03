package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 271. Encode and Decode Strings
 * 271. Encode and Decode Strings
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * So Machine 1 does: string encoded_string = encode(strs); and Machine 2 does: vector<string> strs2 = decode(encoded_string); 
 * strs2 in Machine 2 should be the same as strs in Machine 1. Implement the encode and decode methods.
 * Explanation and Code from: @qianzhige https://leetcode.com/problems/encode-and-decode-strings/discuss/70412
 * Medium
 * Google
 */

public class EncodeAndDecodeStrings {

	// Encodes a list of strings to a single string
    public static String encode(List<String> strs) {
    	System.out.println("strs: "+strs);
        StringBuilder sb = new StringBuilder();
        
        for(String s: strs) {
        	System.out.println("s: "+s+" sb: "+sb);
            sb.append(s.length()).append('/').append(s);
        }
        System.out.println("sb: "+sb.toString());
        
        return sb.toString();
    }
    
    // Decodes a single string to a list of strings
    public static List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        
        System.out.println("s: "+s+" s.length(): "+s.length());
        
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            System.out.println("slash: "+slash);
            
            int size = Integer.valueOf(s.substring(i, slash));
            System.out.println("size: "+size);
            
            ret.add(s.substring(slash + 1, slash + size + 1));
            System.out.println("ret: "+ret);
            
            i = slash + size + 1;
            System.out.println("i: "+i);
        }
        System.out.println("ret: "+ret);
        
        return ret;
    }
	
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();
		strs.add("abc");
		strs.add("def");
		System.out.println("encode: "+encode(strs));
		System.out.println("decode: "+decode("3/abc3/def"));
	}

}
