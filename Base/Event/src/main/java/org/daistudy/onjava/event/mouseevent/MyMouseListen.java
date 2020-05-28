package org.daistudy.onjava.event.mouseevent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListen implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("我被谁点击了一下：" + e.getSource().toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
