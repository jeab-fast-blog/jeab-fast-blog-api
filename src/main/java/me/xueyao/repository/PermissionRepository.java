package me.xueyao.repository;

import me.xueyao.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:31
 **/
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    /**
     * 查询权限
     * @param permissionName
     * @return
     */
    Permission findByPermissionName(String permissionName);

    /**
     * 查询指定id的权限
     * @param permissionIdList
     * @return
     */
    List<Permission> findByIdIn(List<Integer> permissionIdList);
}
