package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.CustomPageAddDto;
import me.xueyao.domain.dto.CustomPageModifyDto;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:29 PM
 **/
public interface PageService {

    /**
     * 添加页面
     * @param customPageAddDto
     * @return
     */
    R add(CustomPageAddDto customPageAddDto);

    /**
     * 修改页面
     * @param customPageModifyDto
     * @return
     */
    R modify(CustomPageModifyDto customPageModifyDto);

    /**
     * 删除页面
     * @param pageId
     * @return
     */
    R delete(Integer pageId);

    /**
     * 查询页面信息
     * @param pageId
     * @return
     */
    R getDetail(Integer pageId);
    /**
     * 页面列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    R list(Integer pageNum, Integer pageSize);
}
