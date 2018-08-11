package leeCode.easy;

/**
 * Created by yu on 2018/8/6.
 */
public class GoatLatin {
    class Solution {
        public String toGoatLatin(String S) {
            StringBuilder sb = new StringBuilder();
            String[] info = S.split(" ");
            for (int i = 0; i < info.length; i++) {
                String s = info[i];
                char firstChar = Character.toLowerCase(s.charAt(0));

                if (firstChar == 'a' ||
                        firstChar == 'e' ||
                        firstChar == 'i' ||
                        firstChar == 'o' ||
                        firstChar == 'u') {
                    sb.append(s);

                } else {
                    sb.append(s.substring(1));
                    sb.append(s.charAt(0));
                }
                sb.append("ma");
                for (int j = 0; j <= i; j++)
                    sb.append("a");
                if (i < info.length - 1)
                    sb.append(" ");
            }
            return sb.toString();
        }
    }
}
