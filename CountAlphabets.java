package String;

/**
 * WAP for input string=aabbbccccaaa, maintain the insertion order and output should be like a2b3c5a3
 * Amazon interview question
 * @author NisuBhakti
 * Time Complexity: O(n)
 */

public class CountAlphabets {

	public static void process(String mystring) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        for(int i=0; i<(mystring.length())-1 ;i++) {
            if(mystring.charAt(i) == mystring.charAt(i+1)) {
                count++;
            }
            else {
                sb.append(mystring.charAt(i));
                sb.append(count);
                count = 1;
            }
            if(i==(mystring.length())-2) {
            	sb.append(mystring.charAt(i+1));
                sb.append(count);
            }
        }
        System.out.println(sb.toString());
    }
	
	public static void main(String[] args) {
        process("aabbbcccca");
	}
}
