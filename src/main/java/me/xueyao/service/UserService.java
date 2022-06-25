package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.LoginDto;
import me.xueyao.domain.dto.RegisterDto;
import me.xueyao.domain.dto.UserAddDto;
import me.xueyao.domain.dto.UserModifyDto;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;

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
     * @return
     */
    R currentUser();

    /**
     * 退出登录
     * @return
     */
    R logout(HttpServletRequest request);

    /**
     * 创建用户
     * @param userAddDto
     * @return
     */
    R add(UserAddDto userAddDto);

    /**
     * 更新用户
     * @param userModifyDto
     * @return
     */
    R modify(UserModifyDto userModifyDto);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    R delete(String userId);

    /**
     * 查询用户详情
     * @param userId
     * @return
     */
    R getDetail(String userId);
    /**
     * 用户列表
     * @param pageable
     * @return
     */
    R list(Pageable pageable);

    /**
     * 注册
     * @param registerDto
     * @return
     */
    R register(RegisterDto registerDto);
}
