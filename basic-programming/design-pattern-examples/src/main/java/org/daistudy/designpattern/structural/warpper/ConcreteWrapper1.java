package org.daistudy.designpattern.structural.warpper;

public class ConcreteWrapper1 extends TargetWrapper {


    public ConcreteWrapper1(Target target) {
        super(target);
    }

    @Override
    public void operate() {
        System.out.println("wrapper");
        super.operate();
        System.out.println(this);
        System.out.println(this.toString());
        System.out.println(super.toString());
    }

    public static void main(String[] args) {
        Target concreteWrapper1 = new ConcreteWrapper1(new ConcreteTarget1());
        concreteWrapper1.operate();
    }
}
