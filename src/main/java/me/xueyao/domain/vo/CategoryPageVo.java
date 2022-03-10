package me.xueyao.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 分类
 * @author: Simon.Xue
 * @date: 2019-02-26 12:43
 **/
@Data
@Where(clause = "use_deleted = 0")
@Accessors(chain = true)
public class CategoryPageVo implements Serializable {

    private Integer id;
    /**
     * 分类姓名
     */
    @ApiModelProperty(value = "分类姓名")
    private String name;
    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    private String alias;
    /**
     * 删除
     */
    @ApiModelProperty(value = "删除")
    private Integer useDeleted;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 父分类ID 顶级为0
     */
    @ApiModelProperty(value = "父分类ID 顶级为0")
    private Integer parentId;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String description;

    /**
     * 文章数量
     */
    @ApiModelProperty(value = "文章数量")
    private String articleNum;
}
