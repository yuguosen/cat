package leeCode.medium;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/27 14:34
 */

public class UniquePaths {
    public static void main(String[] args) {
        Solution s=new UniquePaths().new Solution();
        System.out.println(s.uniquePaths(7,3));
    }
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i=0;i<m;i++)
                for (int j=0;j<n;j++)
                    dp[i][j]=1;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
            return dp[m - 1][n - 1];
        }
    }
}
