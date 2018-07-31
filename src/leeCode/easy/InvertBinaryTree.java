package leeCode.easy;

/**
 * Created by yu on 2018/7/30.
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode t = new InvertBinaryTree().new TreeNode(1);
        t.left = new InvertBinaryTree().new TreeNode(2);
        t.right = new InvertBinaryTree().new TreeNode(3);
        Solution s = new InvertBinaryTree().new Solution();
        TreeNode ss = s.invertTree(t);
        System.out.println();
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return null;

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
