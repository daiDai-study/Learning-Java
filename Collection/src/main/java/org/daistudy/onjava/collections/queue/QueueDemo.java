package org.daistudy.onjava.collections.queue;

// collections/QueueDemo.java
// Upcasting to a Queue from a LinkedList
import java.util.*;

/**
 * LinkedList 实现了 Queue 接口，因此 LinkedList 可以用作 Queue 的一种实现
 * 这里体现了一个思想，可以让一个具体实现类实现多个接口，应用时根据实际情况将类的实例向上转型为所需要的接口
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        while(queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for(int i = 0; i < 10; i++)
            queue.offer(rand.nextInt(i + 10));
        printQ(queue);
        Queue<Character> qc = new LinkedList<>();
        for(char c : "Brontosaurus".toCharArray())
            qc.offer(c);
        printQ(qc);
    }
}
/* Output:
8 1 1 1 5 14 3 1 0 1
B r o n t o s a u r u s
*/
