package leeCode.medium;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/27 20:02
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution s=new LongestPalindromicSubstring().new Solution();
        String ss="ac";
        System.out.println(s.longestPalindrome(ss));
    }
    class Solution {
        int maxLen;
        int maxLenStart;

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s;
            for (int i = 0; i < len-1; i++) {
                findData(s,i,i);
                findData(s,i,i+1);
            }
            return s.substring(maxLenStart,maxLen+maxLenStart);
        }

        public void findData(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left - 1) {
                maxLen = right - left - 1;
                maxLenStart = left+1;
            }
        }
    }
}
