package me.xueyao.interceptor;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.constant.Constant;
import me.xueyao.exception.NoPermissionException;
import me.xueyao.exception.TokenException;
import me.xueyao.util.RedisHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Simon.Xue
 * @date 2022/2/11 5:24 PM
 **/
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Resource
    private RedisHelper redisHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            log.warn("token没有值，没有权限访问");
            throw new NoPermissionException("没有权限访问");
        }

        if (!redisHelper.containsKey(Constant.TOKEN_KEY + token)) {
            log.warn("token = {}, 已过期，请重新登陆", token);
            throw new TokenException("Token已过期");
        }
        return true;
    }
}
