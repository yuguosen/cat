package leeCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/11 17:34
 */

public class ThreeNum {
    public static void main(String[] args) {
        Solution solution = new ThreeNum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> re = solution.threeSum(nums);
        for (List<Integer> list : re) {
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println("\n");
        }
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> re = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    int start = i + 1, end = nums.length - 1, sum = 0 - nums[i];
                    while (start < end) {
                        if (nums[start] + nums[end] == sum) {
                            re.add(Arrays.asList(nums[i], nums[start], nums[end]));
                            while (start < end && nums[start] == nums[start + 1]) start++;
                            while (start < end && nums[end] == nums[end - 1]) end--;
                            start++;
                            end--;
                        } else if (nums[start] + nums[end] < sum) start++;
                        else end--;
                    }
                }
            }
            return re;
        }
    }
}
