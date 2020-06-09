package com.dubm.po;

public class User {
    private Long id;
    private String acct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", acct='" + acct + '\'' +
                '}';
    }
}
