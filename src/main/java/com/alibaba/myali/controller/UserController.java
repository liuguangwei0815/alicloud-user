package com.alibaba.myali.controller;

import com.alibaba.myali.domain.dto.UserDto;
import com.alibaba.myali.domain.entity.user.User;
import com.alibaba.myali.result.Result;
import com.alibaba.myali.service.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * 用户控制器
 *
 * @author liuwei
 * @date 2020/05/12
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Result<User> testINserUser(@RequestBody @Valid UserDto userDto){
        //测试git 版本回滚操作1
        //参数封装
        User user = getUser(userDto);
        userService.save(user);
        return  Result.success(user);
    }

    private User getUser(@RequestBody @Valid UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setCreateTime(new Date());
        return user;
    }

}
