// Problem: Maximum Product Subarray
// Link: https://leetcode.com/problems/maximum-product-subarray

package JavaLC;

import java.util.logging.*;

public class MaximumProductSubarray {

    private static final Logger logger = Logger.getLogger(MaximumProductSubarray.class.getName());

    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int answer = nums[0];
        for(int i = 1; i < nums.length; i++){
            int maxNums = maxSoFar * nums[i];
            int minNums = minSoFar * nums[i];
            maxSoFar = Math.max(nums[i], Math.max(maxNums, minNums));
            minSoFar = Math.min(nums[i], Math.min(maxNums, minNums));
            answer = Math.max(maxSoFar, answer);
        }
        return answer;       
    }

    public static void main(String[] args) {
        MaximumProductSubarray sol = new MaximumProductSubarray();
        int result = sol.maxProduct(new int[]{42, 43});
        logger.log(Level.INFO, String.valueOf(result));
    }
}











