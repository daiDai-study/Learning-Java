package org.daistudy.onjava.collections.stack;

// collections/StackCollision.java

import org.daistudy.onjava.collections.entity.Stack;

/**
 * 首选自定义的 Stack
 * 在选择 java.util.Stack 时，必须使用全限定名称（full qualification）
 */
public class StackCollision {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(String s : "My dog has fleas".split(" "))
            stack.push(s);
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        java.util.Stack<String> stack2 =
                new java.util.Stack<>();
        for(String s : "My dog has fleas".split(" "))
            stack2.push(s);
        while(!stack2.empty())
            System.out.print(stack2.pop() + " ");
    }
}
/* Output:
fleas has dog My
fleas has dog My
*/
