package String;

/**
 * Leetcode 157. Read N Characters Given Read4
 * https://leetcode.com/problems/read-n-characters-given-read4/description/
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note: The read function will only be called once for each test case.
 * Explanation and Code from: @sunwalker https://leetcode.com/problems/read-n-characters-given-read4/discuss/49496/Another-accepted-Java-solution
 * @author NisuBhakti
 * Easy
 * Facebook
 */

public class ReadNCharactersGivenRead4 {

	//Also, the reason we need Math.min(count, n-total) is because we only want to read N characters even if we have all 4 characters returned from Read4.
	//Say, N = 18 and we're implementing Read18, then Read4 will takes us to 4*4 = 16 chars. After that, we only want to read 2 more chars (even if the next Read4 returns 3 or 4 characters).
	//Refer this
	public int read1(char[] buf, int n) {

        char[] temp = new char[4];  //Store our read chars from Read4
        int total = 0;
        
        while(total < n){
            /*Read and store characters in Temp. Count will store total chars read from Read4*/
            //int count = read4(temp);
        	int count = 0;
            /*Even if we read 4 chars from Read4, 
            we don't want to exceed N and only want to read chars till N.*/
            count = Math.min(count, n-total);
            
            //Transfer all the characters read from Read4 to our buffer
            for(int i = 0;  i < count; i++){
                buf[total] = temp[i];
                total++;
            }
            
            //done. We can't read more characters.
            if(count < 4) break;
        }
        
        return total;
    }

	
	/* The read4 API is defined in the parent class Reader4.
    int read4(char[] buf); */
	
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int res = 0, count = -1;
        while (res < n) {
            //count = read4(tmp);
            if (count == 0) 
            	break;
            int r = n - res < count ? n - res : count;
            for (int i = 0; i < r; i++) {
                buf[res++] = tmp[i];
            }
        }
        return res;
    }
	
	public static void main(String[] args) {

	}

}
