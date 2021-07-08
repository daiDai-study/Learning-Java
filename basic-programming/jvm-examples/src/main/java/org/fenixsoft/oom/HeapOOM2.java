package org.fenixsoft.oom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM2 {
    private static class OOMObject {
        private String[] friends;

        public void setFriends(String[] friends) {
            this.friends = friends;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String, OOMObject> map = new HashMap<>();
        int counter = 1;
        while (true) {
            Thread.sleep(10);
            String friend = "friends";
            OOMObject object = new OOMObject();
            String[] friends = new String[counter];
            for (int i = 0; i < friends.length; i++) {
                friends[i] = friend + i;
            }
            object.setFriends(friends);
            map.put(friend + counter, object);
            if (counter % 100 == 0)
                System.out.println("put" + counter);
            counter++;
        }
    }
}
