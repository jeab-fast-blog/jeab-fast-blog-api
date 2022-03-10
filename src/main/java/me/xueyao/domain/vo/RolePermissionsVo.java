package me.xueyao.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:15
 **/
@Data
public class RolePermissionsVo implements Serializable {
    private Integer id;
    /**
     * 角色名
     */
    private String roleName;

    private List<PermissionVo> permissionVoList;
}
