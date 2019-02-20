package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/11 11:15
 */

public class LengthofLastWord {
    public static void main(String[] args) {
        Solution solution=new LengthofLastWord().new Solution();
        String words="Hello World";
        System.out.println(solution.lengthOfLastWord(words));
    }

    class Solution {
        public int lengthOfLastWord(String s) {
            if (s.trim().equals(""))
                return 0;
            s = s.trim();
            int re = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'z')
                    re++;
                else
                    return re;
            }
            return re;
        }
    }
}
