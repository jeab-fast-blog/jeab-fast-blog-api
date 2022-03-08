package me.xueyao.entity;

import io.swagger.annotations.ApiModelProperty;
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
@DynamicInsert
@DynamicUpdate
public class Comment implements Serializable {
    @Id
    private Integer id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 正文
     */
    @ApiModelProperty(value = "正文")
    private String content;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer useDeleted;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 上层ID
     */
    @ApiModelProperty(value = "上层ID")
    private Integer parentId;
    /**
     * 文章ID
     */
    @ApiModelProperty(value = "文章ID")
    private Integer postId;

}
