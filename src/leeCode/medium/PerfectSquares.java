package leeCode.medium;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution s = new PerfectSquares().new Solution();
        int n = 13;
        System.out.println(s.numSquares(n));
    }

    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                int j = 1;
                while (i >= j * j) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    j++;
                }
            }
            return dp[n];
        }
    }
}
