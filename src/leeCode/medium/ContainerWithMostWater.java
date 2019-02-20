package leeCode.medium;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/14 9:57
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea2(height));
    }

    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return max;
        }

        public int maxArea2(int[] height) {
            int maxArea = 0, left = 0, right = height.length - 1;
            while (left < right) {
                int lower = Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, lower * (right - left));
                while (left < right && height[left] <= lower)
                    left++;
                while (left < right && height[right] <= lower)
                    right--;
            }
            return maxArea;
        }
    }
}
