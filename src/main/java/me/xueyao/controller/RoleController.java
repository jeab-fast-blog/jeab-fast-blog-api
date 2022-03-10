package me.xueyao.controller;

import io.swagger.annotations.Api;
import me.xueyao.base.R;
import me.xueyao.domain.dto.RoleAddDto;
import me.xueyao.domain.dto.RoleModifyDto;
import me.xueyao.service.RoleService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:45
 **/
@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody RoleAddDto roleAddDto) {
        return roleService.add(roleAddDto);
    }

    @PostMapping("/modify")
    public R modify(@Validated @RequestBody RoleModifyDto roleModifyDto) {
        return roleService.modify(roleModifyDto);
    }

    @GetMapping("/delete")
    public R delete(@RequestParam("roleId") Integer roleId) {
        return roleService.delete(roleId);
    }

    @GetMapping("/getDetail")
    public R getDetail(@RequestParam("roleId") Integer roleId) {
        return roleService.getDetail(roleId);
    }

    @GetMapping("/list")
    public R list(Pageable pageable) {
        return roleService.list(pageable);
    }
}
