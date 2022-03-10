package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.PermissionAddDto;
import me.xueyao.domain.dto.PermissionModifyDto;
import org.springframework.data.domain.Pageable;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:38
 **/
public interface PermissionService {
    /**
     * 添加权限
     * @param permissionAddDto
     * @return
     */
    R add(PermissionAddDto permissionAddDto);

    /**
     * 修改权限
     * @param permissionModifyDto
     * @return
     */
    R modify(PermissionModifyDto permissionModifyDto);

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    R delete(Integer permissionId);

    /**
     * 查询权限详情
     * @param permissionId
     * @return
     */
    R getDetail(Integer permissionId);
    /**
     * 权限列表
     * @param pageable
     * @return
     */
    R list(Pageable pageable);
}
