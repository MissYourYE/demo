package com.dubm.apply.mybatis.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    Long id;
    String acct;
    String deptId;
}
