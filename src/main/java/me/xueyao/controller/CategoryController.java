package me.xueyao.controller;

import me.xueyao.base.R;
import me.xueyao.entity.dto.CategoryAddDto;
import me.xueyao.entity.dto.CategoryModifyDto;
import me.xueyao.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:27
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody CategoryAddDto categoryAddDto) {
        return categoryService.add(categoryAddDto);
    }


    @PutMapping("/modify")
    public R modify(@Validated @RequestBody CategoryModifyDto categoryModifyDto) {
        return categoryService.modify(categoryModifyDto);
    }

    @DeleteMapping("/delete/{categoryId}")
    public R delete(@PathVariable("categoryId") Integer categoryId) {
        return categoryService.delete(categoryId);
    }

    @GetMapping("/getDetail/{categoryId}")
    public R getDetail(@PathVariable("categoryId") Integer categoryId) {
        return categoryService.getDetail(categoryId);
    }

    @GetMapping("/list")
    public R list(Pageable pageable) {
        return categoryService.list(pageable);
    }
}
