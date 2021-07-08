package hiding.packageandprotected.test2;

import hiding.packageandprotected.test1.SuperClass;

public class SubClass extends SuperClass {

    void test(){
        this.testProtected();
//        this.testPackage();
//        this.testPrivate();
        super.testProtected();
//        super.testPackage();
//        super.testPrivate();
    }
}
