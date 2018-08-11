package leeCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2018/8/3.
 */
public class LinkedListComponents {
    public static void main(String[] args) {
        Solution s=new LinkedListComponents().new Solution();
        ListNode head=new LinkedListComponents().new ListNode(0);
        ListNode node1=new LinkedListComponents().new ListNode(1);
        ListNode node2=new LinkedListComponents().new ListNode(2);
        ListNode node3=new LinkedListComponents().new ListNode(3);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        int [] G=new int[]{0, 1, 3};
        System.out.println(s.numComponents(head,G));
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int numComponents(ListNode head, int[] G) {
            Map<Integer, Integer> data = new HashMap<>();
            ListNode ln = head;
            while (ln.next != null) {
                data.put(ln.val, ln.next.val);
                ln = ln.next;
            }
            int count=0;
            for (Map.Entry<Integer,Integer>set:data.entrySet()){
                int key= set.getKey();
                int val= set.getValue();
                int keyIndex= Arrays.binarySearch(G,key);
                int valIndex= Arrays.binarySearch(G,val);
                if(keyIndex>-1 && valIndex>-1)
                    count+=1;
            }
            return count;
        }
    }
}
