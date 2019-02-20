package leeCode.medium;

import java.util.HashMap;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/11 16:36
 */

public class Integer2Roman {
    public static void main(String[] args) {
        Solution s = new Integer2Roman().new Solution();
        System.out.println(s.intToRoman2(3));
    }

    class Solution {
        public String intToRoman(int num) {
            HashMap<Integer, String> map = new HashMap<Integer, String>();
            map.put(1, "I");
            map.put(5, "V");
            map.put(10, "X");
            map.put(50, "L");
            map.put(100, "C");
            map.put(500, "D");
            map.put(1000, "M");
            map.put(4, "IV");
            map.put(9, "IX");
            map.put(40, "XL");
            map.put(90, "XC");
            map.put(400, "CD");
            map.put(900, "CM");
            int index = 0;
            String re = "";
            while (num != 0) {
                int n = num % 10 * (int) Math.pow(10, index);
                String r = map.getOrDefault(n, "");
                if (r.equals("")) {
                    if (n < 5 * Math.pow(10, index)) {
                        for (int i = 0; i < num % 10; i++) {
                            re = map.get((int) Math.pow(10, index)) + re;
                        }
                    } else {

                        for (int i = 0; i < num % 10 - 5; i++) {

                            re = map.get((int) Math.pow(10, index)) + re;
                        }
                        re = map.get(5 * (int) Math.pow(10, index)) + re;
                    }
                } else {
                    re = r + re;
                }
                num /= 10;
                index++;
            }
            return re;
        }

        public String intToRoman2(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    sb.append(strs[i]);
                }
            }
            return sb.toString();
        }
    }
}
