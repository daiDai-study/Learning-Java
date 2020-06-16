package org.daistudy.onjava.io.bytestream;

import java.io.IOException;
import java.io.InputStream;

public class ReadClassPath {
    public static void main(String[] args) throws IOException {
        // 如果以 "/" 开头，则直接从 classpath 的根目录找文件
        // 如果不是以 "/" 开头，则会从当前类在 classpath 的目录中找文件
        try(InputStream input = ReadClassPath.class.getResourceAsStream("default.properties")){
            // getResourceAsStream()需要特别注意的一点是，如果资源文件不存在，它将返回null
            if (input != null) {
                // TODO:
                byte[] copy = new byte[0];
                byte[] buffer = new byte[1024];
                int n;
                int m;
                while((n = input.read(buffer)) != -1){
                    m = copy.length;
                    byte[] origin = copy;
                    copy = new byte[m + n];
                    System.arraycopy(origin, 0, copy, 0, m);
                    System.arraycopy(buffer, 0, copy, m, n);
                }
                StringBuilder sb = new StringBuilder();
                for (byte b : copy) {
                    sb.append((char) b);
                }
                System.out.println(sb.toString());
            }
            else{
                System.out.println("指定配置文件不存在");
            }
        }
    }
}
