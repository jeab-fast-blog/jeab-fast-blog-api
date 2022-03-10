package me.xueyao.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:15
 **/
@Data
public class RoleModifyDto implements Serializable {
    private Integer id;
    /**
     * 角色名
     */
    private String roleName;

    private Integer useDeleted;
}
