package leeCode.medium;

public class CountNumbersUniqueDigits {
    public static void main(String[] args) {
        Solution s = new CountNumbersUniqueDigits().new Solution();
        int n = 2;
        System.out.println(s.countNumbersWithUniqueDigits(2));
    }

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0)
                return 1;
            if (n > 10)
                return 0;
            int re = 0;
            int[] dp = new int[n + 1];
            dp[0] = 10;

            for (int i = 0; i < n; i++) {
                re = 9;
                if (i == 0)
                    re = 0;
                int j = 0;
                while (j < i) {
                    re *= (9 - j);
                    j++;
                }
            }
            return dp[n];
        }
    }
}
