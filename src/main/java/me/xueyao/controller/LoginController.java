package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.LoginDto;
import me.xueyao.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
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
    @GetMapping("/currentUser")
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
}
