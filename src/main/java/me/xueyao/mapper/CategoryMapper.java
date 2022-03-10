package me.xueyao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.xueyao.domain.entity.Category;
import me.xueyao.domain.vo.CategoryPageVo;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2022/3/10 12:09 PM
 **/
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 查询分类列表
     * @return
     */
    IPage<CategoryPageVo> findAll(Page page);
}
