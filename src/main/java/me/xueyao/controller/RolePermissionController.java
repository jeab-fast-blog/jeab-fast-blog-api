package me.xueyao.controller;

import me.xueyao.base.R;
import me.xueyao.entity.dto.RolePermissionAddDto;
import me.xueyao.service.RolePermissionService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:44
 **/
@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {

    @Resource
    private RolePermissionService rolePermissionService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody RolePermissionAddDto rolePermissionAddDto) {
        return rolePermissionService.add(rolePermissionAddDto);
    }


    @DeleteMapping("/delete/{roleId}/{permissionId}")
    public R delete(@PathVariable("roleId") Integer roleId,
                    @PathVariable("permissionId") Integer permissionId) {
        return rolePermissionService.delete(roleId, permissionId);
    }

    @GetMapping("/list/{roleId}")
    public R list(@PathVariable("roleId") Integer roleId, Pageable pageable) {
        return rolePermissionService.list(roleId, pageable);
    }

}
