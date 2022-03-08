package me.xueyao.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:20
 **/
@Data
public class PermissionModifyDto implements Serializable {
    private Integer id;
    @ApiModelProperty(value = "")
    private String permissionName;

}
