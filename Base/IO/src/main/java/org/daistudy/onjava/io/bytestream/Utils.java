package org.daistudy.onjava.io.bytestream;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Utils {
    public static byte[] getFileDataAsBytes(File file) throws IOException {
        byte[] copy = new byte[0];
        try (FileInputStream input = new FileInputStream(file)) {
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
        }
        return copy;
    }
}
