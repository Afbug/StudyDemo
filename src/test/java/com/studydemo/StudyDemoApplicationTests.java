package com.studydemo;

import com.studydemo.Vo.CourseVo;
import com.studydemo.Vo.GradeVo;
import com.studydemo.Vo.LoginVo;
import com.studydemo.controller.CourseController;
import com.studydemo.service.CourseService;
import com.studydemo.service.GradeService;
import com.studydemo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class StudyDemoApplicationTests {
    @Autowired
    private StudentService service;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CourseController courseController;

    @Autowired
    private CourseService courseService;

    @Test
    void contextLoads() {
        LoginVo loginVo = new LoginVo();
        loginVo.setUserId("gqy");
        loginVo.setPassword("1234567");
        service.login(loginVo);
    }
    @Test
    void test1(){
        GradeVo gradeVo = new GradeVo();
        gradeVo.setCourseId(101);
        gradeVo.setUserId("gqy");
        System.out.println(gradeService.selectGrade(gradeVo));
    }

    @Test
    void test2(){
//        redisTemplate.opsForValue().set("redis","0");
        Object o = redisTemplate.opsForValue().get("hadoop");
        redisTemplate.opsForValue().increment("hadoop");
        if (Integer.parseInt((String) o)==100){
            System.out.println("y");
        }
        System.out.println(o);
    }
    @Test
    void test3(){
        String userId = "gqy";
        String courseName = "mysql";
        Integer courseId = 1;
        System.out.println(courseService.getCourse(userId,courseName,courseId));
    }
}
