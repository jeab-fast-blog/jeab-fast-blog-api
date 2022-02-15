package me.xueyao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
}
