package leeCode.medium;

/**
 * Created by yu on 2018/8/13.
 */
public class HouseRobberII {
    public static void main(String[] args) {
        Solution s = new HouseRobberII().new Solution();
        int[] nums = new int[]{1, 2, 1, 1};
        System.out.println(s.rob(nums));
    }

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length <= 0)
                return 0;
            if (nums.length == 1)
                return nums[0];
            int length = nums.length;
            int[][] dp = new int[length + 1][2];
            int startIndex = 1;
            int endIndex = length;

            for (int i = startIndex + 1; i <= endIndex; i++) {
                dp[i][0] = dp[i - 1][1] + nums[i - 1];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
            int max1 = Math.max(dp[endIndex][0], dp[endIndex][1]);
            dp = new int[length + 1][2];
            startIndex = 0;
            endIndex = length - 1;
            for (int i = startIndex + 1; i <= endIndex; i++) {
                dp[i][0] = dp[i - 1][1] + nums[i - 1];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
            int max2 = Math.max(dp[endIndex][0], dp[endIndex][1]);
            return Math.max(max1, max2);
        }
    }
}
