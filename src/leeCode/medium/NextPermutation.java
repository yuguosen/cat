package leeCode.medium;

import java.util.Arrays;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/11 15:58
 */

public class NextPermutation {
    public static void main(String[] args) {
        Solution s=new NextPermutation().new Solution();
        int [] nums=new int[]{1,1,5};
        s.nextPermutation(nums);
        for (int i:nums)
            System.out.println(i);
    }

    class Solution {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    int p = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = p;
                    return;
                }
            }
            Arrays.sort(nums);
        }
    }
}
