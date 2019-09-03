package String;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode 632. Smallest Range
 * https://leetcode.com/problems/smallest-range/description/
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * Example 1: Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]], Output: [20,24]
 * Explanation: List 1: [4, 10, 15, 24,26], 24 is in range [20,24], List 2: [0, 9, 12, 20], 20 is in range [20,24], List 3: [5, 18, 22, 30], 22 is in range [20,24]
 * Note: The given list may contain duplicates, so ascending order means >= here, 1 <= k <= 3500, -105 <= value of elements <= 105.
 * Explanation and Code from: https://leetcode.com/articles/smallest-range/
 * @author NisuBhakti
 * Lyft
 */

public class SmallestRange {

	public static int[] smallestRange(int[][] nums) {
		System.out.println(Arrays.toString(nums[0])+" "+Arrays.toString(nums[1])+" "+Arrays.toString(nums[2]));

		int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] next = new int[nums.length];
        boolean flag = true;
        PriorityQueue<Integer> min_queue = new PriorityQueue<Integer> ((i, j) -> nums[i][next[i]] - nums[j][next[j]]);
        
        for (int i = 0; i < nums.length; i++) {
            min_queue.offer(i);
            max = Math.max(max, nums[i][0]);
        }
        
        System.out.println("min_queue: "+min_queue+" max: "+max);
        
        for (int i = 0; i < nums.length && flag; i++) {
            for (int j = 0; j < nums[i].length && flag; j++) {
            	
                int min_i = min_queue.poll();
                System.out.println("i: "+i+" j: "+j+" min_i: "+min_i+" miny: "+miny+" minx: "+minx+" nums[min_i]: "+Arrays.toString(nums[min_i])+" next[min_i]: "+next[min_i]+" nums[min_i][next[min_i]]: "+nums[min_i][next[min_i]]);

                if (miny - minx > max - nums[min_i][next[min_i]]) {
                    minx = nums[min_i][next[min_i]];
                    miny = max;
                }
                next[min_i]++;

                System.out.println("next[min_i]: "+next[min_i]+" nums[min_i].length: "+nums[min_i].length);
                if (next[min_i] == nums[min_i].length) {
                    flag = false;
                    break;
                }
                min_queue.offer(min_i);
                max = Math.max(max, nums[min_i][next[min_i]]);
                System.out.println("min_queue: "+min_queue+" max: "+max);
            }
        }
        return new int[] { minx, miny};
    }

	public static int[] smallestRange3(int[][] nums) {
		System.out.println(Arrays.toString(nums[0])+" "+Arrays.toString(nums[1])+" "+Arrays.toString(nums[2]));
		
        int minx = 0, miny = Integer.MAX_VALUE;
        int[] next = new int[nums.length];
        boolean flag = true;
        
        for (int i = 0; i < nums.length && flag; i++) {
            for (int j = 0; j < nums[i].length && flag; j++) {
                int min_i = 0, max_i = 0;
                for (int k = 0; k < nums.length; k++) {
                	System.out.println("min_i: "+min_i+" nums[min_i]: "+Arrays.toString(nums[min_i])+" next[min_i]: "+next[min_i]+" nums[min_i][next[min_i]]: "+nums[min_i][next[min_i]]+" k: "+k+" nums[k]: "+Arrays.toString(nums[k])+" next[k]: "+next[k]+" nums[k][next[k]]: "+nums[k][next[k]]);
                	System.out.println("max_i: "+max_i+" nums[max_i]: "+Arrays.toString(nums[max_i])+" next[max_i]: "+next[max_i]+" nums[max_i][next[max_i]]: "+nums[max_i][next[max_i]]);
                    if (nums[min_i][next[min_i]] > nums[k][next[k]])
                        min_i = k;
                    if (nums[max_i][next[max_i]] < nums[k][next[k]])
                        max_i = k;
                }
                System.out.println("miny: "+miny+" minx: "+minx+" min_i: "+min_i+" max_i: "+max_i+" nums[max_i][next[max_i]]: "+nums[max_i][next[max_i]]+" nums[min_i][next[min_i]]: "+nums[min_i][next[min_i]]);
                if (miny - minx > nums[max_i][next[max_i]] - nums[min_i][next[min_i]]) {
                    miny = nums[max_i][next[max_i]];
                    minx = nums[min_i][next[min_i]];
                }
                next[min_i]++;
                System.out.println("next[min_i]: "+next[min_i]+" nums[min_i].length: "+nums[min_i].length);
                if (next[min_i] == nums[min_i].length) {
                    flag = false;
                }
            }
        }
        return new int[] {minx, miny};
    }
	
	public static void main(String[] args) {
		int[][] nums = {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
		int[] arr = smallestRange(nums);
		System.out.println(Arrays.toString(arr));
	}

}
