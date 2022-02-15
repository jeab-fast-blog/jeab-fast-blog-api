package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.entity.Tag;
import me.xueyao.entity.dto.TagAddDto;
import me.xueyao.entity.dto.TagModifyDto;
import me.xueyao.repository.TagRepository;
import me.xueyao.service.TagService;
import me.xueyao.util.BeanCompareUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:46
 **/
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Resource
    private TagRepository tagRepository;
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
    public R list(Pageable pageable) {
        List<Tag> tagList = tagRepository.findAll();
        return R.ofSuccess("查询成功", tagList);
    }
}
