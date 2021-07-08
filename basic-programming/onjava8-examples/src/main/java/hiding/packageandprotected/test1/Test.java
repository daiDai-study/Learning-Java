package hiding.packageandprotected.test1;

public class Test {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        superClass.testPackage();
        superClass.testProtected();
    }
}
