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
 * @description: 评论
 * @author: Simon.Xue
 * @date 2022-03-07 16:55:49
 **/
@Data
@Table(name = "comment")
@Entity
@Where(clause = "use_deleted = 0")
@Accessors(chain = true)
@SQLDelete(sql = "update comment set use_deleted = 1 where id = ?")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Column(name = "name", columnDefinition = "varchar(255) comment '名称'")
    private String name;
    /**
     * 正文
     */
    @ApiModelProperty(value = "正文")
    @Column(name = "content", columnDefinition = "text  comment '正文'")
    private String content;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @Column(name = "use_deleted", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Integer useDeleted;
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
     * 上层ID
     */
    @ApiModelProperty(value = "上层ID")
    @Column(name = "parent_id", columnDefinition = "int comment '上层ID'")
    private Integer parentId;
    /**
     * 资源ID
     */
    @ApiModelProperty(value = "资源ID")
    @Column(name = "resource_id", columnDefinition = "int comment '资源ID'")
    private Integer resourceId;
    /**
     * 评论类型 1文章 2页面
     */
    @ApiModelProperty(value = "评论类型 1文章 2页面")
    @Column(name = "type", columnDefinition = "int comment '评论类型 1文章 2页面'")
    private Integer type;

}
