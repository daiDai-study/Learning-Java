package org.daistudy.onjava.collection.collections;

// collections/AsListInference.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}

class Powder extends Snow {}

class Light extends Powder {}

class Heavy extends Powder {}

class Crusty extends Snow {}

class Slush extends Snow {}

/**
 * 通过 Arrays.asList 方式得到的集合类型，获取的是定长的集合，不支持 add 或 remove 等方法
 */
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder());
        //- snow1.add(new Heavy()); // Exception

        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy());
        //- snow2.add(new Slush()); // Exception

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,
                new Light(), new Heavy(), new Powder());
        snow3.add(new Crusty());

        // Hint with explicit type argument specification（显式类型参数说明）:
        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy(), new Slush());
        //- snow4.add(new Powder()); // Exception
    }
}
