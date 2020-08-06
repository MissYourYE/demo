package com.dubm.apply.mybatis.po;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private Short age;

    private String position;

    private String acct;

    private String pwd;

    private String addr;

    private Integer phone;

    private String email;

    private Date createTime;

    private Short delFlag;

    public User() {
    }

    public User(String name, Short age, String position, String acct, String pwd, String addr, Integer phone, String email, Date createTime, Short delFlag) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.acct = acct;
        this.pwd = pwd;
        this.addr = addr;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", acct='" + acct + '\'' +
                ", pwd='" + pwd + '\'' +
                ", addr='" + addr + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", delFlag=" + delFlag +
                '}';
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct == null ? null : acct.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }
}