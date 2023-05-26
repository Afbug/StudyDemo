package com.studydemo.controller;

import com.studydemo.Vo.GradeVo;
import com.studydemo.Vo.Result;
import com.studydemo.Vo.StudentVo;
import com.studydemo.constant.stateCodeMsg;
import com.studydemo.entity.Grades;
import com.studydemo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Grades")
public class GradeServiceController {
    @Autowired
    private GradeService gradeService;


    @PostMapping("/a")//查询课程和学号成绩
    public Result<?> selectGrade(@RequestBody GradeVo gradeVo){
        try {
            List<Grades> g = gradeService.selectGrade(gradeVo);
            if (g.equals(null)){
                return Result.error(stateCodeMsg.NOT_FIND_DATA);
            }else {
                return Result.success(g);
            }
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }

    @PostMapping("/b")
    public Result<?> selectGradeName(@RequestBody StudentVo studentVo){
        try {
            String name = studentVo.getSname();
            if (name.equals(null)){
                return Result.error(stateCodeMsg.NOT_FIND_DATA);
            }else {
                List<Grades> grades = gradeService.selectGradeByName(name);
                return Result.success(grades);
            }
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }

    @PostMapping("/c")
    public Result<?> selectCourse(@RequestBody GradeVo gradeVo){
        try {
            String userId = gradeVo.getUserId();
            if (userId.equals(null)){
                return Result.error(stateCodeMsg.NOT_FIND_DATA);
            }else{
                List<Grades> grades = gradeService.selectCourse(userId);
                return Result.success(grades);
            }
        }catch(Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }

    @PostMapping("/d")
    public Result<?> selectNoPass(@RequestBody GradeVo gradeVo){
        try {
            List<Grades> list = gradeService.selectCourseNoPass(gradeVo);
            return Result.success(list);
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }

    @PostMapping("/e")
    public Result<?> insert(@RequestBody GradeVo gradeVo){
        try {
            gradeService.insertGrade(gradeVo);
            return Result.success(stateCodeMsg.SUCCESS);
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }

    @PostMapping("/f")
    public Result<?> update(@RequestBody GradeVo gradeVo){
        try {
            Integer id = gradeVo.getId();
            Integer scores = gradeVo.getScores();
            gradeService.updateGrade(scores, id);
            return Result.success(stateCodeMsg.SUCCESS);
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
    }

    @DeleteMapping("/g")
    public Result<?> delete(@RequestBody Integer ids[]){
        try {
            gradeService.removeGrade(ids);
            return Result.success(stateCodeMsg.SUCCESS);
        }catch (Exception e){
            return Result.error(stateCodeMsg.OPERATE_FAILED);
        }
    }
}
