package me.xueyao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: 文章
 * @author: Simon.Xue
 * @date: 2019-02-26 12:31
 **/
@Data
@Table(name = "post")
@Entity
@Accessors(chain = true)
@Where(clause = "use_deleted = 0")
@SQLDelete(sql = "update post set use_deleted = 1 where id = ?")
@DynamicInsert
@DynamicUpdate
public class Post implements Serializable {

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
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
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
