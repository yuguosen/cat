package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/10 9:45
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution s = new SearchInsertPosition().new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(s.searchInsert2(nums, target));
    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int i = 0;
            for (; i < nums.length; i++) {
                if (nums[i] >= target)
                    return i;
            }
            return i;
        }

        public int searchInsert2(int[] nums, int target) {
            int low = 0;
            int high = nums.length-1;
            while (low <= high) {
                int mid = (high - low) / 2;
                if (nums[mid] == target)
                    return mid;
                if (nums[mid] > target)
                    high = mid - 1;
                if (nums[mid] < target)
                    low = mid + 1;
            }
            return low;
        }
    }
}
