# Java 事件处理机制

> 了解 Java 事件处理机制需要先了解一下设计模式中的观察者模式

参考：
+ [Java - 事件处理机制](https://www.jianshu.com/p/1b716d80c82c)

## 一、观察者模式

> 观察者模式，又称发布订阅模式（个人感觉*通知订阅*更好理解）。它，定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个被观察者对象。这个被观察者对象在状态变化时，会通知所有的观察者对象，使他们将相应做出反应。

### 1、场景
+ 老师布置作业，**通知**学生；
+ 学生**观察**到老师布置了作业，开始写作业。

在这个场景中，学生是**观察者**，老师是**被观察者**，但 *老师作为被观察者，实际上把握主动权*，这里我觉得观察者模式也可以成为通知者模式（老师是通知者，学生作为被通知者）

问题：观察者模式 == 发布订阅模式的区别？？？

### 2、Java 实现

Java 提供了两个类：`Observer`（观察者）接口 和 `Observable`（可观察的，被观察者）类，其中 `Observable` 类中定义了一个 `Observer` 类型的数组来存放需要通知的观察者，那么当被观察者需要通知观察者去做什么的时候，调用 `notifyObservers()` 方法去通知即可（注意调用的时候，需要先调用 `setChanged()` 方法，至于其原理还有待研究）

+ 学生（具体观察者）需要实现 `Observer` 接口；
+ 老师（具体被观察者）需要继承 `Observable` 类；

**学生**
```Java
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
```

**老师**
```Java
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
```


**客户端模拟**
```Java
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("张老师");
        Student student1 = new Student("小张");
        Student student2 = new Student("小李");
        Student student3 = new Student("小红");

        teacher.assign(new Student[]{student1, student2, student3}, "数学");
    }
}
```

## 二、事件驱动模型

事件驱动模块几大要素：
1. 事件源 -- 可以看作是观察者模式中的被观察者
2. 监听器 -- 可以看作是观察者模式中的观察者
3. 事件 -- 

*这里的事件和事件源有点傻傻分不清的感觉。* --> **正确理解事件驱动模型**

### 1、使用事件驱动模型来实现老师布置作业的场景

Java 提供了监听器接口（`EventListener` 接口）和事件类（`EventObject`类）

目前的写法基本上是仿照 Java 提供的观察者模式进行实现

**定义自己的监听器接口和学生（具体监听器）**
```Java
public interface HomeworkEventListen extends EventListener {
    void update(HomeworkEventObject o, Object arg);
}

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
```

**定义事件和老师（事件源，基本仿照 Observable 类实现）**
```Java
public class HomeworkEventObject extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public HomeworkEventObject(Object source) {
        super(source);
    }
}

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
```

**客户端模拟**
```Java
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("张老师");
        Student student1 = new Student("小张");
        Student student2 = new Student("小李");
        Student student3 = new Student("小红");

        teacher.assign(new Student[]{student1, student2, student3}, "数学");
    }
}
```
