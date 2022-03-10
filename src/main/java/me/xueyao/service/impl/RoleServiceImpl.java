package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.domain.entity.Permission;
import me.xueyao.domain.entity.Role;
import me.xueyao.domain.entity.RolePermission;
import me.xueyao.domain.dto.RoleAddDto;
import me.xueyao.domain.dto.RoleModifyDto;
import me.xueyao.domain.vo.PermissionVo;
import me.xueyao.domain.vo.RolePermissionsVo;
import me.xueyao.repository.PermissionRepository;
import me.xueyao.repository.RolePermissionRepository;
import me.xueyao.repository.RoleRepository;
import me.xueyao.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:45
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleRepository roleRepository;
    @Resource
    private PermissionRepository permissionRepository;
    @Resource
    private RolePermissionRepository rolePermissionRepository;
    @Override
    public R add(RoleAddDto roleAddDto) {
        Role role = new Role();
        role.setRoleName(roleAddDto.getRoleName());
        Example<Role> roleExample = Example.of(role);
        Optional<Role> roleOptional = roleRepository.findOne(roleExample);
        if (roleOptional.isPresent()) {
            return R.ofParamError("该角色已存在");
        }
        BeanUtils.copyProperties(roleAddDto, role);
        roleRepository.save(role);
        return R.ofSuccess("添加角色成功");
    }

    @Override
    public R modify(RoleModifyDto roleModifyDto) {
        Role role = new Role();
        role.setId(roleModifyDto.getId());
        Example<Role> roleExample = Example.of(role);
        Optional<Role> roleOptional = roleRepository.findOne(roleExample);
        if (!roleOptional.isPresent()) {
            return R.ofParamError("该角色不存在");
        }
        role = roleOptional.get();
        role.setRoleName(roleModifyDto.getRoleName());
        roleRepository.save(role);
        return R.ofSuccess("更新角色成功");
    }

    @Override
    public R delete(Integer roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (!roleOptional.isPresent()) {
            return R.ofParamError("角色信息不存在");
        }

        roleRepository.deleteById(roleId);
        return R.ofSuccess("删除角色成功");
    }

    @Override
    public R getDetail(Integer roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (!roleOptional.isPresent()) {
            return R.ofParamError("该角色信息不存在");
        }
        return R.ofSuccess("查询角色详情成功", roleOptional.get());
    }

    @Override
    public R getPermissions(Integer roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (!roleOptional.isPresent()) {
            return R.ofParamError("该角色信息不存在");
        }
        Example<RolePermission> rolePermissionExample = Example.of(new RolePermission().setRoleId(roleId));
        List<RolePermission> rolePermissionList = rolePermissionRepository.findAll(rolePermissionExample);
        List<Integer> permissionIdList = rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        List<Permission> permissionList = permissionRepository.findByIdIn(permissionIdList);
        RolePermissionsVo rolePermissionsVo = new RolePermissionsVo();
        BeanUtils.copyProperties(roleOptional.get(), rolePermissionsVo);
        List<PermissionVo> permissionVoList = permissionList.stream().map(permission -> {
            PermissionVo permissionVo = new PermissionVo()
                    .setPermissionName(permission.getPermissionName())
                    .setId(permission.getId());
            return permissionVo;
        }).collect(Collectors.toList());
        rolePermissionsVo.setPermissionVoList(permissionVoList);
        return R.ofSuccess("查询成功", rolePermissionsVo);
    }

    @Override
    public R list(Pageable pageable) {
        Page<Role> all = roleRepository.findAll(pageable);
        return R.ofSuccess("查询成功", all);
    }
}
