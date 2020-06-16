package org.daistudy.onjava.io.file;

import java.io.File;
import java.io.IOException;

public class FilePathDemo {
    public static void main(String[] args) throws IOException {
        // 当前根目录：E:\my_projects\Learning-Java\Base\
        System.out.println(new File("pom.xml").getCanonicalPath());
        System.out.println(new File("./pom.xml").getCanonicalPath());
        System.out.println(new File(".\\pom.xml").getCanonicalPath());

        // 当前根目录：E:\
        System.out.println(new File("/pom.xml").getCanonicalPath());
        System.out.println(new File("\\pom.xml").getCanonicalPath());
    }
}
