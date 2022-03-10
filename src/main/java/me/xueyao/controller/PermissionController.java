package me.xueyao.controller;

import io.swagger.annotations.Api;
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

    @PostMapping("/add")
    public R add(@Validated @RequestBody PermissionAddDto permissionAddDto) {
        return permissionService.add(permissionAddDto);
    }

    @PutMapping("/modify")
    public R modify(@Validated @RequestBody PermissionModifyDto permissionModifyDto) {
        return permissionService.modify(permissionModifyDto);
    }


    @DeleteMapping("/delete/{permissionId}")
    public R delete(@PathVariable("permissionId") Integer permissionId) {
        return permissionService.delete(permissionId);
    }

    @GetMapping("/getDetail/{permissionId}")
    public R getDetail(@PathVariable("permissionId") Integer permissionId) {
        return permissionService.getDetail(permissionId);
    }

    @GetMapping("/list")
    public R list(Pageable pageable) {
        return permissionService.list(pageable);
    }
}
