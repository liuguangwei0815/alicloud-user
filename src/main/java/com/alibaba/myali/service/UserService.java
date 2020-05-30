package com.alibaba.myali.service;

import com.alibaba.myali.dao.user.UserMapper;
import com.alibaba.myali.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//使用lombok的方式去掉idea 的 autowrie 对maybatis的警告
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMapper userMapper;

    public boolean save(User user) {
        //这个是如果你set多少个值就有多少个
        //userMapper.insertSelective();
        return userMapper.insertSelective(user) > 0;
    }

    /**
     * 发现通过id
     *
     * @param id id
     * @return {@link User}
     */
    public User findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }


    /**
     * 发现通过wx id
     *
     * @param wxId wx id
     * @return {@link User}
     */
    public User findByWxId(String wxId){
        return userMapper.selectByWxId(wxId);
    }



}
