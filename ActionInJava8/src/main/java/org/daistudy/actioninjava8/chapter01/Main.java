package org.daistudy.actioninjava8.chapter01;

import java.io.File;
import java.io.FileFilter;

public class Main {
    public static void main(String[] args) {
        // 用普通方式（匿名类）筛选一个目录中所有隐藏文件
        File file = new File(".");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        // 将上述代码通过方法引用构造
        File[] files1 = file.listFiles(File::isHidden);

        // 将上述代码通过 Lambda 构造
        File[] files2 = file.listFiles(innerFile -> innerFile.isHidden());

        System.out.println(files);
    }
}
