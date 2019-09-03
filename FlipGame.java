package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 293. Flip Game
 * https://leetcode.com/problems/flip-game/description/
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states:
 *	[
 *	  "--++",
 *	  "+--+",
 *	  "++--"
 *	]
 * If there is no valid move, return an empty list []
 * Explanation and Code from: @vimukthi https://leetcode.com/problems/flip-game/discuss/73901?page=1
 * @author NisuBhakti
 * Easy
 * Google
 * Time Complexity: O(N)
 */

public class FlipGame {

	public static List<String> generatePossibleNextMoves(String s) {
        List<String> answer = new ArrayList<>();
        char[] arr = s.toCharArray();
        
        System.out.println("s: "+s);
        
        for(int i=0; i<arr.length-1; i++) {
            System.out.println("i: "+i+" arr[i]: "+arr[i]+" arr[i+1]: "+arr[i+1]+" answer: "+answer);
        	
        	if(arr[i] == '+' && arr[i+1] == '+') {
                arr[i] = '-';
                arr[i+1] = '-';
                answer.add(new String(arr));
                arr[i] = '+'; 
                arr[i+1] = '+';
            }
        }
        System.out.println("answer: "+answer);
        return answer;
    }
	
	public static void main(String[] args) {
		String s = "++++";
		System.out.println(generatePossibleNextMoves(s));
	}

}
