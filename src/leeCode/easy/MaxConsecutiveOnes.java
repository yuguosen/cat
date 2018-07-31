package leeCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yu on 2018/7/30.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution s = new MaxConsecutiveOnes().new Solution();
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        s.findMaxConsecutiveOnes(nums);
    }

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            if (nums == null) return 0;
            int max = 0;
            int cur = 0;
            for (int i = 0; i < nums.length; cur += nums[i], i++) {
                if (nums[i] == 0) {
                    max = Math.max(max, cur);
                    cur = 0;
                }
            }
            return Math.max(max, cur);
        }
    }
}
