package me.xueyao.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: 评论
 * @author: Simon.Xue
 * @date 2022-03-07 16:55:49
 **/
@Data
@Where(clause = "use_deleted = 0")
@Accessors(chain = true)
public class CommentPageVo implements Serializable {

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
     * 内容ID
     */
    @ApiModelProperty(value = "内容ID")
    private Integer contentId;
    /**
     * 评论类型 1文章 2页面
     */
    @ApiModelProperty(value = "评论类型 1文章 2页面")
    private Integer type;

}
