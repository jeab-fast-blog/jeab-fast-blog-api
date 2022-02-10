package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.entity.dto.LoginDto;

/**
 * @author Simon.Xue
 * @date 1/28/21 2:50 PM
 **/
public interface UserService {
    /**
     * 用户登录
     * @param loginDto
     * @return
     */
    R login(LoginDto loginDto);

    /**
     * 当前用户信息
     * @param id
     * @return
     */
    R currentUser(Integer id);
}
