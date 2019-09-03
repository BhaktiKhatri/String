package String;

/**
 * Leetcode 551. Student Attendance Record I
 * https://leetcode.com/problems/student-attendance-record-i/description/
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent, 'L' : Late, 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1: Input: "PPALLP", Output: True
 * Example 2: Input: "PPALLL", Output: False
 * Explanation and Code from: Approach #4 Using Regex https://leetcode.com/problems/student-attendance-record-i/solution/ 
 * @author NisuBhakti
 * Time complexity : O(n), matches method takes O(n) time.
 * Space complexity : O(1), No Extra Space is used.
 * Easy
 * Google
 */

public class StudentAttendanceRecord1 {

	public static boolean checkRecord(String s) {
	    return !s.matches(".*(A.*A|LLL).*");
	}
	
	public static void main(String[] args) {
		String s = "PPALLP";
		System.out.println(checkRecord(s));
	}
	
	public boolean checkRecord1(String s) {
        if(s.isEmpty())
            return true;
        
        if(s.contains("LLL"))
            return false;
        
        int count = 0;
        for(int i=0; i<s.length() && count < 2; i++) {
            if(s.charAt(i) == 'A')
                count++;
        }
        return count<2;
    }

}
