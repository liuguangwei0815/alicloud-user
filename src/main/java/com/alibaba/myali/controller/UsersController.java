package com.alibaba.myali.controller;

import com.alibaba.myali.domain.entity.user.User;
import com.alibaba.myali.result.Result;
import com.alibaba.myali.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author liuwei
 * @date 2020/05/14
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Result<User> getuser(@PathVariable Integer id){
        return Result.success(userService.findById(id));
    }
}
