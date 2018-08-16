package leeCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by yu on 2018/8/13.
 */
public class Triangle {
    public static void main(String[] args) {
        Solution s = new Triangle().new Solution();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(6);
        l3.add(7);

        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);
        System.out.println(s.minimumTotal2(triangle));
    }

    class Solution {
        //自下而上
        public int minimumTotal(List<List<Integer>> triangle) {
            int rowLen = triangle.size();
            int colLen = triangle.get(rowLen - 1).size();
            int[][] dp = new int[rowLen + 1][colLen + 1];
            for (int i = rowLen - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }

        //自上而下
        public int minimumTotal2(List<List<Integer>> triangle) {
            int rowLen = triangle.size();
            int colLen = triangle.get(rowLen - 1).size();
            int[][] dp = new int[rowLen + 1][colLen + 1];
            
            for (int i = 1; i <= rowLen; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + triangle.get(i-1).get(j);
                }
            }
            return IntStream.of(dp[rowLen]).min().getAsInt();
        }
    }
}
