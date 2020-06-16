package org.daistudy.onjava.io.charstream;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintDemo {
    public static void main(String[] args) {
        StringWriter buffer = new StringWriter();
        try (PrintWriter pw = new PrintWriter(buffer)) {
            pw.println("Hello");
            pw.println(12345);
            pw.println(true);
        }
        System.out.println(buffer.toString());
    }
}
