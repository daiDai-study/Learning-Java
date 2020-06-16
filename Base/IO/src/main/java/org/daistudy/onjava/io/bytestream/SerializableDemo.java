package org.daistudy.onjava.io.bytestream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
        // 对于非字符的 byte 转成 char 时会乱码
        System.out.println(new String(buffer.toByteArray(), StandardCharsets.UTF_8));

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.toByteArray());
        try (ObjectInputStream input = new ObjectInputStream(byteArrayInputStream)) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();
            System.out.println(n);
            System.out.println(s);
            System.out.println(d);
        }
    }
}
