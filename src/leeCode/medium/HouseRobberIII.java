package leeCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yu on 2018/8/13.
 */
public class HouseRobberIII {
    public static void main(String[] args) {
        Solution s = new HouseRobberIII().new Solution();
        TreeNode root = new HouseRobberIII().new TreeNode(3);
        TreeNode node1 = new HouseRobberIII().new TreeNode(2);
        TreeNode node2 = new HouseRobberIII().new TreeNode(3);
        TreeNode node3 = new HouseRobberIII().new TreeNode(3);
        TreeNode node4 = new HouseRobberIII().new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(s.rob(root));
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int rob(TreeNode root) {
            int [] re=robSub(root);
            return Math.max(re[0],re[1]);
        }

        public int[] robSub(TreeNode root) {
            if (root == null)
                return new int[2];
            int[] maxVal = new int[2];
            int[] leftMax = robSub(root.left);
            int[] rightMax = robSub(root.right);

            //根节点不抢，那么左右节点抢和不抢都行，去max
            maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);

            //根节点抢，左右节点都不能抢
            maxVal[1] = leftMax[0] + rightMax[0] + root.val;
            return maxVal;

        }
    }
}
