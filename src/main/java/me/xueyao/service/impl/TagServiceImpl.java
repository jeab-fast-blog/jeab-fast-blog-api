package me.xueyao.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.xueyao.base.R;
import me.xueyao.domain.dto.TagAddDto;
import me.xueyao.domain.dto.TagModifyDto;
import me.xueyao.domain.entity.Tag;
import me.xueyao.domain.vo.TagPageVo;
import me.xueyao.mapper.TagMapper;
import me.xueyao.repository.TagRepository;
import me.xueyao.service.TagService;
import me.xueyao.util.BeanCompareUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:46
 **/
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Resource
    private TagRepository tagRepository;
    @Resource
    private TagMapper tagMapper;
    @Override
    public R add(TagAddDto tagAddDto) {
        Example<Tag> tagExample = Example.of(new Tag().setName(tagAddDto.getName()));
        Optional<Tag> tagOptional = tagRepository.findOne(tagExample);
        if (tagOptional.isPresent()) {
            return R.ofParamError("该标签已存在");
        }

        Tag tag = new Tag();
        BeanUtils.copyProperties(tagAddDto, tag);
        tagRepository.save(tag);
        return R.ofSuccess("添加标签成功");
    }

    @Override
    public R modify(TagModifyDto tagModifyDto) {
        Optional<Tag> tagOptional = tagRepository.findById(tagModifyDto.getId());
        if (!tagOptional.isPresent()) {
            return R.ofParamError("该标签不存在");
        }

        Tag tag = tagOptional.get();
        BeanUtils.copyProperties(tagModifyDto, tag, BeanCompareUtils.getEmptyPropertyNames(tagModifyDto));
        tagRepository.save(tag);
        return R.ofSuccess("更新标签成功");
    }

    @Override
    public R delete(Integer tagId) {
        Optional<Tag> tagOptional = tagRepository.findById(tagId);
        if (!tagOptional.isPresent()) {
            return R.ofParamError("该标签不存在");
        }

        tagRepository.deleteById(tagId);
        return R.ofSuccess("删除标签成功");
    }

    @Override
    public R getDetail(Integer tagId) {
        Optional<Tag> tagOptional = tagRepository.findById(tagId);
        if (!tagOptional.isPresent()) {
            return R.ofParamError("该标签不存在");
        }
        return R.ofSuccess("查询标签详情成功", tagOptional.get());
    }

    @Override
    public R list(Integer pageNum, Integer pageSize) {
        Page<TagPageVo> page = new Page<>(pageNum, pageSize);
        IPage<TagPageVo> iPage = tagMapper.findAll(page);
        return R.ofSuccess("查询成功", iPage);
    }
}
