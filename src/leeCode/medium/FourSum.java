package leeCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/14 14:45
 */

public class FourSum {
    public static void main(String[] args) {
        Solution s = new FourSum().new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> re = s.fourSum(nums, target);
        for (List<Integer> list : re) {
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println("\n");
        }
    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return kSum(nums, 4, 0, target);
        }

        public List<List<Integer>> kSum(int[] nums, int k, int start, int target) {
            List<List<Integer>> re = new ArrayList<>();
            int len = nums.length;
            if (k == 2) {
                int left = start, right = len - 1;

                while (left < right) {
                    List<Integer> path = new ArrayList<>();
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        path.add(nums[left]);
                        path.add(nums[right]);
                        re.add(path);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            } else {
                for (int i = start; i <  len - (k - 1); i++) {
                    if (i > start && nums[i] == nums[i - 1]) continue;
                    List<List<Integer>> tmp = kSum(nums, k - 1, i + 1, target - nums[i]);
                    for (List<Integer> t : tmp)
                        t.add(0, nums[i]);
                    re.addAll(tmp);
                }

            }
            return re;
        }
    }
}
