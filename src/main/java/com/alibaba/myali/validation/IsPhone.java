package com.alibaba.myali.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import java.lang.annotation.*;

/**
 * 是否是手机
 *
 * @author liuwei
 * @date 2020/05/12
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(IsPhone.List.class)
@Documented
@Constraint(
        validatedBy = {IsPhoneValidator.class}
)
public @interface IsPhone {

    /**
     * 是否必须
     *
     * @return boolean
     */
    boolean require() default true;

    String message() default "{javax.validation.constraints.Max.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        IsPhone[] value();
    }
}
