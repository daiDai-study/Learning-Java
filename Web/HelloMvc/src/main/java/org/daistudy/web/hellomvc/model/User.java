package org.daistudy.web.hellomvc.model;

public class User {
    private Long id;
    private String name;
    private School school;

    public User() {
    }

    public User(Long id, String name, School school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
