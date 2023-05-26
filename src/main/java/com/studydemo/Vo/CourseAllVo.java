package com.studydemo.Vo;

import com.studydemo.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class CourseAllVo {
    private List<Course> list;

    private List<RedisVo> list1;
}
