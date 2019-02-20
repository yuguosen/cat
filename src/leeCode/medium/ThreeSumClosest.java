package leeCode.medium;

import java.util.Arrays;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/14 10:52
 */

public class ThreeSumClosest {
    public static void main(String[] args) {

        Solution s = new ThreeSumClosest().new Solution();
        int[] nums = {-1, 0, 1, 1, 55};
        int target = 3;
        System.out.println(s.threeSumClosest(nums, target));
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int cloest = Integer.MAX_VALUE;
            int re = cloest;
            for (int i = 0; i < nums.length - 2; i++) {
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (Math.abs(target - sum) < cloest ) {
                        re = sum;
                        cloest = Math.abs(target - sum);
                    }
                    if (Math.abs(target - (nums[i] + nums[start + 1] + nums[end])) <Math.abs(target - sum))
                        start++;
                    else
                        end--;

                }
            }
            return re;
        }
    }
}
