package me.xueyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.base.R;
import me.xueyao.domain.dto.CustomPageAddDto;
import me.xueyao.domain.dto.CustomPageModifyDto;
import me.xueyao.domain.entity.CustomPage;
import me.xueyao.domain.vo.CustomPagePageVo;
import me.xueyao.mapper.CustomPageMapper;
import me.xueyao.repository.CustomPageRepository;
import me.xueyao.service.PageService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:30 PM
 **/
@Slf4j
@Service
public class PageServiceImpl implements PageService {
    @Resource
    private CustomPageRepository customPageRepository;
    @Resource
    private CustomPageMapper customPageMapper;

    @Override
    public R add(CustomPageAddDto customPageAddDto) {
        CustomPage page = new CustomPage();
        BeanUtils.copyProperties(customPageAddDto, page);
        customPageRepository.save(page);
        log.info("添加成功");
        return R.ofSuccess("添加成功");
    }

    @Override
    public R modify(CustomPageModifyDto customPageModifyDto) {
        Integer pageId = customPageModifyDto.getId();
        Optional<CustomPage> pageOptional = customPageRepository.findById(pageId);
        CustomPage page = pageOptional.get();
        BeanUtil.copyProperties(customPageModifyDto, page);
        customPageRepository.save(page);
        log.info("更新分类成功");
        return R.ofSuccess("更新分类成功");
    }

    @Override
    public R delete(Integer pageId) {
        Optional<CustomPage> pageOptional = customPageRepository.findById(pageId);
        if (pageOptional.isPresent()) {
            return R.ofParamError("分类不存在");
        }
        customPageRepository.deleteById(pageId);
        return R.ofSuccess("分类删除成功");
    }

    @Override
    public R getDetail(Integer pageId) {
        Optional<CustomPage> pageOptional = customPageRepository.findById(pageId);
        if (!pageOptional.isPresent()) {
            log.warn("id = {},该分类不存在", pageId);
            return R.ofParamError("该分类不存在");
        }
        return R.ofSuccess("查询分类成功", pageOptional.get());
    }

    @Override
    public R list(Integer pageNum, Integer pageSize) {
        Page<CustomPagePageVo> page = new Page<>(pageNum, pageSize);
        IPage<CustomPagePageVo> iPage = customPageMapper.findAll(page);
        return R.ofSuccess("查询成功", iPage);
    }
}
