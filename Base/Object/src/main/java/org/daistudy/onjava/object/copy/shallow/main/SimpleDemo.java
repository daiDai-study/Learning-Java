package org.daistudy.onjava.object.copy.shallow.main;

import org.daistudy.onjava.object.copy.shallow.model.Student;
import org.daistudy.onjava.object.copy.shallow.model.Subject;

/**
 * @Author 60056306
 * @Date 2020/6/18 11:02
 * @Version 1.0
 **/
public class SimpleDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 原始对象
        final Subject subject = new Subject("潇湘剑雨", 180, 140);
        Student stud = new Student(subject, "杨充", 24, 10);
        System.out.println("原始对象: " + stud);

        // 拷贝对象
        Student clonedStud = (Student) stud.clone();
        System.out.println("拷贝对象: " + stud);

        // 原始对象和拷贝对象是否一样：
        System.out.println("原始对象和拷贝对象是否一样: " + (stud == clonedStud));
        // 原始对象和拷贝对象的name属性是否一样
        System.out.println("原始对象和拷贝对象的name（String）属性是否一样: " + (stud.getName() == clonedStud.getName()));
        System.out.println("原始对象和拷贝对象的age（int）属性是否一样: " + (stud.getAge() == clonedStud.getAge()));
        System.out.println("原始对象和拷贝对象的salary（Integer）属性是否一样: " + (stud.getSalary() == clonedStud.getSalary()));
        System.out.println("原始对象和拷贝对象的subj（Subject）属性是否一样: " + (stud.getSubj() == clonedStud.getSubj()));

        stud.setName("小杨逗比");
        stud.setAge(20);
        stud.setSalary(20);
        stud.getSubj().setName("潇湘剑雨大侠");
        stud.getSubj().setHeight(170);
        stud.getSubj().setWeight(130);
        System.out.println("更新后的原始对象: " + stud);
        System.out.println("更新原始对象后的克隆对象: " + clonedStud);
    }
}
