package com.studydemo.controller;

import com.studydemo.Vo.LoginSuccessVo;
import com.studydemo.Vo.LoginVo;
import com.studydemo.Vo.Result;
import com.studydemo.Vo.StudentVo;
import com.studydemo.constant.stateCodeMsg;
import com.studydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/Login")
     public Result<?> Login(@RequestBody LoginVo loginVo){
        try {
            LoginSuccessVo loginSuccessVo = new LoginSuccessVo();
            loginSuccessVo = studentService.login(loginVo);
            return Result.success(loginSuccessVo);
        }catch (Exception e){
            return Result.error(stateCodeMsg.BUSINESS_ERROR);
        }
     }

    @PostMapping("/UpdateMessage")
     public Result<?> update(@RequestBody StudentVo studentVo){
        try {
            studentService.updateStudent(studentVo);
            return Result.error(stateCodeMsg.SUCCESS);
        }catch (Exception e){
            return Result.error(stateCodeMsg.OPERATE_FAILED);
        }
     }
     @PostMapping("/Insert")
    public Result insert(@RequestBody StudentVo studentVo){
        try{
            studentService.updateStudent(studentVo);
            return Result.success(stateCodeMsg.SUCCESS);
        }catch (Exception e){
            return Result.error(stateCodeMsg.ADD_DATA_ERROR);
        }
     }
}
