package String;

import java.util.ArrayList;
import java.util.List;

/*
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 * Write a program that outputs the string representation of numbers from 1 to n.
   But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
   Example:
   n = 15,
   Return:
   [
	    "1",
	    "2",
	    "Fizz",
	    "4",
	    "Buzz",
	    "Fizz",
	    "7",
	    "8",
	    "Fizz",
	    "Buzz",
	    "11",
	    "Fizz",
	    "13",
	    "14",
	    "FizzBuzz"
	]
	Explanation and Code from: @hand515 https://leetcode.com/problems/fizz-buzz/discuss/89931/Java-4ms-solution-Not-using-%22%22-operation
 */

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
    	System.out.println("n: "+n);
        List<String> ret = new ArrayList<String>(n);
        
        for(int i=1,fizz=0,buzz=0;i<=n ;i++) {
        	System.out.println("i: "+i+" fizz: "+fizz+" buzz: "+buzz);
            fizz++;
            buzz++;
            System.out.println("fizz: "+fizz+" buzz: "+buzz+" ret: "+ret);
            
            if(fizz==3 && buzz==5) {
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }
            else if(fizz==3) {
                ret.add("Fizz");
                fizz=0;
            }
            else if(buzz==5) {
                ret.add("Buzz");
                buzz=0;
            }
            else {
                ret.add(String.valueOf(i));
            }
            System.out.println("ret: "+ret);
        }
        System.out.println("ret: "+ret);
        return ret;
    }
	
	public static void main(String[] args) {
		int n = 15;
		System.out.println(fizzBuzz(n));
	}
}
