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
@Table(name = "attachment")
@Entity
@Where(clause = "use_deleted = 0")
@Accessors(chain = true)
@SQLDelete(sql = "update attachment set use_deleted = 1 where id = ?")
public class Attachment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Column(name = "name", columnDefinition = "varchar(64) comment '名称'")
    private String name;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @Column(name = "use_deleted", columnDefinition = "int default 0 comment '是否删除'")
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
     * 文件大小
     */
    @ApiModelProperty(value = "文件大小")
    @Column(name = "size", columnDefinition = "int comment '创建时间'")
    private Integer size;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    @Column(name = "file_type", columnDefinition = "int comment '创建时间'")
    private String fileType;

}
