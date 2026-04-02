package top.jzxue.week04.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import top.jzxue.week04.common.ResultVO;


import java.util.StringJoiner;


@org.springframework.web.bind.annotation.RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<?>handleValidException(MethodArgumentNotValidException e){
        StringJoiner sj = new StringJoiner(":");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()){
            sj.add(fieldError.getDefaultMessage());
        }
        return ResultVO.error(400,sj.toString());
    }
    @ExceptionHandler(BusinessException.class)
    public ResultVO<?>handleBusinessException(BusinessException e){
        return ResultVO.error(e.getCode(),e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResultVO<?> handleException(Exception e){
        return ResultVO.error(500,"服务器异常，请稍后再试");
    }
}
