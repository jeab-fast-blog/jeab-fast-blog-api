package me.xueyao.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: 标签
 * @author: Simon.Xue
 * @date: 2019-02-26 12:41
 **/
@Data
@Where(clause = "use_deleted = 0")
@Accessors(chain = true)
public class TagPageVo implements Serializable {

    private Integer id;
    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名")
    private String name;
    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    private String alias;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer useDeleted;
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
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String description;

}
