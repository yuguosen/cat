package leeCode.easy;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/10 9:16
 */

public class ImplementstrStr {
    public static void main(String[] args) {
        Solution s=new ImplementstrStr().new Solution();
        String haystack = "a";
        String needle = "a";
        System.out.println(s.strStr(haystack,needle));
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack==null||needle==null)
                return -1;
            if (needle.equals(""))
                return 0;
            int l1=haystack.length();
            int l2=needle.length();
            if (l1<l2)
                return -1;
            int thread=l1-l2;
            for(int i=0;i<=thread;i++){
                if(haystack.substring(i,i+l2).equals(needle))
                    return i;
            }
            return -1;
        }
    }
}
