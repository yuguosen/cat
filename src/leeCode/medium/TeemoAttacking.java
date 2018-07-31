package leeCode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Created by yu on 2018/7/31.
 */
public class TeemoAttacking {
    public static void main(String[] args) {
        Solution s = new TeemoAttacking().new Solution();
        int[] nums = new int[]{1, 2};
        int duration = 2;
        System.out.println(s.findPoisonedDuration(new int[3], duration));
    }

    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries == null )
                return 0;
            int re = duration;
            for (int i = 1; i < timeSeries.length; i++) {
                re += duration - Math.max(0, duration - (timeSeries[i] - timeSeries[i - 1]));
            }
            return re;
        }
    }
}
