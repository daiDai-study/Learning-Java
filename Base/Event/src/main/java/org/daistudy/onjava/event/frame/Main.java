package org.daistudy.onjava.event.frame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        new DemoFrame();

    }

    static class DemoFrame extends JFrame implements MouseListener {


        public DemoFrame() {
            super("demo");

            this.setSize(500, 400);
            this.setLocationRelativeTo(null);
            this.getContentPane().setLayout(null);
            this.setVisible(true);

            JButton button1 = new JButton("ok");
            button1.setBounds(8, 8, 80, 20);
            button1.addMouseListener(this);

            this.getContentPane().add(button1);
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("I haven been clicked by" + e.getSource().toString());
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
}
