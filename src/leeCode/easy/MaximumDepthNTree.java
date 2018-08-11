package leeCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yu on 2018/8/2.
 */
public class MaximumDepthNTree {
    public static void main(String[] args) {
        Solution s=new MaximumDepthNTree().new Solution();

        Node node5=new MaximumDepthNTree().new Node(5,null);
        Node node6=new MaximumDepthNTree().new Node(6,null);
        List<Node> list=new ArrayList<>();
        list.add(node5);
        list.add(node6);
        Node node3=new MaximumDepthNTree().new Node(3,list);
        List<Node> list2=new ArrayList<>();
        Node node2=new MaximumDepthNTree().new Node(2,null);
        Node node4=new MaximumDepthNTree().new Node(4,null);
        list2.add(node2);
        list2.add(node3);
        list2.add(node4);
        Node root=new MaximumDepthNTree().new Node(1,list2);
        System.out.println(s.maxDepth(root));
    }

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
        public int maxDepth(Node root) {
            int max=1;
            if (root == null)
                return 0;
            for (Node node : root.children) {
                max=Math.max(maxDepth(node)+1,max);
            }
            return max;
        }

    }
}
