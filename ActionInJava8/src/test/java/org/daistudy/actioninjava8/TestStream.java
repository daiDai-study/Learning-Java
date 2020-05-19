package org.daistudy.actioninjava8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {

    @Test
    void test(){
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ids.add(String.valueOf(i));
        }
        List<String> collect = getSub(ids, 10);
        final String s = list2String(collect);
        System.out.println(collect);
    }

    public List<String> getSub(List<String> list, int sampleTotal){
        int interval = list.size()/sampleTotal;
        List<String> sub = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(i - count == 0){
                sub.add(list.get(i));
                count += interval;
            }
        }
        return sub;
    }

    private String list2String(List<String> list){
        StringBuilder str = new StringBuilder();
        for (String s : list) {
            str.append("'").append(s).append("'").append(",");
        }
        if(list.size() > 0){
            str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }
}
