package org.daistudy.onjava.io.charstream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        try (Reader reader = new FileReader("pom.xml")) {
            char[] buffer = new char[1024];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("\nread " + n + " chars.");
                // 不能将全部的 buffer 读取出来，因为有可能有无效的数据
                for (int i = 0; i < n; i++) {
                    System.out.print(buffer[i]);
                }
            }
        }

        try (Reader reader = new InputStreamReader(FileReaderDemo.class.getResourceAsStream("/default.properties"))) {
            char[] buffer = new char[1024];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("\nread " + n + " chars.");
                for (int i = 0; i < n; i++) {
                    System.out.print(buffer[i]);
                }
            }
        }
    }
}
