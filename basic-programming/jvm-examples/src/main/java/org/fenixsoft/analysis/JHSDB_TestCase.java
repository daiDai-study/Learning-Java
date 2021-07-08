package org.daistudy.jvm.all.analysis;

/**
 * staticObj、instanceObj、localObj 存放在哪里？
 */
public class JHSDB_TestCase {
    private static class ObjectHolder{

    }

    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设了一个断点
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }
}
