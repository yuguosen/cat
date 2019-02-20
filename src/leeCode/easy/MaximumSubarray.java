package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/27 20:35
 */

public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            if (len <= 0)
                return 0;
            if (len == 1)
                return nums[0];
            int[] dp = new int[len];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < len; i++) {
                dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
