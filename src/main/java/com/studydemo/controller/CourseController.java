package com.studydemo.controller;

import com.studydemo.Vo.CourseAllVo;
import com.studydemo.Vo.CourseVo;
import com.studydemo.Vo.RedisVo;
import com.studydemo.Vo.Result;
import com.studydemo.constant.stateCodeMsg;
import com.studydemo.entity.Course;
import com.studydemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("selectCourse")
    public Result<?> selectCourse(){
        try {
            List<Course> list1 = courseService.selectCourse();
            List<RedisVo> list2 = courseService.getCourseMessage();
            CourseAllVo courseAllVo = new CourseAllVo();
            courseAllVo.setList(list1);
            courseAllVo.setList1(list2);
            List<CourseAllVo> list = new ArrayList<>();
            list.add(courseAllVo);
            if (list == null){
                return Result.error(stateCodeMsg.NOT_FIND_DATA);
            }else {
                return Result.success(list);
            }
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }

    @PostMapping("GetCourse")
    public Result<?> getCourse(@RequestBody CourseVo courseVo){
        try {
            boolean flag;
            flag = courseService.getCourse(courseVo.getUserId(), courseVo.getCourseName(),
                    courseVo.getCourseId());
            if (flag == false){
                return Result.error(stateCodeMsg.OPERATE_FAILED);
            }else {
                return Result.success(stateCodeMsg.SUCCESS);
            }
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }
}
