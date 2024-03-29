package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 681. Next Closest Time
 * https://leetcode.com/problems/next-closest-time/description/
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * Example 1: Input: "19:34", Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Input: "23:59", Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 * Explanation and Code from: Approach #2: Build From Allowed Digits https://leetcode.com/problems/next-closest-time/solution/
 * Time Complexity: O(1), We all 4^4​ possible times and take the best one. Space Complexity: O(1)
 * Medium
 * Google
 */

public class NextClosestTime {

	public static String nextClosestTime(String time) {
		System.out.println(time);
		
        int start = 60 * Integer.parseInt(time.substring(0, 2));
        start = start + Integer.parseInt(time.substring(3));
        int ans = start;
        int elapsed = 24 * 60;
        Set<Integer> allowed = new HashSet<Integer>();
        
        for (char c: time.toCharArray()) 
        	if (c != ':') {
        		allowed.add(c - '0');
        	}

        for (int h1: allowed)
        	for (int h2: allowed) 
        		if (h1 * 10 + h2 < 24) {
        			for (int m1: allowed) 
        				for (int m2: allowed)
        					if (m1 * 10 + m2 < 60) {
        						System.out.println("h1: "+h1+" h2: "+h2+" m1: "+m1+" m2: "+m2);
				                int cur = 60 * (h1 * 10 + h2) + (m1 * 10 + m2);
				                int candElapsed = Math.floorMod(cur - start, 24 * 60);
				                System.out.println("ans: "+ans+" cur: "+cur+" candElapsed: "+candElapsed+" elapsed: "+elapsed);
				                if (0 < candElapsed && candElapsed < elapsed) {
				                    ans = cur;
				                    elapsed = candElapsed;
				                }
        					}
        		}

        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
	
	public static void main(String[] args) {
		String time = "23:59";
		System.out.println(nextClosestTime(time));
	}

}
