package leeCode.medium;

import java.util.Arrays;

/**
 * Created by yu on 2018/8/2.
 */
public class StoneGame {
    public static void main(String[] args) {
        Solution s = new StoneGame().new Solution();
        int[] piles = new int[]{7, 7, 12, 16, 41, 48, 41, 48, 11, 9, 34, 2, 44, 30, 27, 12, 11, 39, 31, 8, 23, 11, 47, 25, 15, 23, 4, 17, 11, 50, 16, 50, 38, 34, 48, 27, 16, 24, 22, 48, 50, 10, 26, 27, 9, 43, 13, 42, 46, 24};
        System.out.println(s.stoneGame(piles));
    }

    class Solution {
        public boolean stoneGame(int[] piles) {
            int sum = Arrays.stream(piles).sum();
            int[][] dp = new int[piles.length][piles.length];
            int max = dfs(0, piles.length - 1, piles, dp);
            return max > sum - max;
        }

        public int dfs(int startIndex, int endIndex, int[] nums, int[][] dp) {
            if (startIndex > endIndex) return 0;
            if (dp[startIndex][endIndex] != 0) return dp[startIndex][endIndex];
            //Alex choice start
            int startRe = nums[startIndex] + Math.max(
                    dfs(startIndex + 2, endIndex, nums, dp)//lee choice start
                    , dfs(startIndex + 1, endIndex - 1, nums, dp)//lee choice end
            );

            //Alex choice end
            int endRe = nums[endIndex] + Math.max(
                    dfs(startIndex + 1, endIndex - 1, nums, dp)//lee choice start
                    , dfs(startIndex, endIndex - 2, nums, dp)//lee choice end
            );
            dp[startIndex][endIndex]=Math.max(startRe, endRe);
            return dp[startIndex][endIndex];
        }
    }
}
