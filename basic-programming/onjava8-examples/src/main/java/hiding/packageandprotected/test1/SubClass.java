package hiding.packageandprotected.test1;

public class SubClass extends SuperClass {

    void test(){
        this.testProtected();
        this.testPackage();
//        this.testPrivate();
        super.testProtected();
        super.testPackage();
//        super.testPrivate();
    }
}
