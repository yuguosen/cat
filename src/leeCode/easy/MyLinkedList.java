package leeCode.easy;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by yu on 2018/7/26.
 */
class MyLinkedList {
    class ListNode {
        Integer val;
        ListNode next;
        ListNode prev;

        public ListNode(Integer val) {
            this.val = val;
        }

    }

    private Integer length;
    private ListNode head;
    private ListNode tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        length = 0;
        head = null;
        tail = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Integer re = -1;
        if (index < 0 || index >= length)
            return re;
        else {
            if (index == (length - 1))
                re = tail.val;
            else {
                ListNode ln = head;
                for (int i = 1; i <= index; i++) {
                    ln = ln.next;
                }
                re = ln.val;
            }
            return re;

        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            ListNode oldHead = head;
            ListNode newHead = new ListNode(val);
            head = newHead;
            head.next = oldHead;
            head.prev = null;
            oldHead.prev = head;
        }
        length += 1;

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (tail == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            ListNode oldTail = tail;
            ListNode newTail = new ListNode(val);
            tail = newTail;
            tail.prev = oldTail;
            oldTail.next = tail;
            tail.next = null;
        }

        length += 1;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= length) {
            if (index == 0)
                addAtHead(val);
            else if (index == length)
                addAtTail(val);
            else {
                ListNode ln = new ListNode(val);
                ListNode find = head;
                for (int i = 1; i <= index; i++) {
                    find = find.next;
                }
                find.prev.next = ln;
                ln.prev = find.prev;
                ln.next = find;
                find.prev = ln;
                length += 1;
            }

        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length) {
            if (index == 0) {
                head = head.next;
                head.prev = null;
            } else if (index == (length - 1)) {
                tail = tail.prev;
                tail.next = null;
            } else {
                ListNode find = head;
                for (int i = 1; i <= index; i++) {
                    find = find.next;
                }
                find.prev.next = find.next;
                find.next.prev = find.prev;

            }
            length -= 1;
        }

    }

    public String getAll() {
        String s = "";
        if (head != null) {
            ListNode ln = head;

            while (ln != null) {
                s += ln.val + "->";
                ln=ln.next;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(56);
        System.out.println("After addAtHead(56),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(1):" + linkedList.get(1));
        System.out.println("After get(1),re is:" + linkedList.getAll());
        linkedList.addAtHead(41);
        System.out.println("After addAtHead(41),re is:" + linkedList.getAll());
        linkedList.addAtTail(98);
        System.out.println("After addAtTail(98),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(3):" + linkedList.get(3));
        System.out.println("After get(3),re is:" + linkedList.getAll());
        linkedList.addAtIndex(1, 33);
        System.out.println("After addAtIndex(1,33),re is:" + linkedList.getAll());
        linkedList.addAtHead(72);
        System.out.println("After addAtHead(72),re is:" + linkedList.getAll());
        linkedList.addAtHead(52);
        System.out.println("After addAtHead(52),re is:" + linkedList.getAll());
        linkedList.addAtHead(89);
        System.out.println("After addAtHead(89),re is:" + linkedList.getAll());
        linkedList.addAtHead(0);
        System.out.println("After addAtHead(0),re is:" + linkedList.getAll());
        linkedList.addAtHead(98);
        System.out.println("After addAtHead(98),re is:" + linkedList.getAll());
        linkedList.addAtIndex(7, 97);
        System.out.println("After addAtIndex(7,97),re is:" + linkedList.getAll());
        linkedList.addAtIndex(2, 51);
        System.out.println("After addAtIndex(2,51),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(1):" + linkedList.get(1));
        System.out.println("After get(1),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(6):" + linkedList.get(6));
        System.out.println("After get(6),re is:" + linkedList.getAll());
        linkedList.addAtIndex(6, 49);
        System.out.println("After addAtIndex(6,49),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(8):" + linkedList.get(8));
        System.out.println("After get(8),re is:" + linkedList.getAll());
        linkedList.addAtHead(72);
        System.out.println("After addAtHead(72),re is:" + linkedList.getAll());
        linkedList.addAtIndex(7, 8);
        System.out.println("After addAtIndex(7,8),re is:" + linkedList.getAll());
        linkedList.addAtIndex(8, 58);
        System.out.println("After addAtIndex(8,58),re is:" + linkedList.getAll());
        linkedList.addAtHead(10);
        System.out.println("After addAtHead(10),re is:" + linkedList.getAll());
        linkedList.addAtIndex(3, 6);
        System.out.println("After addAtIndex(3,6),re is:" + linkedList.getAll());
        linkedList.addAtIndex(9, 61);
        System.out.println("After addAtIndex(9,61),re is:" + linkedList.getAll());
        linkedList.addAtHead(63);
        System.out.println("After addAtHead(63),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(16):" + linkedList.get(16));
        System.out.println("After get(16),re is:" + linkedList.getAll());
        linkedList.deleteAtIndex(7);
        System.out.println("After deleteAtIndex(7),re is:" + linkedList.getAll());
        linkedList.addAtIndex(16, 55);
        System.out.println("After addAtIndex(16,55),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(4):" + linkedList.get(4));
        System.out.println("After get(4),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(10):" + linkedList.get(10));
        System.out.println("After get(10),re is:" + linkedList.getAll());
        linkedList.deleteAtIndex(6);
        System.out.println("After deleteAtIndex(6),re is:" + linkedList.getAll());
        linkedList.addAtTail(96);
        System.out.println("After addAtTail(96),re is:" + linkedList.getAll());
        linkedList.addAtHead(69);
        System.out.println("After addAtHead(69),re is:" + linkedList.getAll());
        linkedList.addAtTail(20);
        System.out.println("After addAtTail(20),re is:" + linkedList.getAll());
        linkedList.addAtHead(3);
        System.out.println("After addAtHead(3),re is:" + linkedList.getAll());
        linkedList.addAtTail(44);
        System.out.println("After addAtTail(44),re is:" + linkedList.getAll());
        linkedList.addAtTail(4);
        System.out.println("After addAtTail(4),re is:" + linkedList.getAll());
        linkedList.addAtIndex(8, 16);
        System.out.println("After addAtIndex(8,16),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(15):" + linkedList.get(15));
        System.out.println("After get(15),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(21):" + linkedList.get(21));
        System.out.println("After get(21),re is:" + linkedList.getAll());
        linkedList.addAtHead(41);
        System.out.println("After addAtHead(41),re is:" + linkedList.getAll());
        linkedList.deleteAtIndex(1);
        System.out.println("After deleteAtIndex(1),re is:" + linkedList.getAll());
        linkedList.deleteAtIndex(11);
        System.out.println("After deleteAtIndex(11),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(21):" + linkedList.get(21));
        System.out.println("After get(21),re is:" + linkedList.getAll());
        linkedList.deleteAtIndex(22);
        System.out.println("After deleteAtIndex(22),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(2):" + linkedList.get(2));
        System.out.println("After get(2),re is:" + linkedList.getAll());
        linkedList.addAtIndex(5, 7);
        System.out.println("After addAtIndex(5,7),re is:" + linkedList.getAll());
        linkedList.addAtTail(62);
        System.out.println("After addAtTail(62),re is:" + linkedList.getAll());
        linkedList.addAtHead(95);
        System.out.println("After addAtHead(95),re is:" + linkedList.getAll());
        linkedList.addAtTail(91);
        System.out.println("After addAtTail(91),re is:" + linkedList.getAll());
        linkedList.addAtHead(69);
        System.out.println("After addAtHead(69),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(24):" + linkedList.get(24));
        System.out.println("After get(24),re is:" + linkedList.getAll());
        linkedList.addAtTail(51);
        System.out.println("After addAtTail(51),re is:" + linkedList.getAll());
        linkedList.addAtTail(94);
        System.out.println("After addAtTail(94),re is:" + linkedList.getAll());
        linkedList.addAtHead(93);
        System.out.println("After addAtHead(93),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(29):" + linkedList.get(29));
        System.out.println("After get(29),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(10):" + linkedList.get(10));
        System.out.println("After get(10),re is:" + linkedList.getAll());
        linkedList.addAtHead(68);
        System.out.println("After addAtHead(68),re is:" + linkedList.getAll());
        linkedList.addAtHead(13);
        System.out.println("After addAtHead(13),re is:" + linkedList.getAll());
        linkedList.addAtIndex(32, 42);
        System.out.println("After addAtIndex(32,42),re is:" + linkedList.getAll());
        linkedList.addAtHead(48);
        System.out.println("After addAtHead(48),re is:" + linkedList.getAll());
        linkedList.addAtHead(55);
        System.out.println("After addAtHead(55),re is:" + linkedList.getAll());
        linkedList.addAtHead(79);
        System.out.println("After addAtHead(79),re is:" + linkedList.getAll());
        linkedList.addAtHead(5);
        System.out.println("After addAtHead(5),re is:" + linkedList.getAll());
        linkedList.addAtHead(36);
        System.out.println("After addAtHead(36),re is:" + linkedList.getAll());
        linkedList.addAtTail(32);
        System.out.println("After addAtTail(32),re is:" + linkedList.getAll());
        linkedList.addAtIndex(25, 40);
        System.out.println("After addAtIndex(25,40),re is:" + linkedList.getAll());
        linkedList.addAtHead(8);
        System.out.println("After addAtHead(8),re is:" + linkedList.getAll());
        linkedList.addAtTail(68);
        System.out.println("After addAtTail(68),re is:" + linkedList.getAll());
        linkedList.deleteAtIndex(30);
        System.out.println("After deleteAtIndex(30),re is:" + linkedList.getAll());
        linkedList.addAtHead(66);
        System.out.println("After addAtHead(66),re is:" + linkedList.getAll());
        linkedList.addAtHead(92);
        System.out.println("After addAtHead(92),re is:" + linkedList.getAll());
        linkedList.addAtIndex(27, 26);
        System.out.println("After addAtIndex(27,26),re is:" + linkedList.getAll());
        linkedList.addAtTail(90);
        System.out.println("After addAtTail(90),re is:" + linkedList.getAll());
        linkedList.addAtIndex(11, 19);
        System.out.println("After addAtIndex(11,19),re is:" + linkedList.getAll());
        linkedList.addAtTail(68);
        System.out.println("After addAtTail(68),re is:" + linkedList.getAll());
        linkedList.addAtIndex(17, 62);
        System.out.println("After addAtIndex(17,62),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(15):" + linkedList.get(15));
        System.out.println("After get(15),re is:" + linkedList.getAll());
        linkedList.addAtIndex(17, 97);
        System.out.println("After addAtIndex(17,97),re is:" + linkedList.getAll());
        linkedList.addAtIndex(35, 89);
        System.out.println("After addAtIndex(35,89),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(44):" + linkedList.get(44));
        System.out.println("After get(44),re is:" + linkedList.getAll());
        linkedList.addAtTail(90);
        System.out.println("After addAtTail(90),re is:" + linkedList.getAll());
        linkedList.addAtTail(67);
        System.out.println("After addAtTail(67),re is:" + linkedList.getAll());
        linkedList.addAtHead(2);
        System.out.println("After addAtHead(2),re is:" + linkedList.getAll());
        linkedList.addAtHead(51);
        System.out.println("After addAtHead(51),re is:" + linkedList.getAll());
        linkedList.addAtHead(30);
        System.out.println("After addAtHead(30),re is:" + linkedList.getAll());
        linkedList.deleteAtIndex(38);
        System.out.println("After deleteAtIndex(38),re is:" + linkedList.getAll());
        linkedList.addAtHead(30);
        System.out.println("After addAtHead(30),re is:" + linkedList.getAll());
        linkedList.addAtTail(43);
        System.out.println("After addAtTail(43),re is:" + linkedList.getAll());
        linkedList.addAtTail(76);
        System.out.println("After addAtTail(76),re is:" + linkedList.getAll());
        linkedList.addAtTail(16);
        System.out.println("After addAtTail(16),re is:" + linkedList.getAll());
        linkedList.addAtTail(38);
        System.out.println("After addAtTail(38),re is:" + linkedList.getAll());
        linkedList.addAtHead(82);
        System.out.println("After addAtHead(82),re is:" + linkedList.getAll());
        linkedList.addAtHead(81);
        System.out.println("After addAtHead(81),re is:" + linkedList.getAll());
        linkedList.addAtTail(67);
        System.out.println("After addAtTail(67),re is:" + linkedList.getAll());
        linkedList.addAtTail(67);
        System.out.println("After addAtTail(67),re is:" + linkedList.getAll());
        linkedList.addAtIndex(3, 16);
        System.out.println("After addAtIndex(3,16),re is:" + linkedList.getAll());
        System.out.println("linkedList.get(57):" + linkedList.get(57));
        System.out.println("After get(57),re is:" + linkedList.getAll());
        linkedList.addAtTail(94);
        System.out.println("After addAtTail(94),re is:" + linkedList.getAll());
        linkedList.addAtHead(11);
        System.out.println("After addAtHead(11),re is:" + linkedList.getAll());
        linkedList.addAtTail(31);
        System.out.println("After addAtTail(31),re is:" + linkedList.getAll());
        linkedList.addAtHead(50);
        System.out.println("After addAtHead(50),re is:" + linkedList.getAll());
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
