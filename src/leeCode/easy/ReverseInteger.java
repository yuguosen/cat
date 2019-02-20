package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/30 17:31
 */

public class ReverseInteger {
    public static void main(String[] args) {
        Solution s = new ReverseInteger().new Solution();
        System.out.println(s.reverse(-2147483648));
        System.out.println(-31 % 10);
    }

    class Solution {
        public int reverse(int x) {
            int re = 0;
            while (x != 0) {
                int tail = x % 10;
                int newResult = re * 10 + tail;
                if ((newResult - tail) / 10 != re)
                    return 0;
                re = newResult;
                x = x / 10;
            }
            return re;
        }
    }
}
