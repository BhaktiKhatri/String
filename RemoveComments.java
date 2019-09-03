package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 722. Remove Comments
 * Given a C++ program, remove comments from it
 * Explanation and Code from: Approach #1: Parsing https://leetcode.com/problems/remove-comments/solution/
 * Time Complexity: O(S), where S is the total length of the source code; Space Complexity: O(S), the space used by recording the source code into ans
 * Medium
 * Microsoft
 */

public class RemoveComments {

	public static List<String> removeComments(String[] source) {
		System.out.println("source: "+Arrays.toString(source));
		
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList<String>();
        
        for(String line: source) {
            System.out.println("line: "+line+" line.length(): "+line.length());
        	
            int i = 0;
            char[] chars = line.toCharArray();
            System.out.println("chars: "+Arrays.toString(chars));
            
            if(!inBlock) {	//false
            	newline = new StringBuilder();
            }
            
            while(i < line.length()) {
            	if(i < line.length()-1)
            		System.out.println("i: "+i+" line.length(): "+line.length()+" inBlock: "+inBlock+" chars[i]: "+chars[i]+" chars[i+1]: "+chars[i+1]+" newline: "+newline+" ans: "+ans);
            	
                if(!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } 
                else if(inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } 
                else if(!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } 
                else if(!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            
            if(!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
		System.out.println(removeComments(source));
	}

}
