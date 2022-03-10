package me.xueyao.domain.dto;

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
public class AttachmentModifyDto implements Serializable {

    private Integer id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
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
     * 文件大小
     */
    @ApiModelProperty(value = "文件大小")
    private Integer size;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String fileType;

}
