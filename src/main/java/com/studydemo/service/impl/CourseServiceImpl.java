package com.studydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studydemo.Vo.RedisVo;
import com.studydemo.dao.CourseDao;
import com.studydemo.dao.GradeDao;
import com.studydemo.entity.Course;
import com.studydemo.entity.Grades;
import com.studydemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course> implements CourseService {

    @Autowired
    private CourseDao dao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<Course> selectCourse() {
        return dao.getCourse();
    }

    @Override
    public List<RedisVo> getCourseMessage() {
        List<Course> list = dao.getCourse();
        System.out.println(list);
        List<String> courseName = new ArrayList<>();
        for (Course course : list ){
            courseName.add(course.getCourseName());
        }
        List<RedisVo> result = new ArrayList<>();
        for (int i = 0; i < courseName.size(); i++) {
            RedisVo redisVo = new RedisVo();
            redisVo.setCourse(courseName.get(i));
            Object num = redisTemplate.opsForValue().get(courseName.get(i));
            redisVo.setNum(Integer.parseInt((String) num));
            result.add(redisVo);
        }
        System.out.println(result);
        return result;

    }

    @Override
    public boolean getCourse(String userId,String courseName,Integer courseId) {
        boolean result;
        Object num = redisTemplate.opsForValue().get(courseName);
        List<Grades> list = gradeDao.selectHasCourse(userId, courseName);
        System.out.println(num);
         if (list.size() != 0 || Integer.parseInt((String) num) <= 0){
            result = false;
        }else{
             redisTemplate.opsForValue().decrement(courseName);
             gradeDao.insertCourse(userId,courseName,courseId);
             result = true;
         }
        return result;
    }
}
