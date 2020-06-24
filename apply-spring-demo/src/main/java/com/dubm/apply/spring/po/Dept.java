package com.dubm.apply.spring.po;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dept {
    private Long id;
//    @Value("研发部")
    private String deptName;
    private String type;
}
