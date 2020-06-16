package org.daistudy.onjava.io.bytestream;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleInputStream {
    public static void main(String[] args) throws IOException {
        try (InputStream input = new FileInputStream("pom.xml")) {
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = input.read()) != -1) {
                sb.append((char) n); // 只适用于 ascii 码， 不适用于 中文或其他文字 （出现乱码）
            }
            System.out.println(sb.toString());
        } // 编译器在此自动为我们写入finally并调用close()
        byte[] copy = new byte[0];
        try (InputStream input = new FileInputStream("pom.xml")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1024];
            int n;
            int m;
            while((n = input.read(buffer)) != -1){ // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
                m = copy.length;
                byte[] origin = copy;
                copy = new byte[m + n];
                System.arraycopy(origin, 0, copy, 0, m);
                System.arraycopy(buffer, 0, copy, m, n);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : copy) {
            sb.append((char) b);
        }
        System.out.println(sb.toString());
    }
}
