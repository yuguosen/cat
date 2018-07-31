package leeCode.hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by yu on 2018/7/30.
 */
public class LongestIncreasingPathMatrix {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
        Solution s = new LongestIncreasingPathMatrix().new Solution();
        System.out.println(s.longestIncreasingPath(nums));
        //System.out.println(s.getTreeMaxDepth(t));
    }

    class Solution {


        public int longestIncreasingPath(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            List<Integer> list = new ArrayList<Integer>();
            int re = 0;
            int i_length = matrix.length;
            int j_length = matrix[0].length;
            int[][] index_mark = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int max = getPath(matrix, index_mark, i, j, i_length, j_length);
                    re = Math.max(max, re);
                }
            }
            return re;
        }

        public int getPath(int[][] matrix, int[][] index_mark, int i_index, int j_index, int i_length, int j_length) {
            if (index_mark[i_index][j_index] != 0)
                return index_mark[i_index][j_index];
            int max = 1;
            //up
            if (i_index > 0 && matrix[i_index - 1][j_index] > matrix[i_index][j_index]) {
                int up_max = 1+getPath(matrix, index_mark, i_index - 1, j_index, i_length, j_length);
                max = Math.max(max, up_max);
            }
            //down
            if (i_index < i_length - 1 && matrix[i_index + 1][j_index] > matrix[i_index][j_index]) {
                int down_max = 1+getPath(matrix, index_mark, i_index + 1, j_index, i_length, j_length);
                max = Math.max(max, down_max);
            }

            //left
            if (j_index > 0 && matrix[i_index][j_index - 1] > matrix[i_index][j_index]) {
                int left_max = 1+getPath(matrix, index_mark, i_index, j_index - 1, i_length, j_length);
                max = Math.max(max, left_max);
            }
            //right
            if (j_index < j_length - 1 && matrix[i_index][j_index + 1] > matrix[i_index][j_index]) {
                int right_max = 1+getPath(matrix, index_mark, i_index, j_index + 1, i_length, j_length);
                max = Math.max(max, right_max);
            }
            index_mark[i_index][j_index] = max;

            return max;

        }
    }


}
