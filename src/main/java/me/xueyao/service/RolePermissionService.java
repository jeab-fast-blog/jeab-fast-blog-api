package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.entity.dto.RolePermissionAddDto;
import me.xueyao.entity.RolePermission;
import org.springframework.data.domain.Pageable;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:41
 **/
public interface RolePermissionService {
    /**
     * 添加角色权限
     * @param rolePermissionAddDto
     * @return
     */
    R add(RolePermissionAddDto rolePermissionAddDto);

    /**
     * 修改角色权限
     * @param rolePermission
     * @return
     */
    R modify(RolePermission rolePermission);

    /**
     * 删除角色权限
     * @param roleId
     * @param permissionId
     * @return
     */
    R delete(Integer roleId, Integer permissionId);

    /**
     * 角色权限列表
     * @param roleId
     * @param pageable
     * @return
     */
    R list(Integer roleId, Pageable pageable);
}
