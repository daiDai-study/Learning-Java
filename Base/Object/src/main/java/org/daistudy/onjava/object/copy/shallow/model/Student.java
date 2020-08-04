package org.daistudy.onjava.object.copy.shallow.model;

/**
 * @Author 60056306
 * @Date 2020/6/18 10:51
 * @Version 1.0
 **/
public class Student implements Cloneable {
    // 对象引用
    private Subject subj;
    private String name;
    private int age;
    private Integer salary;

    public Student(Subject subj, String name, int age, Integer salary) {
        this.subj = subj;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Subject getSubj() {
        return subj;
    }

    public void setSubj(Subject subj) {
        this.subj = subj;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return "Student{" +
                "subj=" + subj +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
