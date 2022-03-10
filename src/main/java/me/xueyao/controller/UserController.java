package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.UserAddDto;
import me.xueyao.domain.dto.UserModifyDto;
import me.xueyao.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-11-30 23:33
 **/
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "新增用户")
    @PostMapping("/add")
    public R add(@Validated @RequestBody UserAddDto userAddDto) {
        return userService.add(userAddDto);
    }

    @ApiOperation(value = "修改用户")
    @PutMapping("/modify")
    public R modify(@Validated @RequestBody UserModifyDto userModifyDto) {
        return userService.modify(userModifyDto);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete")
    public R delete(@RequestParam("userId") String userId) {
        return userService.delete(userId);
    }

    @ApiOperation(value = "查询用户详情")
    @GetMapping("/getDetail/{userId}")
    public R getDetail(@PathVariable("userId") String userId) {
        return userService.getDetail(userId);
    }

    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    public R list(Pageable pageable) {
        return userService.list(pageable);
    }


}
