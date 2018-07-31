package leeCode.easy;

/**
 * Created by yu on 2018/7/31.
 */
public class LargestTriangleArea {
    public static void main(String[] args) {
        int[][] points = {{35, -23}, {-12, -48}, {-34, -40}, {21, -25}, {-35, -44}, {24, 1}, {16, -9}, {41, 4}, {-36, -49}, {42, -49}, {-37, -20}, {-35, 11}, {-2, -36}, {18, 21}, {18, 8}, {-24, 14}, {-23, -11}, {-8, 44}, {-19, -3}, {0, -10}, {-21, -4}, {23, 18}, {20, 11}, {-42, 24}, {6, -19}};
        Solution s = new LargestTriangleArea().new Solution();
        System.out.println(s.largestTriangleArea(points));

    }

    class Solution {
        public double largestTriangleArea(int[][] points) {
            if (points.length < 3) return 0;
            double max = 0.0;
            for (int i1 = 0; i1 < points.length - 2; i1++) {
                for (int i2 = i1 + 1; i2 < points.length - 1; i2++) {
                    for (int i3 = i2 + 1; i3 < points.length; i3++) {

                        double side1 = Math.sqrt(Math.pow(points[i1][0] - points[i2][0], 2) + Math.pow(points[i1][1] - points[i2][1], 2));
                        double side2 = Math.sqrt(Math.pow(points[i1][0] - points[i3][0], 2) + Math.pow(points[i1][1] - points[i3][1], 2));
                        double side3 = Math.sqrt(Math.pow(points[i2][0] - points[i3][0], 2) + Math.pow(points[i2][1] - points[i3][1], 2));
                        double s = (side1 + side2 + side3) / 2;
                        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
                        if (Double.isNaN(area))
                            area=0;
                        max = Math.max(area, max);

                    }
                }
            }
            return max;
        }
    }
}
