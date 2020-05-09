package org.daistudy.javaevent.obsevermode;

import java.util.Observable;
import java.util.Observer;

public class Teacher extends Observable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name){
        this.name = name;
    }

    public void assign(Observer[] observers, String homework){
        System.out.println(this.name + "布置了作业：" + homework);
        for (Observer observer : observers) {
            this.addObserver(observer);
        }
        setChanged();
        notifyObservers(homework);
    }
}
