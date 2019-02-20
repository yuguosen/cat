package leeCode.easy;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/28 11:46
 */

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(4));
    }

    class Solution {
        public int climbStairs(int n) {
            if (n <= 2)
                return n;
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }
    }
}
