package org.daistudy.onjava.io.charstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        try (Writer writer = new FileWriter("readme.md", true)) {
            writer.append('H'); // 写入单个字符
            writer.write("Hello".toCharArray()); // 写入char[]
            writer.write("Hello"); // 写入String
        }
    }
}
