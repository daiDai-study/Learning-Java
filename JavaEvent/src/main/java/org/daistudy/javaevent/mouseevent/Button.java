package org.daistudy.javaevent.mouseevent;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button {
    private MouseListener mouseListener;

    public void addListener(MouseListener mouseListener){
        this.mouseListener = mouseListener;
    }

    public void doClick(){
        MouseEvent mouseEvent = new MouseEvent(new Component() {}, 1, 1, 1, 2, 3, 4, false);
        this.mouseListener.mouseClicked(mouseEvent);
    }
}
