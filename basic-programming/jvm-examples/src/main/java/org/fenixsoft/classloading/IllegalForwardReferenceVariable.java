package org.fenixsoft.classloading;

public class IllegalForwardReferenceVariable {
    static {
        i = 0;
//        System.out.println(i); // 编译器会提示 Illegal forward reference（非法前向引用）
    }
    static int i;
}
