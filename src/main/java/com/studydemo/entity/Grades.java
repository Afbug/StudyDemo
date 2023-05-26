package com.studydemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Grades)实体类
 *
 * @author makejava
 * @since 2023-05-15 15:23:49
 */
@Data
public class Grades implements Serializable {
    private static final long serialVersionUID = 205212241142426247L;

    private Integer id;

    private String userId;
    
    private Integer courseId;
    
    private Integer scores;

    private String courseName;



}

