package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.entity.Category;
import me.xueyao.entity.dto.CategoryAddDto;
import me.xueyao.entity.dto.CategoryModifyDto;
import me.xueyao.repository.CategoryRepository;
import me.xueyao.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:43
 **/
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public R add(CategoryAddDto categoryAddDto) {
        Example<Category> categoryExample = Example.of(new Category().setName(categoryAddDto.getName()));
        Optional<Category> categoryOptional = categoryRepository.findOne(categoryExample);
        if (categoryOptional.isPresent()) {
            return R.ofParamError("该分类已存在");
        }
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddDto, category);
        categoryRepository.save(category);
        return R.ofSuccess("添加成功");
    }

    @Override
    public R modify(CategoryModifyDto categoryModifyDto) {
        Integer categoryId = categoryModifyDto.getId();
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (!categoryOptional.isPresent()) {
            return R.ofParamError("分类不存在");
        }

        Category category = categoryOptional.get();
        category.setUpdateTime(new Date());
        category.setName(categoryModifyDto.getName());
        category.setAlias(categoryModifyDto.getAlias());
        categoryRepository.save(category);
        return R.ofSuccess("更新分类成功");
    }

    @Override
    public R delete(Integer categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            return R.ofParamError("分类不存在");
        }
        categoryRepository.deleteById(categoryId);
        return R.ofSuccess("分类删除成功");
    }

    @Override
    public R getDetail(Integer categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (!categoryOptional.isPresent()) {
            return R.ofParamError("该分类不存在");
        }
        return R.ofSuccess("查询分类成功", categoryOptional.get());
    }

    @Override
    public R list(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        return R.ofSuccess("查询成功", categoryPage);
    }
}
