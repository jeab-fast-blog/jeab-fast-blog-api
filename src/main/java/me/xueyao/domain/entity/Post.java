package me.xueyao.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
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

public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;
    /**
     * 文章作者
     */
    @ApiModelProperty(value = "文章作者")
    @Column(name = "user_id", columnDefinition = "int comment '文章作者'")
    private Integer userId;
    /**
     * 文章时间
     */
    @ApiModelProperty(value = "文章时间")
    @Column(name = "post_date", columnDefinition = "datetime not null  comment '文章时间'")
    private LocalDateTime postDate;
    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题")
    @Column(name = "post_title", columnDefinition = "varchar(255) comment '密码'")
    private String postTitle;
    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容")
    @Column(name = "post_content", columnDefinition = "text comment '密码'")
    private String postContent;
    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id")
    @Column(name = "category_id", columnDefinition = "int comment '分类id'")
    private Integer categoryId;
    /**
     * 文章路径
     */
    @ApiModelProperty(value = "文章路径")
    @Column(name = "post_path_number", columnDefinition = "varchar(255) comment '文章路径'")
    private String postPathNumber;
    /**
     * 标签id
     */
    @ApiModelProperty(value = "标签id")
    @Column(name = "tag_id", columnDefinition = "int comment '标签id'")
    private Integer tagId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time", columnDefinition = "datetime default current_timestamp comment '创建时间'")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time", columnDefinition = "datetime default current_timestamp on update current_timestamp comment '更新时间'")
    private LocalDateTime updateTime;
    /**
     * 使用删除
     */
    @ApiModelProperty(value = "使用删除")
    @Column(name = "user_deleted", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Integer useDeleted;

    /**
     * 使用置顶
     */
    @ApiModelProperty(value = "使用置顶")
    @Column(name = "use_top", columnDefinition = "int comment '使用置顶'")
    private Integer useTop;

    /**
     * 使用禁止评论
     */
    @ApiModelProperty(value = "使用禁止评论")
    @Column(name = "use_comment", columnDefinition = "int comment '使用禁止评论'")
    private Integer useComment;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Column(name = "status", columnDefinition = "int comment '状态'")
    private Integer status;

    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    @Column(name = "alias", columnDefinition = "varchar(64) comment '别名'")
    private String alias;



}
