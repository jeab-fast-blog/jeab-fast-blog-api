package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.entity.Permission;
import me.xueyao.entity.dto.PermissionAddDto;
import me.xueyao.entity.dto.PermissionModifyDto;
import me.xueyao.repository.PermissionRepository;
import me.xueyao.service.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:44
 **/
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionRepository permissionRepository;
    @Override
    public R add(PermissionAddDto permissionAddDto) {
        Permission permission = permissionRepository.findByPermissionName(permissionAddDto.getPermissionName());
        if (null != permission) {
            return R.ofParamError("不可以添加相同名称的权限");
        }
        permission = new Permission();
        BeanUtils.copyProperties(permissionAddDto, permission);
        permissionRepository.save(permission);
        return R.ofSuccess("添加权限成功");
    }

    @Override
    public R modify(PermissionModifyDto permissionModifyDto) {
        Optional<Permission> permissionOptional = permissionRepository.findById(permissionModifyDto.getId());
        if (!permissionOptional.isPresent()) {
            return R.ofParamError("该权限不存在");
        }
        Permission permission = permissionOptional.get();
        permission.setPermissionName(permissionModifyDto.getPermissionName());
        permission.setUpdateTime(LocalDateTime.now());
        permissionRepository.save(permission);
        return R.ofSuccess("更新权限成功");
    }

    @Override
    public R delete(Integer permissionId) {
        Optional<Permission> permissionOptional = permissionRepository.findById(permissionId);
        if (!permissionOptional.isPresent()) {
            return R.ofParamError("该权限不存在");
        }
        permissionRepository.deleteById(permissionId);
        return R.ofSuccess("删除权限成功");
    }

    @Override
    public R getDetail(Integer permissionId) {
        Optional<Permission> permissionOptional = permissionRepository.findById(permissionId);
        if (!permissionOptional.isPresent()) {
            return R.ofParamError("该权限不存在");
        }
        return R.ofSuccess("查询权限详情成功", permissionOptional.get());
    }

    @Override
    public R list(Pageable pageable) {
        Page<Permission> permissionPage = permissionRepository.findAll(pageable);
        return R.ofSuccess("查询成功", permissionPage);
    }
}
