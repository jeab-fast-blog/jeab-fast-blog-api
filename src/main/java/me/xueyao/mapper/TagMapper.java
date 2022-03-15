package me.xueyao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.xueyao.domain.entity.Tag;
import me.xueyao.domain.vo.TagPageVo;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2022/3/10 12:09 PM
 **/
@Repository
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 查询分类列表
     * @return
     */
    IPage<TagPageVo> findAll(Page page);
}
