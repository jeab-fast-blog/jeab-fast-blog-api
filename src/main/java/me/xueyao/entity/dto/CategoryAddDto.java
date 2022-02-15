package me.xueyao.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description: 分类
 * @author: Simon.Xue
 * @date: 2019-02-26 12:43
 **/
@Data
@Accessors(chain = true)
public class CategoryAddDto implements Serializable {

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
