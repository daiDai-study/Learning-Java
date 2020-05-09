package org.daistudy.javaevent.eventdriven;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
    private String name;
    private Set<HomeworkEventListen> observers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name){
        this.name = name;
        this.observers = new HashSet<>();
    }

    public void assign(HomeworkEventListen[] observers, String homework){
        System.out.println(this.name + "布置了作业：" + homework);
        for (HomeworkEventListen observer : observers) {
            this.addObserver(observer);
        }
        notifyObservers(homework);
    }

    private void addObserver(HomeworkEventListen observer){
        this.observers.add(observer);
    }

    private void notifyObservers(Object arg){
        HomeworkEventObject event = new HomeworkEventObject(this);
        for (HomeworkEventListen observer : this.observers) {
            observer.update(event, arg);
        }
    }
}
