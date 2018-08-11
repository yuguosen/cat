package leeCode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yu on 2018/8/3.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution s = new TopKFrequentElements().new Solution();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> re = s.topKFrequent(nums, k);
        for (int i : re)
            System.out.println(i);
    }

    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            //num[i]->count
            Map<Integer, Integer> numCount = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int p = nums[i];
                int count = numCount.getOrDefault(p, 0) + 1;
                numCount.put(p, count);

            }
            List<Integer> re = new ArrayList<>();
            List<Integer>[] buck = new List[nums.length + 1];
            for (Map.Entry<Integer, Integer> set : numCount.entrySet()) {
                int count = set.getValue();
                if (buck[count] == null) {
                    buck[count] = new ArrayList<>();
                }
                buck[count].add(set.getKey());
            }
            for (int i =nums.length;i>=0&&re.size()<k;i--){
                if (buck[i]!=null)
                    re.addAll(buck[i]);
            }
                return re;
        }
    }
}
