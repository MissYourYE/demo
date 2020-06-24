package com.dubm.apply.spring.po;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component
public class User{
    private Long id;

    @Value("dubaoming")
    private String acct;
    private String deptId;
    @Autowired
    private Dept dept;
//    private String[] hobbies;
    private List<String> hobbies;
    private Set<String> friends;
    private Map<Integer,String> cities;
    private Properties pro;
    public User() {
    }

    public User(Long id, String acct) {
        System.out.println("调用构造方法注入。。");
        this.id = id;
        this.acct = acct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        System.out.println("调用set方法。。。");
        this.id = id;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<String> getFriends() {
        return friends;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }

    public Map<Integer, String> getCities() {
        return cities;
    }

    public void setCities(Map<Integer, String> cities) {
        this.cities = cities;
    }

    public Properties getPro() {
        return pro;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }
}
