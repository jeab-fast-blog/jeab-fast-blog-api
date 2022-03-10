package me.xueyao.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:15
 **/
@Data
@Accessors(chain = true)
@Where(clause = "use_deleted = 0")
public class RolePageVo implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "角色名")
    private String roleName;
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

    /**
     * 是否删除 0未删除 1删除
     */
    @ApiModelProperty(value = "是否删除 0未删除 1删除")
    private Integer useDeleted;
}
