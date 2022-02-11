package me.xueyao.exception;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.base.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Note: 统一异常处理
 * @author Simon.Xue
 * @date 2022-02-11 17:41:23
 */
@Slf4j
@ControllerAdvice
public class GlobalDefaultExceptionHandler {


    /**
     * @Note: 访问权限异常处理器
     * @Author: Kidd.shi
     * @Create: 2018/11/8 11:46
     * */
    @ExceptionHandler(NoPermissionException.class)
    @ResponseBody
    public R noPermissionException(HttpServletRequest request, Exception e) {
        return new R(R.CODE_AUTHORITY_ERROR, e.getMessage());
    }
    
    /**
     * 客户端参数非法异常处理
     * @date   2019-03-07
     */
    @ExceptionHandler(ParamIllegalException.class)
    @ResponseBody
    public R paramIllegalException(HttpServletRequest request, ParamIllegalException e) {
        return R.ofParam(e.getMessage());
    }


    /**
     * @Note: Token异常
     * @Author: Kidd.shi
     * @Create: 2018/11/8 11:46
     * */
    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public Object tokenException(HttpServletRequest request, Exception e) {
        return new R(R.CODE_AUTHORITY_ERROR, e.getMessage());
    }

    /**
     * 声明要捕获的异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object defaultExceptionHandler(HttpServletRequest request,Exception e) {
        log.error("统一异常处理：message = {}", e.getMessage());
        return R.ofParam(e.getMessage());

    }







}
