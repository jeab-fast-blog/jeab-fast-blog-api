package me.xueyao.controller;

import me.xueyao.base.R;
import me.xueyao.entity.dto.LoginDto;
import me.xueyao.entity.dto.UserAddDto;
import me.xueyao.entity.dto.UserModifyDto;
import me.xueyao.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-11-30 23:33
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody UserAddDto userAddDto) {
        return userService.add(userAddDto);
    }

    @PutMapping("/modify")
    public R modify(@Validated @RequestBody UserModifyDto userModifyDto) {
        return userService.modify(userModifyDto);
    }

    @DeleteMapping("/delete")
    public R delete(@RequestParam("userId") String userId) {
        return userService.delete(userId);
    }

    @GetMapping("/getDetail/{userId}")
    public R getDetail(@PathVariable("userId") String userId) {
        return userService.getDetail(userId);
    }

    @GetMapping("/list")
    public R list(Pageable pageable) {
        return userService.list(pageable);
    }

    @PostMapping("/login")
    public R login(@Validated @RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }


}
