package leeCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/10 14:17
 */

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        Solution s = new LetterCombinationsofaPhoneNumber().new Solution();
        String digits = "27";
        List<String> re = s.letterCombinations(digits);
        for (String ss : re) {
            System.out.println(ss);
        }
    }

    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.equals(""))
                return new ArrayList<>();
            int len = 1;
            for (int i = 0; i < digits.length(); i++) {
                if (digits.charAt(i) == '7' || digits.charAt(i) == '9') len *= 4;
                else len *= 3;
            }
            String[] arr = new String[len];
            len = 1;
            for (int i = 0; i < arr.length; i++) arr[i] = "";
            for (int i = 0; i < digits.length(); i++) {
                int c = digits.charAt(i) - '0';
                switch (c) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        char first = (char) ((c - 2) * 3 + 'a');
                        char sec = (char) ((c - 2) * 3 + 'b');
                        char third = (char) ((c - 2) * 3 + 'c');
                        for (int j = 0; j < len; j++) {
                            arr[len + j * 2] = arr[j] + sec;
                            arr[len + j * 2 + 1] = arr[j] + third;
                            arr[j] = arr[j] + first;
                        }
                        len*=3;
                        break;
                    case 7:
                        for (int j = 0; j < len; j++) {
                            arr[len + j * 3] = arr[j] + 'q';
                            arr[len + j * 3 + 1] = arr[j] + 'r';
                            arr[len + j * 3 + 2] = arr[j] + 's';
                            arr[j] = arr[j] + 'p';
                        }
                        len*=4;
                        break;
                    case 8:
                        for (int j = 0; j < len; j++) {
                            arr[len + j * 2] = arr[j] + 'u';
                            arr[len + j * 2 + 1] = arr[j] + 'v';
                            arr[j] = arr[j] + 't';
                        }
                        len*=3;
                        break;
                    case 9:
                        for (int j = 0; j < len; j++) {
                            arr[len + j * 3] = arr[j] + 'x';
                            arr[len + j * 3 + 1] = arr[j] + 'y';
                            arr[len + j * 3 + 2] = arr[j] + 'z';
                            arr[j] = arr[j] + 'w';
                        }
                        len*=4;
                        break;
                }


            }
            return Arrays.asList(arr);
        }
    }
}
