package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/11 11:21
 */

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] digits = new int[]{1, 2, 3};
        int[] re = solution.plusOne(digits);
        for (int i : re)
            System.out.println(i);
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            digits[len - 1] = digits[len - 1] + 1;
            for (int i = digits.length - 1; i > 0; i--) {
                if (digits[i] == 10) {
                    digits[i - 1] = digits[i - 1] + 1;
                    digits[i] = 0;
                }
            }
            if (digits[0] == 10) {
                int[] re = new int[len + 1];
                re[0]=1;
                return re;
            } else return digits;
        }
    }
}
