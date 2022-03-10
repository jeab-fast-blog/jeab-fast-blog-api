package me.xueyao.controller;

import cn.hutool.core.lang.tree.Tree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.CategoryAddDto;
import me.xueyao.domain.dto.CategoryModifyDto;
import me.xueyao.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:27
 **/
@Api(tags = "分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @ApiOperation(value = "创建分类")
    @PostMapping("/add")
    public R add(@Validated @RequestBody CategoryAddDto categoryAddDto) {
        return categoryService.add(categoryAddDto);
    }


    @ApiOperation(value = "修改分类")
    @PostMapping("/modify")
    public R modify(@Validated @RequestBody CategoryModifyDto categoryModifyDto) {
        return categoryService.modify(categoryModifyDto);
    }

    @ApiOperation(value = "删除分类")
    @GetMapping("/delete")
    public R delete(@RequestParam("categoryId") Integer categoryId) {
        return categoryService.delete(categoryId);
    }

    @ApiOperation(value = "获得分类详情")
    @GetMapping("/getDetail")
    public R getDetail(@RequestParam("categoryId") Integer categoryId) {
        return categoryService.getDetail(categoryId);
    }

    @ApiOperation(value = "分类列表")
    @GetMapping("/list")
    public R list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return categoryService.list(pageNum, pageSize);
    }

    @ApiOperation(value = "获得分类的树型结构")
    @GetMapping("/getTree")
    public List<Tree<String>> getTree() {
        return categoryService.getTree();
    }
}
