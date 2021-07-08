package org.daistudy.designpattern.structural.adapter;

public class AdapterOfClass extends Adaptee implements Target  {
    @Override
    public void request() {
        super.specificRequest();
    }
}
