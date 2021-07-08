package org.daistudy.designpattern.creational.builder;

public class Product {
    private String PartA;
    private String PartB;
    private String PartC;

    public String getPartA() {
        return PartA;
    }

    @Override
    public String toString() {
        return "Product{" +
                "PartA='" + PartA + '\'' +
                ", PartB='" + PartB + '\'' +
                ", PartC='" + PartC + '\'' +
                '}';
    }

    public void setPartA(String partA) {
        PartA = partA;
    }

    public String getPartB() {
        return PartB;
    }

    public void setPartB(String partB) {
        PartB = partB;
    }

    public String getPartC() {
        return PartC;
    }

    public void setPartC(String partC) {
        PartC = partC;
    }
}
