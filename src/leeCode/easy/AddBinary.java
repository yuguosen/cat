package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/11 14:17
 */

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        String a = "1111";
        String b = "1111";
        System.out.println(solution.addBinary(a, b));
        System.out.println((char)1);
    }

    class Solution {
        public String addBinary(String a, String b) {
            int len1 = a.length();
            int len2 = b.length();
            int maxLen = Math.max(len1, len2);
            char[] char1 = a.toCharArray();
            char[] char2 = b.toCharArray();
            char[] arr = new char[maxLen+1];
            for (int i = 0; i < maxLen+1; i++)
                arr[i] = '0';
            for (int i = 0; i < maxLen; i++) {
                if (len1 - i >= 1) {
                    arr[maxLen - i] = (char) ((char1[len1 - i - 1] - '0') + (arr[maxLen - i] - '0') + '0');
                    if (arr[maxLen - i] == '2') {
                        arr[maxLen - i] = '0';
                        arr[maxLen - i - 1] = '1';
                    }
                }
                if (len2 - i >= 1) {
                    arr[maxLen - i] = (char) ((char2[len2 - i - 1] - '0') + (arr[maxLen - i] - '0') + '0');
                }
                if (arr[maxLen - i] == '2') {
                    arr[maxLen - i] = '0';
                    arr[maxLen - i - 1] = '1';
                }
            }
            if (arr[0] == '0')
                return new String(arr).substring(1);
            else return new String(arr);

        }
    }
}
