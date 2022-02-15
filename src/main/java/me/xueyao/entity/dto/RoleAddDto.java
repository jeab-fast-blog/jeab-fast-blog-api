package me.xueyao.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:15
 **/
@Data
public class RoleAddDto implements Serializable {
    /**
     * 角色名
     */
    private String roleName;
}
