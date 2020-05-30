package com.alibaba.myali.exception;

import com.alibaba.myali.result.MsgCode;
import com.alibaba.myali.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GolobleExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptioinHandler(HttpServletRequest request,Exception e){

        //业务异常
        if(e instanceof BussinessException){
            MsgCode msgCode = ((BussinessException) e).getMsgCode();
            return Result.fail(msgCode);
        }

        //校验异常
        if(e instanceof BindException){
            List<ObjectError> allErrors = ((BindException) e).getAllErrors();
            ObjectError objectError = allErrors.get(0);
            return Result.fail(MsgCode.PARAMERROR.fillParam(objectError.getDefaultMessage()));
        }

        if(e instanceof MethodArgumentNotValidException){
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            return Result.fail(MsgCode.PARAMERROR.fillParam(objectError.getDefaultMessage()));
        }


        //其他异常
        log.error("异常:{}", e.getMessage());
        return Result.fail(MsgCode.SERVER_ERROR);
    }

}
