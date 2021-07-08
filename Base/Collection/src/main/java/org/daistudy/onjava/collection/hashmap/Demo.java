package org.daistudy.onjava.collection.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); // 16
        map.put(1, "1"); // 0
        map.put(17, "17"); // 1
        map.put(33, "33"); // 2
        map.put(49, "49"); // 3
        map.put(65, "65"); // 4
        map.put(81, "81"); // 5
        map.put(97, "97"); // 6
        map.put(113, "113"); // 7
        map.put(129, "129"); // 8
        map.put(145, "145"); // 0
        map.put(161, "161"); // 0
        map.put(177, "177"); // 0

        for(Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();iterator.hasNext();){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + "---" + next.getValue());
            iterator.remove();
        }
        System.out.println(map.size());
    }
}
