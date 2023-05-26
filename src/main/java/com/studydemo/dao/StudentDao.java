package com.studydemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.studydemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {


}
