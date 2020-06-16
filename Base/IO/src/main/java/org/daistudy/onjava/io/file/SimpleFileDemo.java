package org.daistudy.onjava.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class SimpleFileDemo {
    public static void main(String[] args) throws IOException {
        // java.io.File 在初始化后，未使用（进行任何磁盘操作）之前，只是一个路径
        File f = new File("C:\\Windows\\notepad.exe");
        System.out.println(f);

        System.out.println("\n路径");
        // 当前目录是什么--项目的根目录--当前为 Base
        f = new File(".\\IO");
        System.out.println(f.getPath()); // 返回构造方法传入的路径
        System.out.println(f.getAbsolutePath()); // 返回绝对路径，可能包含 . 或 ..
        System.out.println(f.getCanonicalPath()); // 返回的是规范路径，会将 . 或 .. 进行转换

        System.out.println("\n系统分隔符");
        System.out.println(File.separator); // 根据当前平台打印"\"或"/"

        System.out.println("\n在windows系统上使用 linux 分隔符进行分隔，效果一样");
        f = new File("./IO");
        System.out.println(f.getPath()); // 返回构造方法传入的路径
        System.out.println(f.getAbsolutePath()); // 返回绝对路径，可能包含 . 或 ..
        System.out.println(f.getCanonicalPath()); // 返回的是规范路径，会将 . 或 .. 进行转换

        System.out.println("\n文件和目录");
        File f1 = new File("C:\\Windows");
        File f2 = new File("C:\\Windows/notepad.exe");
        File f3 = new File("C:\\Windows\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());

        System.out.println("\n临时文件");
        f = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        f.deleteOnExit(); // JVM退出时自动删除
        System.out.println(f.isFile());
        System.out.println(f.getAbsolutePath());

        System.out.println("\n遍历目录下的子文件和目录");
        f = new File("C:\\Windows");
        System.out.println("\n所有子文件和子目录");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        Arrays.stream(f.listFiles()).forEach(file -> System.out.println(file));
        System.out.println("\n仅列出.exe子文件");
        // 仅列出.exe文件
        Arrays.stream(f.listFiles((File dir, String name) -> {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        )).forEach(file -> System.out.println(file));
    }
}
