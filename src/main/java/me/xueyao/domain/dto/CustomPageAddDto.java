package me.xueyao.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: 页面
 * @author: Simon.Xue
 * @date 2022-03-07 17:24:08
 **/
@Data
@Accessors(chain = true)
@Where(clause = "use_deleted = 0")
public class CustomPageAddDto implements Serializable {

    private Integer id;
    /**
     * 页面作者
     */
    @ApiModelProperty(value = "页面作者")
    private Integer userId;
    /**
     * 页面时间
     */
    @ApiModelProperty(value = "页面时间")
    private LocalDateTime pageDate;
    /**
     * 页面标题
     */
    @ApiModelProperty(value = "页面标题")
    private String pageTitle;
    /**
     * 页面内容
     */
    @ApiModelProperty(value = "页面内容")
    private String pageContent;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "")
    private LocalDateTime createTime;
    /**
     * 使用删除
     */
    @ApiModelProperty(value = "使用删除")
    private Integer useDeleted;



    /**
     * 使用禁止评论
     */
    private Integer useComment;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 别名
     */
    private String alias;


}
