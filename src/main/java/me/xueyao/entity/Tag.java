package me.xueyao.entity;

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
 * @description: 标签
 * @author: Simon.Xue
 * @date: 2019-02-26 12:41
 **/
@Data
@Table(name = "tag")
@Entity
@Where(clause = "is_deleted = 0")
@Accessors(chain = true)
@SQLDelete(sql = "update tag set is_deleted = 1 where id = ?")
@DynamicInsert
@DynamicUpdate
public class Tag implements Serializable {
    @Id
    private Integer id;
    /**
     * 标签名
     */
    private String name;
    /**
     * 别名
     */
    private String alias;
    /**
     * 是否删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
