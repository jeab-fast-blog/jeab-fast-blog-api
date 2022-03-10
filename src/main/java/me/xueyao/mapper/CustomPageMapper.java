package me.xueyao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.xueyao.domain.entity.CustomPage;
import me.xueyao.domain.vo.CustomPagePageVo;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:42 PM
 **/
@Repository
public interface CustomPageMapper extends BaseMapper<CustomPage> {
    /**
     * 查询页面列表
     * @param page
     * @return
     */
    IPage<CustomPagePageVo> findAll(Page<CustomPagePageVo> page);
}
