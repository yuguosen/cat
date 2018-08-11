package leeCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yu on 2018/8/2.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution s = new MoveZeroes().new Solution();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        s.moveZeroes(nums);
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int startZeroIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    startZeroIndex = i;
                    break;
                }
            }
            if (startZeroIndex == -1 || startZeroIndex == nums.length - 1) return;
            for (int i = startZeroIndex; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[startZeroIndex++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}
