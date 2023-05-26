package com.studydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studydemo.Vo.LoginSuccessVo;
import com.studydemo.Vo.LoginVo;
import com.studydemo.Vo.StudentVo;
import com.studydemo.entity.Student;

import javax.transaction.Transactional;

public interface StudentService extends IService <Student>{
    LoginSuccessVo login (LoginVo vo);

    Student getByUserId(String userId);

    void insertStudent(StudentVo studentVo);

    void updateStudent(StudentVo studentVo);




}
