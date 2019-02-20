package leeCode.medium;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/27 20:50
 */

public class UniquePathsII {
    public static void main(String[] args) {
        Solution solution = new UniquePathsII().new Solution();
        int[][] a = new int[7][3];
        System.out.println(solution.uniquePathsWithObstacles(a));
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rowLen = obstacleGrid.length;
            int colLen = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[rowLen - 1][colLen - 1] == 1)
                return 0;
            int[][] dp = new int[rowLen + 1][colLen + 1];
            dp[1][1] = 1;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i + 1][j + 1] = 0;
                        continue;
                    }
                    if (!(i == 0 && j == 0)) {
                        dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
                    }
                }
            }
            return dp[rowLen][colLen];
        }
    }
}
