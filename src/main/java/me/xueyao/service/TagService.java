package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.TagAddDto;
import me.xueyao.domain.dto.TagModifyDto;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:40
 **/
public interface TagService {
    /**
     * 添加标签
     * @param tagAddDto
     * @return
     */
    R add(TagAddDto tagAddDto);

    /**
     * 修改标签
     * @param tagModifyDto
     * @return
     */
    R modify(TagModifyDto tagModifyDto);

    /**
     * 删除标签
     * @param tagId
     * @return
     */
    R delete(Integer tagId);

    /**
     * 查询标签详情
     * @param tagId
     * @return
     */
    R getDetail(Integer tagId);
    /**
     * 标签列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    R list(Integer pageNum, Integer pageSize);
}
