package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/30 17:52
 */

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution s=new PalindromeNumber().new Solution();
        System.out.println(s.isPalindrome(121));
    }

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            String s = x + "";
            int re = 0;
            while (x != 0) {
                re = re * 10 + x % 10;
                x /= 10;
            }
            return s.equals(re + "");
        }
    }
}
