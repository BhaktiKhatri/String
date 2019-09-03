package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 539. Minimum Time Difference
 * https://leetcode.com/problems/minimum-time-difference/discuss/100640
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1: Input: ["23:59","00:00"], Output: 1
 * Note: The number of time points in the given list is at least 2 and won't exceed 20000. The input time is legal and ranges from 00:00 to 23:59.
 * Explanation and Code from: @jdrogin https://leetcode.com/problems/minimum-time-difference/discuss/100640
 * @author NisuBhakti
 * Medium 
 * Palantir
 */

public class MinimumTimeDifference {

	public static int findMinDifference(List<String> timePoints) {
        boolean[] axis = new boolean[24 * 60];
        System.out.println(timePoints);
        
        for(String t: timePoints)
        {
        	System.out.println("t.charAt(0) - '0': "+(t.charAt(0) - '0')+" t.charAt(1) - '0': "+(t.charAt(1) - '0'));
        	System.out.println("t.charAt(3) - '0': "+(t.charAt(3) - '0')+" t.charAt(4) - '0': "+(t.charAt(4) - '0'));
            int hour = 10 * (t.charAt(0) - '0') + (t.charAt(1) - '0');
            int minute = 10 * (t.charAt(3) - '0') + (t.charAt(4) - '0');
            int index = hour * 60 + minute;
            
            if (axis[index]) 
            	return 0; 		// duplicate
            
            axis[index] = true;
        }
        
        int min = axis.length;
        int curr = axis.length;
        for(int i = 0; i < axis.length; i++)
        {
            if (axis[i])
            {
                if (curr < min) min = curr;
                curr = 1;
            }
            else 
            {
                curr++;
            }
        }
        
        // now check wrap around time diff
        int dist = 1;
        int first = 0;
        
        while (!axis[first]) {
        	first++;
        	dist++; 
        }
        
        int last = axis.length - 1;
        while (!axis[last]) { 
        	last--; 
        	dist++; 
        }
        
        if (dist < min) 
        	min = dist;
        
        return min;
    }
	
	public static void main(String[] args) {
		List<String> timePoints = new ArrayList<String>();
		timePoints.add("23:59");
		timePoints.add("00:00");
		System.out.println(findMinDifference(timePoints));
	}

}
