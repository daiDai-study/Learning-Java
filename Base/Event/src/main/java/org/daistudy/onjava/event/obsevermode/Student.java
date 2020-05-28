package org.daistudy.onjava.event.obsevermode;

import java.util.Observable;
import java.util.Observer;

/**
 * 学生，作为观察者，观察老师的动作
 * 观察，在词意上为主动，但在观察者模式中，观察者在观察到被观察者的特定动作后需要出发的行为，是被动的
 * 其行为是由被观察者主动调用
 */
public class Student implements Observer {
    /**
     * 姓名
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name){
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        Teacher teacher = (Teacher) o;
        System.out.println(this.name + "观察到" + teacher.getName() + "老师布置了作业：" + arg);
        System.out.println(this.name + "开始写作业了");
    }
}
