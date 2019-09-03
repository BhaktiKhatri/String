package String;

import java.util.Arrays;

/**
 * Leetcode 443. String Compression
 * https://leetcode.com/problems/string-compression/description/
 * Given an array of characters, compress it in-place. The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1. After you are done modifying the input array in-place, return the new length of the array.
 * Follow up: Could you solve it using only O(1) extra space? 
 * Example 1: Input: ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * Example 2: Input: ["a"] Output: Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation: Nothing is replaced.
 * Example 3: Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"] Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * Note: All characters have an ASCII value in [35, 126]. 1 <= len(chars) <= 1000.
 * Explanation and Code from: Approach #1: Read and Write Heads https://leetcode.com/problems/string-compression/solution/
 * @author NisuBhakti
 * Time Complexity: O(N), where N is the length of chars. Space Complexity: O(1), the space used by read, write and anchor.
 * Easy
 * Microsoft, Bloomberg, Snapchat, Amazon, Yelp, Expedia, GoDaddy, Lyft
 */

public class StringCompression {

//	public static int compress(char[] chars) {
//		System.out.println(Arrays.toString(chars));
//		StringBuilder sb = new StringBuilder();
//		int count = 1;
//		
//		for(int i=0; i<chars.length-1; i++) {
//			if(chars[i] == chars[i+1]) {
//				count++;
//			}
//			else {
//				count = 1;
//			}
//		}
//		return count;
//	}
	
	//Refer this
	public static int compress1(char[] chars) {
        int indexAns = 0;
        int index = 0;
        System.out.println(Arrays.toString(chars));
        
        while(index < chars.length) {
        	System.out.println("index: "+index+" indexAns: "+indexAns);
        	
        	char currentChar = chars[index];
            int count = 0;
            System.out.println("currentChar: "+currentChar);
            
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            System.out.println("index: "+index+" indexAns: "+indexAns+" count: "+count+" chars[indexAns]: "+chars[indexAns]);
            
            chars[indexAns++] = currentChar;
            System.out.println("hi: "+Arrays.toString(Integer.toString(count).toCharArray()));
            char[] ch = Integer.toString(count).toCharArray();
            
            if(count != 1) {
                for(int i=0; i<ch.length; i++) { 
                	//System.out.println("c: "+c+" chars[indexAns]: "+chars[indexAns]);
                    chars[indexAns++] = ch[i];
                }
            }
        }
        
        String res = new String(chars);
        res = res.substring(0, indexAns);
        char[] result = res.toCharArray();
        
        System.out.println("indexAns: "+indexAns+" index: "+index+" chars: "+Arrays.toString(chars)+" res: "+Arrays.toString(result));
        
        return indexAns;
    }
	
	public static int compress2(char[] chars) {
		System.out.println(Arrays.toString(chars));
		
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
        	System.out.println("read: "+read+" write: "+write+" anchor: "+anchor);
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        System.out.println(Arrays.toString(chars));
        return write;
    }
	
	public static void main(String[] args) {
		char[] ch = {'a','a','b','b','c','c','c'};
		//char[] ch = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress1(ch));
	}

}
