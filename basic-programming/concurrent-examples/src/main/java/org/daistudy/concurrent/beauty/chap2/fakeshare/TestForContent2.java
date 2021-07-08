package org.daistudy.concurrent.beauty.chap2.fakeshare;

public class TestForContent2 {
    static final int LINE_NUM = 10240;
    static final int COLUMN_NUM = 10240;

    public static void main(String[] args) {
        long[][] array = new long[LINE_NUM][COLUMN_NUM];
        long start = System.currentTimeMillis();
        for (int i = 0; i < COLUMN_NUM; i++) {
            for (int j = 0; j < LINE_NUM; j++) {
                array[j][i] = i*2 + j;
            }
        }
        long end = System.currentTimeMillis();
        long cache = end - start;
        System.out.println("cache time:" + cache);
    }
}
