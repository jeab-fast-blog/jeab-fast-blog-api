package me.xueyao.controller;

import me.xueyao.base.R;
import me.xueyao.entity.dto.RoleAddDto;
import me.xueyao.entity.dto.RoleModifyDto;
import me.xueyao.service.RoleService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:45
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody RoleAddDto roleAddDto) {
        return roleService.add(roleAddDto);
    }

    @PutMapping("/modify")
    public R modify(@Validated @RequestBody RoleModifyDto roleModifyDto) {
        return roleService.modify(roleModifyDto);
    }

    @DeleteMapping("/delete/{roleId}")
    public R delete(@PathVariable("roleId") Integer roleId) {
        return roleService.delete(roleId);
    }

    @GetMapping("/getDetail/{roleId}")
    public R getDetail(@PathVariable("roleId") Integer roleId) {
        return roleService.getDetail(roleId);
    }

    @GetMapping("/list")
    public R list(Pageable pageable) {
        return roleService.list(pageable);
    }
}
