package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.entity.RolePermission;
import me.xueyao.entity.dto.RolePermissionAddDto;
import me.xueyao.repository.RolePermissionRepository;
import me.xueyao.service.RolePermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:45
 **/
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public R add(RolePermissionAddDto rolePermissionAddDto) {
        RolePermission rolePermission = new RolePermission().setRoleId(rolePermissionAddDto.getRoleId());
        Example<RolePermission> rolePermissionExample = Example.of(rolePermission);

        List<RolePermission> rolePermissionList = rolePermissionRepository.findAll(rolePermissionExample);
        long count = rolePermissionList.stream()
                .filter(rp
                        -> rp.getPermissionId().equals(rolePermissionAddDto.getPermissionId()))
                .count();
        if (0 < count) {
            return R.ofParamError("不可以添加相同的权限");
        }
        BeanUtils.copyProperties(rolePermissionAddDto, rolePermission);
        rolePermissionRepository.save(rolePermission);
        return R.ofSuccess("权限绑定角色成功");
    }

    @Override
    public R modify(RolePermission rolePermission) {
        return null;
    }

    @Override
    public R delete(Integer roleId, Integer permissionId) {
        RolePermission rolePermission = new RolePermission().setPermissionId(permissionId).setRoleId(roleId);
        Example<RolePermission> permissionExample = Example.of(rolePermission);
        Optional<RolePermission> rolePermissionOptional = rolePermissionRepository.findOne(permissionExample);
        if (!rolePermissionOptional.isPresent()) {
            return R.ofParamError("该条信息不存在");
        }

        rolePermissionRepository.delete(new RolePermission().setRoleId(roleId).setPermissionId(permissionId));
        return R.ofSuccess("解除权限成功");
    }

    @Override
    public R list(Integer roleId, Pageable pageable) {
        RolePermission rolePermission = new RolePermission().setRoleId(roleId);
        Example<RolePermission> permissionExample = Example.of(rolePermission);
        Page<RolePermission> all = rolePermissionRepository.findAll(permissionExample, pageable);
        return R.ofSuccess("查询成功", all);
    }
}
