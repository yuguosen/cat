package leeCode.medium;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/28 10:42
 */

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution s = new MinimumPathSum().new Solution();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(s.minPathSum(grid));
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            int rowLen = grid.length;
            int colLen = grid[0].length;
            int[][] dp = new int[rowLen + 1][colLen + 1];
            for (int i = 0; i <= rowLen; i++)
                dp[i][0] = Integer.MAX_VALUE;
            for (int j = 0; j <= colLen; j++)
                dp[0][j] = Integer.MAX_VALUE;
            dp[1][1] = grid[0][0];
            for (int i = 0; i < rowLen; i++)
                for (int j = 0; j < colLen; j++)
                    if (j > 0 || i > 0)
                        dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];

            return dp[rowLen][colLen];
        }
    }
}
