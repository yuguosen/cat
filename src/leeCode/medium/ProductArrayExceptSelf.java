package leeCode.medium;

/**
 * Created by yu on 2018/8/1.
 */
public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        Solution s=new ProductArrayExceptSelf().new Solution();
        int [] nums=new int[]{1,2,3,4};
        s.productExceptSelf(nums);
    }
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }
    }
}
