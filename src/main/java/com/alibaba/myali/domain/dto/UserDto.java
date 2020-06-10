package com.alibaba.myali.domain.dto;

import com.alibaba.myali.validation.IsPhone;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 用户dto
 *
 * @author liuwei
 * @date 2020/05/12
 */
@Data
public class UserDto {


    private Integer id;

    private String wxId;

    @NotBlank(message = "微信昵称不能为空")
    private String wxNickname;

    @NotBlank(message = "角色不能为空")
    private String roles;

    private String avatarUrl;

    private Integer bonus;

    @IsPhone(message = "手机格式不正确")
    private String phone;

}
