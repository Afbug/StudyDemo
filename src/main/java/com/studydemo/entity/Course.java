package com.studydemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2023-05-15 15:25:01
 */
@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 895916611667095663L;
    
    private Integer id;
    
    private String courseName;
    
    private Integer courseId;



}

