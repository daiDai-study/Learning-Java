package org.fenixsoft.clazz;

public class TestClass {
    private int m;

    public int inc(){
        return m + 1;
    }

    public int intWithCatch(){
        int x;
        try{
            x = 1;
            System.out.println(x);
            return x;
        }catch (Exception e){
            x = 2;
            System.out.println(x);
            return x;
        }finally {
            x = 3;
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        System.out.println(new TestClass().intWithCatch());
    }
}
