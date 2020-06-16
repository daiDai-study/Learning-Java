package org.daistudy.onjava.io.bytestream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class SimpleOutputStream {
    public static void main(String[] args) throws IOException {
        System.out.println("FileOutputStream：");
        File file = Paths.get("readme.md").toFile();
        if(!file.exists()){
            if (file.createNewFile()) {
                System.out.println("文件不存在，已创建");
            }else{
                System.out.println("文件不存在，创建失败");
            }
        }
        try (OutputStream output = new FileOutputStream(file, true)) {
            output.write("\n".getBytes(StandardCharsets.UTF_8));
            // 一次写一个字节
            output.write(72); // H
            output.write(101); // e
            output.write(108); // l
            output.write(108); // l
            output.write(111); // o
            // 一次写多个字节 字符由 unicode 转为 utf-8 再转为字节
            output.write(" World".getBytes(StandardCharsets.UTF_8));
            output.write("\n中文".getBytes(StandardCharsets.UTF_8));
        }
        try(InputStream input = new FileInputStream(file)){
            byte[] buffer = new byte[1024];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
                System.out.println(new String(buffer, StandardCharsets.UTF_8));
            }
        }

        System.out.println("\nByteArrayOutputStream：");
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello ".getBytes(StandardCharsets.UTF_8));
            output.write("world!".getBytes(StandardCharsets.UTF_8));
            data = output.toByteArray();
        }
        System.out.println(new String(data, StandardCharsets.UTF_8));
    }
}
