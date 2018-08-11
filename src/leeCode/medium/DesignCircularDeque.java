package leeCode.medium;

/**
 * Created by yu on 2018/8/3.
 */
public class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new DesignCircularDeque().new MyCircularDeque(5); // set the size to be 3
//        System.out.println(circularDeque.insertFront(7));
//        System.out.println(circularDeque.insertFront(6));
//        System.out.println(circularDeque.insertFront(5));
//        System.out.println(circularDeque.insertFront(5));
//        System.out.println(circularDeque.insertFront(5));
        System.out.println(circularDeque.insertLast(4));
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.insertLast(3));

//        System.out.println(circularDeque.insertLast(0));
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.insertLast(3));
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.insertFront(9));
//        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.deleteLast());
//        System.out.println(circularDeque.getRear());


    }

    class MyCircularDeque {
        int[] cDeque;
        final int CAPACITY;
        int size;
        int start;
        int end;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.CAPACITY = k;
            this.cDeque = new int[k];
            this.start = -1;
            this.end = -1;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            if (start < 0) {
                start++;
                end++;
            } else {
                start = (--start + CAPACITY) % CAPACITY;

            }

            cDeque[start] = value;
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            if (end < 0) {
                start++;
                end++;
            } else {
                end = ++end % CAPACITY;
            }
            System.out.println(end);
            cDeque[end] = value;
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            if (start == end) {
                start = -1;
                end = -1;
            } else {
                start = ++start % CAPACITY;
            }
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            if (start == end) {
                start = -1;
                end = -1;
            } else {
                end = (--end + CAPACITY) % CAPACITY;
            }
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) return -1;
            return cDeque[start];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) return -1;
            return cDeque[end];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == CAPACITY;
        }
    }

}
