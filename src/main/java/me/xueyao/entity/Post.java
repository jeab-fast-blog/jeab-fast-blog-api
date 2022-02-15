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
 * @description: 文章
 * @author: Simon.Xue
 * @date: 2019-02-26 12:31
 **/
@Data
@Table(name = "post")
@Entity
@Accessors(chain = true)
@Where(clause = "is_deleted = 0")
@SQLDelete(sql = "update post set is_deleted = 1 where id = ?")
@DynamicInsert
@DynamicUpdate
public class Post implements Serializable {

    @Id
    private Integer id;
    /**
     * 文章作者
     */
    private Integer userId;
    /**
     * 文章时间
     */
    private LocalDateTime postDate;
    /**
     * 文章标题
     */
    private String postTitle;
    /**
     * 文章内容
     */
    private String postContent;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     * 文章路径
     */
    private String postPathNumber;
    /**
     * 标签id
     */
    private Integer tagId;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}
