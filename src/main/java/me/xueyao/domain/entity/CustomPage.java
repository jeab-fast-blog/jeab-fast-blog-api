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
 * @description: 页面
 * @author: Simon.Xue
 * @date 2022-03-07 17:24:08
 **/
@Data
@Table(name = "custom_page")
@Entity
@Accessors(chain = true)
@Where(clause = "use_deleted = 0")
@SQLDelete(sql = "update custom_page set use_deleted = 1 where id = ?")
public class CustomPage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;
    /**
     * 页面作者
     */
    @ApiModelProperty(value = "页面作者")
    @Column(name = "use_id", columnDefinition = "int comment '页面作者'")
    private Integer userId;
    /**
     * 页面时间
     */
    @ApiModelProperty(value = "页面时间")
    @Column(name = "page_date", columnDefinition = "datetime comment '页面时间'")
    private LocalDateTime pageDate;
    /**
     * 页面标题
     */
    @ApiModelProperty(value = "页面标题")
    @Column(name = "page_title", columnDefinition = "varchar(255) comment '页面标题'")
    private String pageTitle;
    /**
     * 页面内容
     */
    @ApiModelProperty(value = "页面内容")
    @Column(name = "page_content", columnDefinition = "text comment '页面内容'")
    private String pageContent;


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
    @Column(name = "use_deleted", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Integer useDeleted;


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
