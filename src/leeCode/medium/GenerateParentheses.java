package leeCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/10 17:49
 */

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution s = new GenerateParentheses().new Solution();
        s.generateParenthesis(2);
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> re = new ArrayList<>();
            generateOneByOne("",n,n,re);
            return re;
        }

        public void generateOneByOne(String subList, int left, int right, List<String> re) {
            if (left > right)
                return;
            if (left > 0)
                generateOneByOne(subList + "(", left - 1, right, re);
            if (right > 0)
                generateOneByOne(subList+")", left, right - 1, re);
            if (left == 0 && right == 0) {
                re.add(subList);
                return;
            }
        }
    }
}
