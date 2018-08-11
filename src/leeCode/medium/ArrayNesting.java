package leeCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yu on 2018/8/6.
 */
public class ArrayNesting {
    public static void main(String[] args) {
        Solution s = new ArrayNesting().new Solution();
        int[] nums = new int[]{0, 2, 1};
        System.out.println(s.arrayNesting(nums));
    }

    class Solution {
        public int arrayNesting(int[] nums) {
            boolean[] visited = new boolean[nums.length];
            int[] numCount = new int[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    int start = nums[i];
                    int count = 0;
                    do {
                        count++;
                        start = nums[start];
                        visited[start] = true;
                    } while (start != nums[i] || numCount[start] > 0);
                    count = count + numCount[start];
                    numCount[i] = count;
                    max = Math.max(count, max);
                }
            }
            return max;
        }
    }
}
