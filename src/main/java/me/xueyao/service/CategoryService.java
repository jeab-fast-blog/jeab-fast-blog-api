package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.entity.dto.CategoryAddDto;
import me.xueyao.entity.dto.CategoryModifyDto;
import org.springframework.data.domain.Pageable;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:37
 **/
public interface CategoryService {
    /**
     * 添加分类
     * @param categoryAddDto
     * @return
     */
    R add(CategoryAddDto categoryAddDto);

    /**
     * 修改分类
     * @param categoryModifyDto
     * @return
     */
    R modify(CategoryModifyDto categoryModifyDto);

    /**
     * 删除分类
     * @param categoryId
     * @return
     */
    R delete(Integer categoryId);

    /**
     * 查询分类信息
     * @param categoryId
     * @return
     */
    R getDetail(Integer categoryId);
    /**
     * 分类列表
     * @param pageable
     * @return
     */
    R list(Pageable pageable);
}
