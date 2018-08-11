package leeCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yu on 2018/8/1.
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution s = new BinaryTreeInorderTraversal().new Solution();
        TreeNode t = new BinaryTreeInorderTraversal().new TreeNode(1);
        TreeNode right = new BinaryTreeInorderTraversal().new TreeNode(2);
        right.left = new BinaryTreeInorderTraversal().new TreeNode(3);
        t.right = right;
        List<Integer> re = s.inorderTraversal(t);
        for (Integer i : re) {
            System.out.println(i);
        }
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null)
                return list;
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);

            return list;
        }
    }
}
