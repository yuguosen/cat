package leeCode.medium;

import java.util.Queue;
import java.util.Stack;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/10 15:32
 */

public class String2Integer {
    public static void main(String[] args) {

        Solution s = new String2Integer().new Solution();
        System.out.println(s.myAtoi("+0 123"));
    }

    class Solution {
        public int myAtoi(String str) {
            if (str == null)
                return 0;
            str = str.trim();
            if (str.equals(""))
                return 0;
            if (!((str.charAt(0) > '0' && str.charAt(0) <= '9') || str.charAt(0) == '-' || str.charAt(0) == '+'))
                return 0;
            int re = 0;
            int reLast = 0;
            str = str.replace(" ", "");
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9')
                re += str.charAt(0) - '0';
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(1)=='0')
                    return 0;
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    reLast = re;
                    re = re * 10 + (str.charAt(i) - '0');
                    if ((re - (str.charAt(i) - '0')) / 10 != reLast) {
                        if (str.charAt(0) == '-')
                            return Integer.MIN_VALUE;
                        else
                            return Integer.MAX_VALUE;
                    }
                } else
                    break;
            }

            if (str.charAt(0) == '-')
                re = 0 - re;
            return re;
        }
    }
}
