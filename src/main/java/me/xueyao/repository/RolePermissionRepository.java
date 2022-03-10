package me.xueyao.repository;

import me.xueyao.domain.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:28
 **/
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {
    /**
     * 查询角色下的权限列表
     * @param roleId
     * @return
     */
    List<RolePermission> findByRoleId(Integer roleId);
}
