package me.xueyao.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 分类
 * @author: Simon.Xue
 * @date: 2019-02-26 12:43
 **/
@Data
public class CategoryModifyDto implements Serializable {
    private Integer id;
    /**
     * 分类姓名
     */
    private String name;
    /**
     * 别名
     */
    private String alias;
    /**
     * 删除
     */
    private Integer isDeleted;

}
