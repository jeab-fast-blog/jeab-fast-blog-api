package me.xueyao.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:20
 **/
@Data
public class PermissionPageVo implements Serializable {

    private Integer id;
    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String permissionName;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除 0未删除 1删除")
    private Integer useDeleted;


}
