package me.xueyao.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: 文章
 * @author: Simon.Xue
 * @date: 2019-02-26 12:31
 **/
@Data
@Accessors(chain = true)
public class PostPageVo implements Serializable {


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
    private LocalDateTime postDate;
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
    private Integer tagId;
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
     * 使用删除
     */
    @ApiModelProperty(value = "使用删除")
    private Integer useDeleted;

    /**
     * 使用置顶
     */
    @ApiModelProperty(value = "使用置顶")
    private Integer useTop;

    /**
     * 使用禁止评论
     */
    @ApiModelProperty(value = "使用禁止评论")
    private Integer useComment;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    private String alias;



}
