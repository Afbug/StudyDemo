package com.studydemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.studydemo.Vo.RedisVo;
import com.studydemo.entity.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
        List<Course> selectCourse();

        List<RedisVo> getCourseMessage();

        boolean getCourse(String userId,String courseName,Integer courseId);

}
