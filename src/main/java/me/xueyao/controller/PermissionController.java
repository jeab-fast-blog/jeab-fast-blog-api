package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.PermissionAddDto;
import me.xueyao.domain.dto.PermissionModifyDto;
import me.xueyao.service.PermissionService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:43
 **/
@Api(tags = "权限管理")
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @ApiOperation(value = "添加权限")
    @PostMapping("/add")
    public R add(@Validated @RequestBody PermissionAddDto permissionAddDto) {
        return permissionService.add(permissionAddDto);
    }

    @ApiOperation(value = "修改权限")
    @PostMapping("/modify")
    public R modify(@Validated @RequestBody PermissionModifyDto permissionModifyDto) {
        return permissionService.modify(permissionModifyDto);
    }

    @ApiOperation(value = "删除权限")
    @GetMapping("/delete")
    public R delete(@RequestParam("permissionId") Integer permissionId) {
        return permissionService.delete(permissionId);
    }

    @ApiOperation(value = "获得权限详情")
    @GetMapping("/getDetail")
    public R getDetail(@RequestParam("permissionId") Integer permissionId) {
        return permissionService.getDetail(permissionId);
    }

    @ApiOperation(value = "权限列表")
    @GetMapping("/list")
    public R list(Pageable pageable) {
        return permissionService.list(pageable);
    }
}
