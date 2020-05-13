package org.daistudy.actioninjava8.chapter03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LambdaDemo01 {
    public static void main(String[] args) throws IOException {
        // 普通方法
        System.out.println(processFileWithOneLine());
        System.out.println(processFileWihtTwoLine());

        // 使用 Lambda 表达式
        System.out.println(processFileWithLambda((BufferedReader br) -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }));
        System.out.println(processFileWithLambda((BufferedReader br) -> br.readLine() + "\n" + br.readLine()));
    }

    public static String processFileWithOneLine() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./pom.xml"))){
            return bufferedReader.readLine();
        }
    }

    public static String processFileWihtTwoLine() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./pom.xml"))){
            return bufferedReader.readLine() + "\n" +  bufferedReader.readLine();
        }
    }

    public static String processFileWithLambda(BufferedReaderProcess p) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./pom.xml"))){
            return p.process(bufferedReader);
        }
    }
}
