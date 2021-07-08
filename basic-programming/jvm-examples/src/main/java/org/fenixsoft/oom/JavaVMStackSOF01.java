package org.fenixsoft.oom;

/**
 * 栈溢出
 * HotSpot 虚拟机不区分虚拟机栈和本地方法栈，栈的容量只能通过 -Xss 参数指定
 * VM Args: -Xss128k
 */
public class JavaVMStackSOF01 {
    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF01 sof = new JavaVMStackSOF01();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + sof.stackLength);
            throw e;
        }
    }
}
