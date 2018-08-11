package leeCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2018/8/10.
 */
public class MinimumASCIIDeleteSumTwoStrings {
    public static void main(String[] args) {
        Solution s = new MinimumASCIIDeleteSumTwoStrings().new Solution();
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(s.minimumDeleteSum(s1, s2));
    }

    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            char[] shortStr = s1.toCharArray();
            char[] longStr = s2.toCharArray();
            if (s1.length() > s2.length()) {
                shortStr = s2.toCharArray();
                longStr = s1.toCharArray();
            }
            Map<Character, Integer> indexMark = new HashMap<>();
            int[] indexArr = new int[shortStr.length];

            for (int i = 0; i < shortStr.length; i++) {
                int startIndex = indexMark.getOrDefault(shortStr[i], -1) + 1;
                int index = Arrays.binarySearch(longStr, startIndex, longStr.length, shortStr[i]);
                if (index>=0)
                    indexMark.put(shortStr[i],index);
                indexArr[i] = index;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < indexArr.length; i++) {
                if (indexArr[i] > 0) {
                    int findIndexSum = 0;
                    for (int j = i + 1; j < shortStr.length; j++) {
                        if (indexArr[j] <= indexArr[i])
                            findIndexSum += shortStr[j];
                    }
                    min = Math.min(min, findIndexSum);
                }

            }
            return min;
        }
    }
}
