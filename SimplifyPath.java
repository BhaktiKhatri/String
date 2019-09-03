package String;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 71. Simplify Path
 * 71. Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it
 * For example, path = "/home/", => "/home", path = "/a/./b/../../c/", => "/c"
 * Corner Cases: Did you consider the case where path = "/../"? In this case, you should return "/"
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/". In this case, you should ignore redundant slashes and return "/home/foo"
 * Explanation and Code from: https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://massivealgorithms.blogspot.com/2016/04/leetcode-71-simplify-path.html&prev=search https://leetcode.com/problems/simplify-path/discuss/25686/
 * Medium
 * Facebook, Microsoft
 */

public class SimplifyPath {

	/*
	 	The main idea is to push to the stack every valid file name (not in {"",".","…"}), popping only if there’s smth to pop and we met “…”
	 */
	public static String simplifyPath(String path) { 
		System.out.println("path:"+path+":");
		
        Set<String> isSkip = new HashSet<>(Arrays.asList("", ".", "..")); 
        Deque<String> stack = new ArrayDeque<>(); 
        
        for(String token: path.split("/")) { 
        	System.out.println("token:"+token+": stack: "+stack);
           
        	if(token.equals("..") && !stack.isEmpty()) { 
                stack.pop(); 
        	}

        	if(isSkip.contains(token)) {
                continue; 
            }
            stack.push(token);
        }
        
        StringBuilder sb = new StringBuilder(); 
        System.out.println("stack: "+stack);
        while(!stack.isEmpty()) {					//while (path.peekLast() != null)
            sb.append("/"+stack.pollLast());	//pollLast() is opposite of pop()
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
	
	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		System.out.println(simplifyPath(path));
	}

}