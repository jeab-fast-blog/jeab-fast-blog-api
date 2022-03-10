package me.xueyao.domain.dto;

import io.swagger.annotations.ApiModelProperty;
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
public class TagAddDto implements Serializable {
    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名")
    private String name;
    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    private String alias;


}
