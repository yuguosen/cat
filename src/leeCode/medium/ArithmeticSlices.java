package leeCode.medium;

import java.util.Arrays;

public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution s=new ArithmeticSlices().new Solution();
        int []A=new int[]{1, 2, 3, 4};
        System.out.println(s.numberOfArithmeticSlices(A));
    }
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            if (A.length < 3)
                return 0;
            int[] dp = new int[A.length];
            int re=0;
            for (int i = 1; i < A.length-1; i++) {
                if (A[i + 1] - A[i] == A[i] - A[i - 1]) {
                    dp[i + 1] = dp[i] + 1;
                    re+=dp[i+1];
                }
            }

            return re;
        }
    }
}
