package me.xueyao.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @description: 文章
 * @author: Simon.Xue
 * @date: 2019-02-26 12:31
 **/
@Data
@Accessors(chain = true)
public class PostAddDto implements Serializable {

    @Id
    private Integer id;
    /**
     * 文章作者
     */
    @ApiModelProperty(value = "文章作者")
    private Integer userId;
    /**
     * 文章时间
     */
    @ApiModelProperty(value = "文章时间")
    private Date postDate;
    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题")
    private String postTitle;
    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容")
    private String postContent;
    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id")
    private Integer categoryId;
    /**
     * 文章路径
     */
    @ApiModelProperty(value = "文章路径")
    private String postPathNumber;
    /**
     * 标签id
     */
    @ApiModelProperty(value = "标签id")
    private Integer tagsId;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer useDeleted;

}
