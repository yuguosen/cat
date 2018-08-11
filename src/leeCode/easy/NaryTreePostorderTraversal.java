package leeCode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yu on 2018/8/7.
 */
public class NaryTreePostorderTraversal {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    class Solution {
        List<Integer> re;

        public List<Integer> postorder(Node root) {
            re = new ArrayList<>();
            //recursive(root);
            iteratively(root);
            return re;
        }

        public void recursive(Node root) {
            if (root == null) return;
            for (Node node : root.children)
                recursive(node);
            re.add(root.val);

        }

        public void iteratively(Node root) {
            if (root == null) return;
            Stack<Node> nodes = new Stack<>();
            Stack<Integer> stack = new Stack<>();
            nodes.push(root);
            while (!nodes.isEmpty()) {
                root = nodes.pop();
                stack.push(root.val);
                for (Node node : root.children) {
                    nodes.push(node);
                }

            }
            while (!stack.isEmpty()) {
                re.add(stack.pop());
            }
        }
    }
}
