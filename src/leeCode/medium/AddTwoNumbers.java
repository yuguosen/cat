package leeCode.medium;

import java.util.*;

    public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution s=new AddTwoNumbers().new Solution();
        ListNode l1=new AddTwoNumbers().new  ListNode(1);
        ListNode l2=new AddTwoNumbers().new  ListNode(8);
        ListNode l3=new AddTwoNumbers().new  ListNode(0);
        ListNode l4=new AddTwoNumbers().new  ListNode(5);
        ListNode l5=new AddTwoNumbers().new  ListNode(6);
        ListNode l6=new AddTwoNumbers().new  ListNode(4);
        ListNode l7=new AddTwoNumbers().new  ListNode(9);
        ListNode l8=new AddTwoNumbers().new  ListNode(9);
        ListNode l9=new AddTwoNumbers().new  ListNode(9);
        ListNode l10=new AddTwoNumbers().new  ListNode(9);
        l1.next=l2;
        //l2.next=l3;
        //l3.next=l4;
        //l4.next=l5;
        //l5.next=l6;
        //l6.next=l7;
//        l7.next=l8;
//        l8.next=l9;
//        l9.next=l10;

        s.addTwoNumbers(l1,l3);
    }
    // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int pre=0;
            ListNode root=new ListNode(0);
            ListNode node=root;
            while (l1!=null||l2!=null){
                int num1=0;
                int num2=0;
                if (l1!=null) {
                    num1 = l1.val;
                    l1= l1.next;
                }
                if (l2!=null) {
                    num2 = l2.val;
                    l2=l2.next;
                }
                int num=(num1+num2+pre)%10;
                pre=(num1+num2+pre)/10;
                node.next=new ListNode(num);
                node=node.next;
            }
            if (pre>0)
                node.next=new ListNode(pre);

            return root.next;
        }
    }
}
