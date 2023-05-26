package com.studydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studydemo.Vo.LoginSuccessVo;
import com.studydemo.Vo.LoginVo;
import com.studydemo.Vo.StudentVo;
import com.studydemo.dao.StudentDao;
import com.studydemo.entity.Student;
import com.studydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao,Student> implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getByUserId(String userId) {
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("user_id",userId);
        return studentDao.selectOne(qw);
    }

    @Override
    public void insertStudent(StudentVo studentVo) {
        Student student = new Student();
        Student student1 = getByUserId(studentVo.getUserId());
        student.setSid(student1.getSid());
        student.setSname(studentVo.getSname());
        student.setSex(studentVo.getSex());
        student.setAge(studentVo.getAge());
        student.setDepartment(studentVo.getDepartment());
        studentDao.updateById(student);
    }

    @Override
    public void updateStudent(StudentVo studentVo) {
        Student student = new Student();
        Student student1 = getByUserId(studentVo.getUserId());
        student.setSid(student1.getSid());
        student.setPassword(studentVo.getPassword());
        student.setSname(studentVo.getSname());
        student.setSex(studentVo.getSex());
        student.setAge(studentVo.getAge());
        student.setDepartment(studentVo.getDepartment());
        studentDao.updateById(student);
    }

    @Override
    public LoginSuccessVo login(LoginVo vo) {
        Student student1 = new Student();
        Student student = getByUserId(vo.getUserId());
        LoginSuccessVo vo2 = new LoginSuccessVo();
        String token = "error";
        if (student==null){
             student1.setUserId(vo.getUserId());
             student1.setPassword(vo.getPassword());
             save(student1);
             token = "success";
        }else if(student!=null){
            if (!vo.getPassword().equals(student.getPassword())){
                token = "password error";
            }else if (vo.getPassword().equals(student.getPassword())){
                token = "success";
            }
        }
        vo2.setToken(token);
        vo2.setUserId(vo.getUserId());
        System.out.println(token);
        return vo2;
    }


}
