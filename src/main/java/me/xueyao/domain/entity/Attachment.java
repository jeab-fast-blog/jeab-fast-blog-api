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
    @Column(name = "size", columnDefinition = "long comment '创建时间'")
    private Long size;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    @Column(name = "file_type", columnDefinition = "int comment '类型'")
    private String fileType;


    /**
     * 文件全名
     */
    @ApiModelProperty(value = "文件全名")
    @Column(name = "original_filename", columnDefinition = "varchar(255) not null comment '文件全名'")
    private String originalFilename;

    /**
     * 新文件名
     */
    @ApiModelProperty(value = "新文件名")
    @Column(name = "filename", columnDefinition = "varchar(255) not null comment '文件全名'")
    private String filename;
    /**
     * 文件的后缀
     */
    @ApiModelProperty(value = "文件的后缀")
    @Column(name = "suffix", columnDefinition = "varchar(64) not null comment '文件的后缀'")
    private String suffix;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    @Column(name = "filePath", columnDefinition = "varchar(255) not null comment '文件路径'")
    private String filePath;



}
