package org.daistudy.javaevent.eventdriven;

public class Student implements HomeworkEventListen{
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

    public void update(HomeworkEventObject o, Object arg) {
        Teacher teacher = (Teacher) o.getSource();
        System.out.println(this.name + "观察到" + teacher.getName() + "老师布置了作业：" + arg);
        System.out.println(this.name + "开始写作业了");
    }
}
