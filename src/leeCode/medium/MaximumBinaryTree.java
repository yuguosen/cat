package leeCode.medium;

import java.util.Arrays;

/**
 * Created by yu on 2018/7/26.
 */
public class MaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums={3,2,1,6,0,5};
        Solution s=new MaximumBinaryTree().new Solution();
        TreeNode treeNode=s.constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int maxIndex = getMaxIndex(nums);
            TreeNode t = new TreeNode(nums[maxIndex]);
            if (nums.length > 1) {
                if (maxIndex>0){
                    int[] leftNums = Arrays.copyOfRange(nums, 0, maxIndex);
                    TreeNode left = constructMaximumBinaryTree(leftNums);
                    t.left = left;
                }
                if(0<=maxIndex && maxIndex<nums.length-1){
                    int[] rightNums = Arrays.copyOfRange(nums, maxIndex + 1, nums.length );
                    TreeNode right = constructMaximumBinaryTree(rightNums);
                    t.right = right;
                }


            }
            return t;

        }

        public int getMaxIndex(int[] nums) {
            if (nums.length == 0)
                return -1;
            if (nums.length == 1)
                return 0;

            int re = 0;
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    re = i;
                    max=nums[i];
                }
            }
            return re;
        }
    }
}
