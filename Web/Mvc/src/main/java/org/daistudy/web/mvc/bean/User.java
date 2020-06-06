package org.daistudy.web.mvc.bean;

public class User {
    private String email;
    private String name;
    private String password;
    private String description;

    public User() {
    }

    public User(String email, String name, String password, String description) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
