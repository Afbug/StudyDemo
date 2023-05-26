package com.studydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studydemo.Vo.GradeVo;
import com.studydemo.dao.GradeDao;
import com.studydemo.entity.Grades;
import com.studydemo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl extends ServiceImpl<GradeDao, Grades> implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Grades> selectGrade(GradeVo gradeVo) {
        return gradeDao.selectGrade(gradeVo);
    }

    @Override
    public List<Grades> selectGradeByName(String name) {
        return gradeDao.selectGradeByName(name);
    }

    @Override
    public void insertGrade(GradeVo gradeVo) {
        gradeDao.insetId(gradeVo.getUserId(), gradeVo.getCourseName(), gradeVo.getCourseId(),gradeVo.getScores());
    }

    @Override
    public void removeGrade(Integer ids[]) {
        for (int i = 0; i < ids.length; i++) {
            Grades grades = gradeDao.selectByIdGrades(ids[i]);
            if (redisTemplate.opsForValue().get(grades.getCourseName()) != null){
                redisTemplate.opsForValue().increment(grades.getCourseName());
            }
        }
        gradeDao.deleteByIds(ids);
    }

    @Override
    public void updateGrade(Integer scores,Integer id) {
        gradeDao.updateGrade(scores,id);
    }

    @Override
    public List<Grades> selectCourse(String userId) {
        return gradeDao.selectCourse(userId);
    }

    @Override
    public List<Grades> selectCourseNoPass(GradeVo gradeVo) {
        String userId = gradeVo.getUserId();
        return gradeDao.selectNoPassCourse(userId);
    }
}
