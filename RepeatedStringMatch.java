package String;

/**
 * Leetcode 686. Repeated String Match
 * https://leetcode.com/problems/repeated-string-match/description/
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab". Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * Note: The length of A and B will be between 1 and 10000.
 * Explanation and Code from: @n2c https://leetcode.com/problems/repeated-string-match/discuss/108086/     https://discuss.leetcode.com/topic/109570/can-anybody-show-why-the-repeated-string-must-stop-at-the-length-of-a-length-2-b-length/3
 * @author NisuBhakti
 * Time Complexity: O(logN)
 * Easy
 * Google
 */

public class RepeatedStringMatch {

	public static int repeatedStringMatch(String A, String B) {
        String C = A, P = A;
        int n = (B.length() + A.length()-1) / A.length();    //n = ceil(len(B)/len(A))
        for (int i = n; i > 0; i=i/2, P+=P) {
        	System.out.println("i: "+i+" P: "+P);
            if (i % 2 == 1) 
            	C = C + P;                        //C = A * power(A, n)
        }
        int j = C.indexOf(B);                                         //where does B start in C?
        return j < 0 ? -1 : (j+B.length() <= n*A.length()) ? n : n+1; //where does B end   in C?
    }
	
	public static void main(String[] args) {
		String A = "abcd";
		String B = "cdabcdab";
		System.out.println(repeatedStringMatch(A, B));
	}

}
