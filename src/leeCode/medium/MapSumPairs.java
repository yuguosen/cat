package leeCode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2018/8/3.
 */
public class MapSumPairs {
    public static void main(String[] args) {
        MapSum ms=new MapSumPairs().new MapSum();
        ms.insert("apple",3);
        System.out.println(ms.sum("ap"));
        ms.insert("app",2);
        System.out.println(ms.sum("ap"));
    }
    class MapSum {
        private Map<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            this.map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int re = 0;
            for (Map.Entry<String, Integer> set : map.entrySet()) {
                String key = set.getKey();
                int val = set.getValue();
                if(key.startsWith(prefix))
                    re+=val;
            }
            return  re;
        }
    }
}
