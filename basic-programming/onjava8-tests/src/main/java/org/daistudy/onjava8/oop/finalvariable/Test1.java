package org.daistudy.onjava8.oop.finalvariable;

public class Test1 {

    public static void main(String[] args) {
        int i;
        try{
            i = 1;
            System.out.println(i);
            throw new RuntimeException("123");
        }catch (Exception e){
            i = 3;
            System.out.println(i);
        } finally {
            i = 2;
            System.out.println(i);
        }
    }

}
