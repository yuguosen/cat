package leeCode.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/3 11:19
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
//            if (s.length() == 1)
//                return 1;
//            int max = 0;
//            for (int i = 0; i < s.length(); i++) {
//                HashSet<Character> set = new HashSet<>();
//                set.add(s.charAt(i));
//                for (int j = i + 1; j < s.length(); j++) {
//                    if (!set.contains(s.charAt(j))) {
//                        set.add(s.charAt(j));
//                    } else {
//
//                        break;
//                    }
//                }
//                max = Math.max(max, set.size());
//            }
//            return max;
            int max = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    j = Math.max(j, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);

                max = Math.max(max, i - j + 1);
            }

            return max;
        }
    }
}
