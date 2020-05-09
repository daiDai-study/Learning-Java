package org.daistudy.javaevent.eventdriven;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("张老师");
        Student student1 = new Student("小张");
        Student student2 = new Student("小李");
        Student student3 = new Student("小红");

        teacher.assign(new Student[]{student1, student2, student3}, "数学");
    }
}
