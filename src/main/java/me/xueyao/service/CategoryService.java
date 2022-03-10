package me.xueyao.service;

import cn.hutool.core.lang.tree.Tree;
import me.xueyao.base.R;
import me.xueyao.domain.dto.CategoryAddDto;
import me.xueyao.domain.dto.CategoryModifyDto;

import java.util.List;

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
     * @param pageNum
     * @param pageSize
     * @return
     */
    R list(Integer pageNum, Integer pageSize);

    /**
     * 获得树型结构数据
     * @return
     */
    List<Tree<String>> getTree();
}
