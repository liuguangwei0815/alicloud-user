package com.alibaba.myali.validation;

import com.alibaba.myali.utils.ValidataUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * 是手机验证器
 *
 * @author liuwei
 * @date 2020/05/13
 */
public class IsPhoneValidator implements ConstraintValidator<IsPhone,String> {
    boolean require = false;

    @Override
    public void initialize(IsPhone constraintAnnotation) {
        //获取标注注解的属性值
        require = constraintAnnotation.require();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(require){
            return ValidataUtil.validataPhone(value);
        }else{
            return true;
        }
    }
}
