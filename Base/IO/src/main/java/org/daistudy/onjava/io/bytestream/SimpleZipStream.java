package org.daistudy.onjava.io.bytestream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.daistudy.onjava.io.bytestream.Utils.getFileDataAsBytes;

public class SimpleZipStream {
    public static void main(String[] args) throws IOException {
        File file = new File("readme.zip");
//        // 读取 zip
//        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(file))) {
//            ZipEntry entry = null;
//            while ((entry = zip.getNextEntry()) != null) {
//                String name = entry.getName();
//                System.out.println("entry.getName(): " + name);
//                if (!entry.isDirectory()) {
//                    byte[] buffer = new byte[1024];
//                    int n;
//                    while ((n = zip.read(buffer)) != -1) {
//                        System.out.println("read " + n + "bytes");
//                        System.out.println(new String(buffer, StandardCharsets.UTF_8));
//                    }
//                }
//            }
//        }

        // 写入 zip
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(file))) {
            File write = new File("pom.xml");
            zip.putNextEntry(new ZipEntry(write.getName()));
            zip.write(getFileDataAsBytes(write));
            zip.closeEntry();
        }
    }
}
