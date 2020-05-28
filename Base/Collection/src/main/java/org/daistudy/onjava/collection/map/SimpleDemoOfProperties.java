package org.daistudy.onjava.collection.map;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * 不知道文件如何读取？？？
 */
public class SimpleDemoOfProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("in.properties"));
        final Set<String> strings = properties.stringPropertyNames();
        for (String propertyName : strings) {
            System.out.println(propertyName + "=" + properties.getProperty(propertyName));
        }
        properties.setProperty("url", "http://www.liaoxuefeng.com");
        properties.setProperty("language", "Java");
        properties.store(new FileWriter("out.properties"), "out.properties");
    }
}
