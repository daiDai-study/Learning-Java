package org.daistudy.onjava.event.mouseevent;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.addListener(new MyMouseListen());

        button.doClick();
    }
}
