package leeCode.hard;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/9/10 9:26
 */

public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianTwoSortedArrays().new Solution();
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            if (len1 == 0 && len2 == 0)
                return 0;
            int midIndex = (len1 + len2) / 2;
            int[] a = new int[len1 + len2];
            double re = 0.0;
            int index = 0;
            for (int i = 0, j = 0; i < len1 || j < len2; ) {
                if (index - 1 == midIndex)
                    break;
                if (i >= len1 || (j < len2 && nums1[i] > nums2[j])) {
                    a[index++] = nums2[j];
                    j++;
                } else {
                    a[index++] = nums1[i];
                    i++;
                }
            }
            re = (len1 + len2) % 2 == 0 ? (a[midIndex] + a[midIndex - 1]) / 2.0 : a[midIndex];
            return re;
        }
    }
}
