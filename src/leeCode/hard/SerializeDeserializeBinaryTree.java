package leeCode.hard;

import java.util.*;

/**
 * Created by yu on 2018/8/2.
 */
public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec c = new SerializeDeserializeBinaryTree().new Codec();
        String data = "[5,2,3,null,null,2,4,3,1]";
        System.out.println(data);
        TreeNode t = c.deserialize(data);
        //System.out.println(t);
        System.out.println(c.serialize(t));
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {


        // Encodes a tree to a single string.
        List<String> re = new ArrayList<>();

        public String serialize(TreeNode root) {
            List<String> re = new ArrayList<>();
            buildString(root, re);

            for (int i = re.size() - 1; i >= 0; i--) {
                if (re.get(i).equals("null"))
                    re.remove(i);
                else
                    break;
            }
            String data = "[" + String.join(",", re) + "]";
            return data;
        }

        public void buildString(TreeNode root, List<String> re) {
            if (root == null) {
                re.add("null");

            } else {
                re.add(root.val + "");

                buildString(root.left, re);
                buildString(root.right, re);
            }

        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.replaceAll("\\[", "").replaceAll("\\]", "").trim();
            if (data.equals("")) return null;
            String[] treeData = data.split(",");
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(treeData));
            return createNode(nodes);
        }

        public TreeNode createNode(Deque<String> nodes) {
            if (nodes.isEmpty()) return null;
            String p = nodes.remove();
            if (p.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(p));
            root.left = createNode(nodes);
            root.right = createNode(nodes);
            return root;
        }

    }
}
