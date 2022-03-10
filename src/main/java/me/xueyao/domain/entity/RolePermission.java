package me.xueyao.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 2019-11-30 23:58
 **/
@Data
@Accessors(chain = true)
@Entity
public class RolePermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;

    @ApiModelProperty(value = "角色ID")
    @Column(name = "role_id", columnDefinition = "int comment '角色ID'")
    private Integer roleId;
    @ApiModelProperty(value = "权限ID")
    @Column(name = "permission_id", columnDefinition = "int  comment '权限ID'")
    private Integer permissionId;
}
