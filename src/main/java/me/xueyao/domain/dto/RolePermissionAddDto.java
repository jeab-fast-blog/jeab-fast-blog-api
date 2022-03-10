package me.xueyao.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 2019-11-30 23:58
 **/
@Data
@Accessors(chain = true)
public class RolePermissionAddDto implements Serializable {
    private Integer roleId;
    private Integer permissionId;
}
