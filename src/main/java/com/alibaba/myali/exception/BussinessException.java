package com.alibaba.myali.exception;

import com.alibaba.myali.result.MsgCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 业务逻辑层异常
 *
 * @author liuwei
 * @date 2020/05/12
 */
@Data
public class BussinessException extends RuntimeException {
    private MsgCode msgCode;

    public BussinessException(MsgCode msgCode) {
        this.msgCode = msgCode;
    }
}
