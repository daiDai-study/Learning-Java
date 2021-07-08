package org.fenixsoft.oom;

public class JavaVMStackSOF02 {
    private static int stackLength = 1;
    public static void test(){
        long unused001,unused002,unused003,unused004,unused005,unused006,unused007,unused008,unused009,unused010,
            unused011,unused012,unused013,unused014,unused015,unused016,unused017,unused018,unused019,unused020,
            unused021,unused022,unused023,unused024,unused025,unused026,unused027,unused028,unused029,unused030,
            unused031,unused032,unused033,unused034,unused035,unused036,unused037,unused038,unused039,unused040,
            unused041,unused042,unused043,unused044,unused045,unused046,unused047,unused048,unused049,unused050;
        stackLength++;
        test();
    }

    public static void main(String[] args) throws Throwable {
        try {
            test();
        }catch (Throwable e){
            System.out.println("stack length: "+ stackLength);
            throw e;
        }
    }
}
