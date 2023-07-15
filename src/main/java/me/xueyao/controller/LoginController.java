package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.ForgetPasswordDto;
import me.xueyao.domain.dto.LoginDto;
import me.xueyao.domain.dto.RegisterDto;
import me.xueyao.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 公共操作
 * @author Simon.Xue
 * @date 1/28/21 2:50 PM
 **/
@Api(tags = "公共入口")
@RestController
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 登陆
     * @param loginDto
     * @return
     */
    @ApiOperation(value = "登陆")
    @PostMapping("/login")
    public R login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    /**
     * 当前用户
     * @return
     */
    @ApiOperation(value = "当前用户")
    @GetMapping("/current_user")
    public R currentUser() {
        return userService.currentUser();
    }


    /**
     * 退出
     * @return
     */
    @ApiOperation(value = "退出")
    @PostMapping("/logout")
    public R logout(HttpServletRequest request) {
        return userService.logout(request);
    }

    /**
     * 注册
     * @return
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public R register(@Validated @RequestBody RegisterDto registerDto) {
        return userService.register(registerDto);
    }

    /**
     * 忘记密码  邮箱
     * @param forgetPasswordDto
     * @return
     */
    @ApiOperation(value = "忘记密码")
    @PostMapping("/forget_password")
    public R forgetPassword(@Validated @RequestBody ForgetPasswordDto forgetPasswordDto) {
        return userService.forgetPassword(forgetPasswordDto);
    }
}
