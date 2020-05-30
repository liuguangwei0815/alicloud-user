package com.alibaba.myali.dao.user;

import com.alibaba.myali.domain.entity.user.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    User selectByWxId(String wxId);
}