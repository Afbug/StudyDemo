package com.studydemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.studydemo.Vo.GradeVo;
import com.studydemo.entity.Grades;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GradeDao extends BaseMapper<Grades> {
    List<Grades> selectGrade(@Param("gradeVo") GradeVo gradeVo);//动态查询cj

    void deleteByIds(@Param("ids") Integer[] ids);

    @Select("select course_id,scores from grades e left join student m on e.user_id = m.user_id where m.sname = #{name};")
    List<Grades> selectGradeByName(@Param("name") String name);

    @Update("update grades set scores = #{scores} where id = #{id}")
    void updateGrade(@Param("scores") Integer scores,@Param("id") Integer id);

    @Select("select course_name from grades where user_id = #{userId}")
    List<Grades> selectCourse(@Param("userId") String userId);

    @Select("select course_name from grades where user_id = #{userId} and scores < 60")
    List<Grades> selectNoPassCourse(@Param("userId") String userId);

    @Insert("insert into grades(user_id,course_id,scores,course_name) values (#{userId},#{courseId},null,#{courseName})")
    void insertCourse(@Param("userId")String userId,@Param("courseName")String courseName,@Param("courseId")Integer courseId);

    @Select("select * from grades where user_id = #{userId} and course_name = #{courseName}")
    List<Grades> selectHasCourse(@Param("userId")String userId,@Param("courseName")String courseName);

    @Select("select course_name from grades where id = #{id}")
    Grades selectByIdGrades(@Param("id") Integer id);

    @Insert("insert into grades(user_id,course_id,scores,course_name) values(#{userId},#{courseId},#{scores},#{courseName})")
    void insetId(@Param("userId")String userId,@Param("courseName")String courseName,@Param("courseId")Integer courseId,@Param("scores") Integer scores);
}
