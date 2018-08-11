package leeCode.hard;

import java.util.*;

/**
 * Created by yu on 2018/8/7.
 */
public class IPO {
    public static void main(String[] args) {
        Solution s = new IPO().new Solution();
        int k = 2;
        int W = 0;
        int[] Prfits = new int[]{1, 2, 3};
        int[] Capital = new int[]{0, 1, 1};
        System.out.println(s.findMaximizedCapital(k, W, Prfits, Capital));

    }

    class Solution {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
            for (int i = 0; i < Profits.length; i++)
                cap.add(new int[]{Profits[i], Capital[i]});
//            while (!cap.isEmpty())
//                System.out.println(cap.poll()[0]);
            for (int i = 0; i < k; i++) {
                List<int[]> list = new ArrayList<>();
                while (!cap.isEmpty()) {
                    if (cap.peek()[1] <= W) {
                        W += cap.poll()[0];
                        cap.addAll(list);
                        break;
                    }
                    list.add(cap.poll());
                }
            }

            return W;
        }
    }
}
