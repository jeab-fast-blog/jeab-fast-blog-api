package me.xueyao.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: 常规选项
 * @author: Simon.Xue
 * @date: 2019-02-26 12:37
 **/
@Data
@Table(name = "option_general")
@Entity
@Where(clause = "use_deleted = 0")
@SQLDelete(sql = "update option_general set use_deleted = 1 where id = ?")
public class OptionGeneral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;
    /**
     * 网站标题
     */
    @ApiModelProperty(value = "网站标题")
    @Column(name = "site_title", columnDefinition = "varchar(255) comment '网站标题'")
    private String siteTitle;
    /**
     * 网站副标题
     */
    @ApiModelProperty(value = "网站副标题")
    @Column(name = "site_second_title", columnDefinition = "varchar(255) comment '网站副标题'")
    private String siteSecondTitle;
    /**
     * 站点地址
     */
    @ApiModelProperty(value = "站点地址")
    @Column(name = "site_address", columnDefinition = "varchar(255) comment '站点地址'")
    private String siteAddress;
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
     * 是否删除 0未删除 1删除
     */
    @Column(name = "use_deleted", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Integer useDeleted;

}
