package String;

/**
 * Leetcode 434. Number of Segments in a String
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example: Input: "Hello, my name is John", Output: 5
 * Explanation and Code from: Approach #2 In-place https://leetcode.com/problems/number-of-segments-in-a-string/solution/
 * @author NisuBhakti
 * Time complexity : O(n) We do a constant time check for each of the string's nn indices, so the runtime is overall linear.
 * Space complexity : O(1) There are only a few integers allocated, so the memory footprint is constant.
 * Easy
 */

public class NumberOfSegmentsInAString {

	public static int countSegments(String s) {
        int segmentCount = 0;

        for(int i = 0; i < s.length(); i++) {
        	if(i != 0)
        		System.out.println("i: "+i+" s.charAt(i-1): "+s.charAt(i-1)+" s.charAt(i): "+s.charAt(i));
            
        	if((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
	
	public static void main(String[] args) {
		String s = "Hello, my name is John";
		System.out.println(countSegments(s));
	}

}
