package leeCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yu on 2018/7/31.
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution s = new LetterCasePermutation().new Solution();

        List<String> l = s.letterCasePermutation("a1b2");
        for (String ss : l) {
            System.out.println(ss);
        }
    }

    class Solution {
        public List<String> letterCasePermutation(String S) {
            char[] characters = S.toLowerCase().toCharArray();
            return changeLetter(characters, 0, new ArrayList<String>());
        }

        public List<String> changeLetter(char[] characters, int index, List<String> list) {
            if (index == characters.length)
                list.add(new String(characters));
            else {
                if (Character.isLetter(characters[index])) {
                    characters[index] = Character.toLowerCase(characters[index]);
                    changeLetter(characters, index + 1, list);
                    characters[index] = Character.toUpperCase(characters[index]);
                }
                changeLetter(characters, index + 1, list);
            }

            return list;
        }
    }
}
