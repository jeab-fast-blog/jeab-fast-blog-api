package me.xueyao.entity;

import lombok.Data;
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
 * @description: 常规选项
 * @author: Simon.Xue
 * @date: 2019-02-26 12:37
 **/
@Data
@Table(name = "option_general")
@Entity
@Where(clause = "is_deleted = 0")
@SQLDelete(sql = "update option_general set is_deleted = 1 where id = ?")
@DynamicInsert
@DynamicUpdate
public class OptionGeneral implements Serializable {

    @Id
    private Integer id;
    /**
     * 网站标题
     */
    private String siteTitle;
    /**
     * 网站副标题
     */
    private String siteSecondTitle;
    /**
     * 站点地址
     */
    private String siteAddress;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private Integer isDeleted;

}
