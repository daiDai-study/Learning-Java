package org.fenixsoft.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * JDK6及之前 VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 * JDK7及之后 VM Args: -Xms6M -Xmx6M
 */
public class RuntimeConstantPoolOOM1 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
