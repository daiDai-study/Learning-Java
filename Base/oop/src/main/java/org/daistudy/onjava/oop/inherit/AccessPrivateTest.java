package org.daistudy.onjava.oop.inherit;

public class AccessPrivateTest {

    class Person {
        private String name;
        protected int age;
    }

    class Student extends Person {
        public String hello() {
            return "Hello, " + super.name + super.age; // 编译错误：无法访问name字段
        }
    }
}
