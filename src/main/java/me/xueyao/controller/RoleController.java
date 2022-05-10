package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "添加角色")
    @PostMapping("/add")
    public R add(@Validated @RequestBody RoleAddDto roleAddDto) {
        return roleService.add(roleAddDto);
    }

    @ApiOperation(value = "更新角色")
    @PostMapping("/modify")
    public R modify(@Validated @RequestBody RoleModifyDto roleModifyDto) {
        return roleService.modify(roleModifyDto);
    }

    @ApiOperation(value = "删除角色")
    @GetMapping("/delete")
    public R delete(@RequestParam("roleId") Integer roleId) {
        return roleService.delete(roleId);
    }

    @ApiOperation(value = "获取角色详情")
    @GetMapping("/getDetail")
    public R getDetail(@RequestParam("roleId") Integer roleId) {
        return roleService.getDetail(roleId);
    }

    @ApiOperation(value = "角色列表")
    @GetMapping("/list")
    public R list(Pageable pageable) {
        return roleService.list(pageable);
    }
}
