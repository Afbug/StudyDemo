package com.studydemo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2023-05-15 15:22:28
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -68298652535470136L;
    /**
     * 学生学号
     */
    private Integer sid;

    private String password;

    private String userId;
    
    private String sname;
    
    private String sex;
    
    private Integer age;
    
    private String department;




}

