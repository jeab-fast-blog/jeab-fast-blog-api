package me.xueyao.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description: 标签
 * @author: Simon.Xue
 * @date: 2019-02-26 12:41
 **/
@Data
@Accessors(chain = true)
public class TagModifyDto implements Serializable {
    private Integer id;
    /**
     * 标签名
     */
    private String name;
    /**
     * 别名
     */
    private String alias;


}