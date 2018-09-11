package com.rechenggit.core.domain;


import org.hibernate.validator.constraints.NotEmpty;

public class NotEmptyTest {
    @NotEmpty(message = "{name.empty.error}")
    private String name;
    @NotEmpty( message = "{name.empty.error}")
    private String age;
    @NotEmpty( message = "密码不能为空")
    private String password;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
