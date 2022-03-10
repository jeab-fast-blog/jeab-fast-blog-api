package me.xueyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.base.R;
import me.xueyao.domain.entity.Category;
import me.xueyao.domain.dto.CategoryAddDto;
import me.xueyao.domain.dto.CategoryModifyDto;
import me.xueyao.domain.vo.CategoryPageVo;
import me.xueyao.mapper.CategoryMapper;
import me.xueyao.repository.CategoryRepository;
import me.xueyao.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:43
 **/
@Slf4j
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public R add(CategoryAddDto categoryAddDto) {
        Example<Category> categoryExample = Example.of(new Category().setName(categoryAddDto.getName()));
        Optional<Category> categoryOptional = categoryRepository.findOne(categoryExample);
        if (categoryOptional.isPresent()) {
            log.warn("{},该分类已存在", categoryAddDto.getName());
            return R.ofParamError("该分类已存在");
        }
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddDto, category);
        categoryRepository.save(category);
        log.info("添加成功");
        return R.ofSuccess("添加成功");
    }

    @Override
    public R modify(CategoryModifyDto categoryModifyDto) {
        Integer categoryId = categoryModifyDto.getId();
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (!categoryOptional.isPresent()) {
            log.warn("{},该分类已存在", categoryModifyDto.getName());
            return R.ofParamError("分类不存在");
        }

        Category category = categoryOptional.get();
        BeanUtil.copyProperties(categoryModifyDto, category);
        categoryRepository.save(category);
        log.info("更新分类成功");
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
            log.warn("id = {},该分类不存在", categoryId);
            return R.ofParamError("该分类不存在");
        }
        return R.ofSuccess("查询分类成功", categoryOptional.get());
    }

    @Override
    public R list(Integer pageNum, Integer pageSize) {
        Page<CategoryPageVo> page = new Page<>(pageNum, pageSize);
        IPage<CategoryPageVo> iPage = categoryMapper.findAll(page);
        return R.ofSuccess("查询成功", iPage);
    }

    @Override
    public List<Tree<String>> getTree() {
        List<Category> categoryList = categoryRepository.findAll();
        List<TreeNode<String>> nodeList = categoryList.stream().map(category -> {
            TreeNode<String> node = new TreeNode<>();
            node.setId(category.getId()+"");
            node.setName(category.getName());
            node.setParentId(category.getParentId()+"");
            // Bean转Map
            Map<String, Object> map = BeanUtil.beanToMap(category);
            node.setExtra(map);
            return node;
        }).collect(Collectors.toList());
        TreeNodeConfig config = new TreeNodeConfig();
        config.setIdKey("id");
        config.setNameKey("name");
        config.setWeightKey("sort");

        //转换器
        List<Tree<String>> treeNodes = TreeUtil.build(nodeList, "0", config,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setName(treeNode.getName());
                    tree.putExtra("alias", treeNode.getExtra().get("alias"));
                    tree.putExtra("description", treeNode.getExtra().get("description"));
                });
        return treeNodes;
    }
}
