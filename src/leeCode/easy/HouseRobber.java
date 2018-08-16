package leeCode.easy;

/**
 * Created by yu on 2018/8/13.
 */
public class HouseRobber {
    public static void main(String[] args) {
        Solution s = new HouseRobber().new Solution();
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println(s.rob(nums));
    }

    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            int[][] dp = new int[length + 1][2];
            for (int i = 1; i <= length; i++) {
                dp[i][0] = dp[i - 1][1] + nums[i - 1];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
            return Math.max(dp[length][0], dp[length][1]);
        }
    }
}
