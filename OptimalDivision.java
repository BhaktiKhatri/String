package String;

import java.util.Arrays;

/**
 * Leetcode 553. Optimal Division
 * https://leetcode.com/problems/optimal-division/description/
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.
 * However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.
 * Example: Input: [1000,100,10,2], Output: "1000/(100/10/2)"
 * Explanation: 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant, since they don't influence the operation priority. So you should return "1000/(100/10/2)". 
 * Other cases: 1000/(100/10)/2 = 50; 1000/(100/(10/2)) = 50; 1000/100/10/2 = 0.5; 1000/100/(10/2) = 2
 * Note: The length of the input array is [1, 10]. Elements in the given array will be in range [2, 1000]. There is only one optimal division for each test case.
 * Explanation and Code from: Approach #3 Using some Math https://leetcode.com/problems/optimal-division/solution/
 * Time complexity : O(n), Single loop to traverse nums array.
 * Space complexity : O(n), res variable is used to store the result.
 * Medium
 * Amazon
 */

public class OptimalDivision {

	public static String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return nums[0] + "";
        else if (nums.length == 2)
            return nums[0] + "/" + nums[1];
        
        System.out.println("nums: "+Arrays.toString(nums));
        
        StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
        System.out.println("res: "+res);
        
        for(int i=2; i<nums.length; i++) {
            System.out.println("i: "+i+" nums[i]: "+nums[i]+" res: "+res);
        	res.append("/" + nums[i]);
        }
        res.append(")");
        
        System.out.println("res: "+res);
        
        return res.toString();
    }
	
	public static void main(String[] args) {
		int[] nums = {1000,100,10,2};
		System.out.println(optimalDivision(nums));
	}

}