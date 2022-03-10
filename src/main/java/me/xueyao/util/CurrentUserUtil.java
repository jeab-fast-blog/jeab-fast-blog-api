package me.xueyao.util;

import cn.hutool.core.util.StrUtil;
import me.xueyao.constant.Constant;
import me.xueyao.domain.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 获得当前用户
 * @author simonxue
 */
public class CurrentUserUtil {

    public static UserVO getCurrentUser(){
        UserVO retUser = null;
        String token = null;
        if (null != ServletUtils.getRequest()) {
            HttpServletRequest request = ServletUtils.getRequest();
            token = request.getHeader("token");
        }

        RedisHelper redisUtils = SpringUtils.getBean(RedisHelper.class);

        if (StrUtil.isNotBlank(token)) {
            retUser = (UserVO)redisUtils.getBean(Constant.TOKEN_KEY + token, UserVO.class);
        }
        return retUser;
    }

    public static String getCurrentUserId(){
        return null != getCurrentUser() ? getCurrentUser().getId() : null;
    }

}
