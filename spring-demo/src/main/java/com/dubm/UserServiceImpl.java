package com.dubm;

public class UserServiceImpl {

    public String soutHello(){
        return "hello world!";
    }

    private String name;
    private String id;

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
