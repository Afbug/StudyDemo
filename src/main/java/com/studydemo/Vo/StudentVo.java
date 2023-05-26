package com.studydemo.Vo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentVo {

    private String userId;

    private String sname;

    private String sex;

    private Integer age;

    private String department;

    private String password;
}
