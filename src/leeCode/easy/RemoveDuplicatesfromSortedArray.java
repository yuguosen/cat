package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/10 10:06
 */

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        Solution s=new RemoveDuplicatesfromSortedArray().new Solution();
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(s.removeDuplicates(nums));
    }
    class Solution {
        public int removeDuplicates(int[] nums) {
            int re=1;
            for (int i=1;i<nums.length;i++)
                if (nums[i]!=nums[i-1])nums[re++]=nums[i];
            return  re;
        }
    }
}
