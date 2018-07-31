package leeCode.easy;

/**
 * Created by yu on 2018/7/26.
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution s = new BinarySearch().new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(s.search(nums, target));
    }

    class Solution {
        public int search(int[] nums, int target) {
            int re = -1;
            if (nums == null)
                return -1;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    re = mid;
                    break;
                } else if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return re;
        }
    }
}
