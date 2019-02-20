package leeCode.easy;


import scala.collection.immutable.HashSet;
import scala.collection.immutable.Set;

import java.util.HashMap;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/3 10:35
 */

public class RomantoInteger {
    class Solution {
        public int romanToInt(String s) {
            int re = 0;
            for (char c : s.toCharArray()) {
                switch (c) {
                    case 'I':
                        re += 1;
                        break;
                    case 'V':
                        re += 5;
                        break;
                    case 'X':
                        re += 10;
                        break;
                    case 'L':
                        re += 50;
                        break;
                    case 'C':
                        re += 100;
                        break;
                    case 'D':
                        re += 500;
                        break;
                    case 'M':
                        re += 1000;
                        break;
                }
            }
            if (s.contains("IV"))
                re -= 2;
            if (s.contains("IX"))
                re -= 2;
            if (s.contains("XL"))
                re -= 20;
            if (s.contains("XC"))
                re -= 20;
            if (s.contains("CD"))
                re -= 200;
            if (s.contains("CM"))
                re -= 200;


            return re;
        }
    }
}
