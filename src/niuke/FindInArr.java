package niuke;

/**
 * Created by yu on 2018/8/6.
 */
public class FindInArr {
    public static void main(String[] args) {
        Solution s = new FindInArr().new Solution();
        //int[][] array = new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        int[][] array = new int[][]{};
        System.out.println(s.Find(6, array));
    }

    class Solution {
        public boolean Find(int target, int[][] array) {
            if (array.length <= 0 || array[0].length <= 0)
                return false;
            int width = array[0].length - 1;
            for (int i = 0; i < array.length; i++) {
                if (target < array[i][0])
                    break;
                else if (target > array[i][0]) {
                    if (target <= array[i][width]) {
                        if (target < array[i][width]) {
                            for (int j = 1; j < width - 1; j++) {
                                if (target == array[i][j])
                                    return true;
                            }
                        } else return true;
                    }
                } else return true;
            }
            return false;
        }
    }
}