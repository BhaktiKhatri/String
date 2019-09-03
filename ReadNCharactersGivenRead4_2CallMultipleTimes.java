package String;

/**
 * Leetcode 158. Read N Characters Given Read4 II - Call multiple times
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/description/
 * The API: int read4(char *buf) reads 4 characters at a time from a file. The return value is the actual number of characters read. 
 * For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note: The read function may be called multiple times.
 * Explanation and Code from: https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49598
 * @author NisuBhakti
 * Google, Facebook, Bloomberg
 */

public class ReadNCharactersGivenRead4_2CallMultipleTimes {

	private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
//    public static int read(char[] buf, int n) {
//        int ptr = 0;
//        while (ptr < n) {
//            if (buffPtr == 0) {
//                buffCnt = read4(buff);
//            }
//            if (buffCnt == 0) break;
//            while (ptr < n && buffPtr < buffCnt) {
//                buf[ptr++] = buff[buffPtr++];
//            }
//            if (buffPtr >= buffCnt) buffPtr = 0;
//        }
//        return ptr;
//    }
	
	public static void main(String[] args) {

	}

}
