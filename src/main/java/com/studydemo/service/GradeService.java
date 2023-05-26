package com.studydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studydemo.Vo.GradeVo;
import com.studydemo.entity.Grades;

import javax.transaction.Transactional;
import java.util.List;

public interface GradeService extends IService<Grades> {
    List<Grades> selectGrade (GradeVo gradeVo);

    List<Grades> selectGradeByName (String name);

    void insertGrade (GradeVo gradeVo);

    void removeGrade (Integer ids[]);

    void updateGrade(Integer scores,Integer id);

    List<Grades> selectCourse(String userId);

    List<Grades> selectCourseNoPass(GradeVo gradeVo);
}
