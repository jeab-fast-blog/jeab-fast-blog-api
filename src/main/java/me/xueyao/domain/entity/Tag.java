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
 * @description: 标签
 * @author: Simon.Xue
 * @date: 2019-02-26 12:41
 **/
@Data
@Table(name = "tag")
@Entity
@Where(clause = "use_deleted = 0")
@Accessors(chain = true)
@SQLDelete(sql = "update tag set use_deleted = 1 where id = ?")

public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;
    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名")
    @Column(name = "name", columnDefinition = "varchar(255)  comment '标签名'")
    private String name;
    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    @Column(name = "alias", columnDefinition = "varchar(255)  comment '别名'")
    private String alias;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @Column(name = "user_deleted", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
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
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @Column(name = "sort", columnDefinition = "int  comment '排序'")
    private Integer sort;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    @Column(name = "description", columnDefinition = "varchar(255)  comment '摘要'")
    private String description;

}
