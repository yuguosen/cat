package leeCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2018/8/10.
 */
public class MinimumASCIIDeleteSumTwoStrings {
    public static void main(String[] args) {
        Solution s = new MinimumASCIIDeleteSumTwoStrings().new Solution();
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(s.minimumDeleteSum(s1, s2));
    }

    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            int m = ch1.length;
            int n = ch2.length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i=0;i<=m;i++){
                for (int j=0;j<=n;j++){
                    if(i==0 && j==0)
                        dp[i][j]=0;
                    else  if (i==0)
                        dp[i][j]=ch2[j-1]+dp[i][j-1];
                    else if(j==0)
                        dp[i][j]=ch1[i-1]+dp[i-1][j];
                    else  if(ch1[i-1]==ch2[j-1])
                        dp[i][j]=dp[i-1][j-1];
                    else
                        dp[i][j]=Math.min(ch1[i-1]+dp[i-1][j],ch2[j-1]+dp[i][j-1]);
                }
            }
            return dp[m][n];
        }
    }
}
