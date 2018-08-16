package leeCode.hard;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(solution.numDistinct(s, t));
    }

    class Solution {
        //https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
        public int numDistinct(String s, String t) {
            int lens = s.length();
            int lent = t.length();
            int[][] dp = new int[lent + 1][lens + 1];
            for (int j = 0; j <= lens; j++)
                dp[0][j] = 1;
            for (int i = 0; i < lent; i++) {
                for (int j = 0; j < lens; j++) {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                    if (t.charAt(i) == s.charAt(j))
                        dp[i+1][j+1] += dp[i][j];
                }
            }
            return dp[lent][lens];
        }
    }
}
