package leeCode.easy;

/**
 * Created by yu on 2018/7/31.
 */
public class AddDigits {
    public static void main(String[] args) {
        Solution s=new  AddDigits().new Solution();
        System.out.println(s.addDigits(38));
    }
    class Solution {
        public int addDigits(int num) {
            if (num >= 0 && num <= 9)
                return num;
            else {
                int re = 0;
                do {
                    re += num % 10;
                    num = num / 10;
                } while (num != 0);
                num=addDigits(re);
                return num;
            }

        }
    }
}
