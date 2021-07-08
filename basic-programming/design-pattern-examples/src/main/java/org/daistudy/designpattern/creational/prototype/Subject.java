package org.daistudy.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Object类提供的clone方法只是拷贝本对象，
 * 其对象内部的数组、引用对象等都不拷贝，还是指向原生对象的内部元素地址，这种拷贝就叫做浅拷贝
 *
 * 其他的原始类型比如int、long、char等都会被拷贝，
 * 对于String类型，Java就希望你把它认为是基本类型，它是没有clone方法的，
 * 处理机制也比较特殊，通过字符串池（stringpool）在需要的时候才在内存中创建新的字符串，
 * 读者在使用的时候就把String当做基本类使用即可
 */
public class Subject implements Cloneable {
    private Integer id;
    private String name;
    private List list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToList(String val){
        this.list.add(val);
    }

    public List getList(){
        return this.list;
    }

    public Subject() {
        this.list = new ArrayList<>();
        System.out.println("构造方法执行了...");
    }

    @Override
    public String toString() {
        return "Subject{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", list=" + list +
            '}';
    }

    @Override
    protected Subject clone() throws CloneNotSupportedException {
        Subject subject = null;
        try {
            subject = (Subject) super.clone();
            subject.list = (List)((ArrayList)this.list).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return subject;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Subject subject = new Subject();
        subject.setId(1);
        subject.setName("王无");
        subject.addToList("001");
        Subject clone = subject.clone();
        clone.setId(2);
        clone.setName("王五");
        clone.addToList("002");
        System.out.println("源对象：" + subject);
        System.out.println("克隆对象：" + clone);
    }
}
