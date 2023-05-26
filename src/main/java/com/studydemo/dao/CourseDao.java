package com.studydemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.studydemo.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseDao extends BaseMapper<Course> {
    @Select("select * from Course ")
    List<Course> getCourse();
}
