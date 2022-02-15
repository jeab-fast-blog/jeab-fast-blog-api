package me.xueyao.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 文章
 * @author: Simon.Xue
 * @date: 2019-02-26 12:31
 **/
@Data
@Accessors(chain = true)
public class PostModifyDto implements Serializable {

    private Integer id;
    /**
     * 文章作者
     */
    private Integer userId;
    /**
     * 文章时间
     */
    private Date postDate;
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
    private Integer tagsId;

    /**
     * 是否删除
     */
    private Integer isDeleted;

}
