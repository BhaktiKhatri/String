package String;

import java.util.Arrays;

public class SplitConcatenatedStrings {

	public static String splitLoopedString(String[] strs) {
		System.out.println(Arrays.toString(strs));
		
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0)
            	strs[i] = rev;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) 
        	sb.append(strs[i]);
        String mid = sb.toString(), result = mid+strs[n-1];
        
        for (int i = 0; i < n; i++) {
            String str = strs[i], rev = new StringBuilder(str).reverse().toString();
            mid = mid.substring(str.length())+strs[(i+n-1)%n];
            for (int j = 0; j <= str.length(); j++) {
                String s1 = str.substring(j)+mid+str.substring(0, j);
                String s2 = rev.substring(j)+mid+rev.substring(0, j);
                if (s1.compareTo(s2) >= 0 && s1.compareTo(result) > 0) 
                	result = s1;
                else if (s2.compareTo(s1) >= 0 && s2.compareTo(result) > 0)
                	result = s2;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		String[] strs = {"abc", "xyz"};
		System.out.println(splitLoopedString(strs));
	}

}
