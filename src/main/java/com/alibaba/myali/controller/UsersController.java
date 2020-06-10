package com.alibaba.myali.controller;

import com.alibaba.myali.domain.dto.UserDto;
import com.alibaba.myali.domain.entity.user.User;
import com.alibaba.myali.result.Result;
import com.alibaba.myali.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @author liuwei
 * @date 2020/05/14
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UsersController implements ApplicationListener<WebServerInitializedEvent> {

    private final UserService userService;

    private int port;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/{id}")
    public Result<User> getuser(@PathVariable Integer id){
        //测试git 版本回滚操作1
        log.info("端口号为：{}", port);
        return Result.success(userService.findById(id));
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
         port = event.getWebServer().getPort();
    }

    @GetMapping("/getmulpam")
    public User getmulpam(User user){
        return user;
    }

    @PostMapping("/getmulpam")
    public UserDto postgetmulpam(@RequestBody UserDto user){
        return user;
    }
}
