package String;

import java.util.Arrays;

/**
 * Leetcode 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/description/
 * Compare two version numbers version1 and version2. If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering: 0.1 < 1.1 < 1.2 < 13.37
 * Explanation and Code from: @wenhua93 https://leetcode.com/problems/compare-version-numbers/discuss/50774
 * Medium
 * Microsoft, Apple
 */

public class CompareVersionNumbers {

	//My idea is split by the split method, and then converted to an int value, a later comparison
	public static int compareVersion(String version1, String version2) {
        System.out.println("version1: "+version1+" version2: "+version2);
		
		String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        System.out.println("v1: "+Arrays.toString(v1)+" v2: "+Arrays.toString(v2));
        System.out.println("v1.length: "+v1.length+" v2.length: "+v2.length);
        
        int n = Math.max(v1.length,v2.length);
        System.out.println("n: "+n);
        
        for(int i=0; i<n; i++) {
        	System.out.println("i: "+i);
        	
	        int k = i<v1.length ? Integer.parseInt(v1[i]) : 0;
	        int j = i<v2.length ? Integer.parseInt(v2[i]) : 0;
	        System.out.println("k: "+k+" j: "+j);
	        
	        if(k > j) 
	        	return 1;
	        else if(k < j) 
	        	return -1;
	        else
	        	continue;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		String version1 = "7.5.2.4";
		String version2 = "7.5.3";
		System.out.println("version1: "+version1+" version2: "+version2);
		System.out.println(compareVersion(version1, version2));
	}

}