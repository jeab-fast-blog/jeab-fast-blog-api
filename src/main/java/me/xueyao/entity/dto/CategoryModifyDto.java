package me.xueyao.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 分类
 * @author: Simon.Xue
 * @date: 2019-02-26 12:43
 **/
@Data
public class CategoryModifyDto implements Serializable {
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
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private String sort;
    /**
     * 父分类ID
     */
    @ApiModelProperty(value = "父分类ID")
    private String parentId;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String description;

}
