package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.RoleAddDto;
import me.xueyao.domain.dto.RoleModifyDto;
import org.springframework.data.domain.Pageable;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:39
 **/
public interface RoleService {
    /**
     * 添加角色
     * @param roleAddDto
     * @return
     */
    R add(RoleAddDto roleAddDto);

    /**
     * 修改角色
     * @param role
     * @return
     */
    R modify(RoleModifyDto role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    R delete(Integer roleId);

    /**
     * 查询角色详情
     * @param roleId
     * @return
     */
    R getDetail(Integer roleId);

    /**
     * 获得角色下的权限列表
     * @param roleId
     * @return
     */
    R getPermissions(Integer roleId);

    /**
     * 角色列表
     * @param pageable
     * @return
     */
    R list(Pageable pageable);
}
