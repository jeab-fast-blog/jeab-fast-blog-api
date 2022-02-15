package me.xueyao.controller;

import me.xueyao.base.R;
import me.xueyao.entity.dto.OptionGeneralAddDto;
import me.xueyao.entity.dto.OptionGeneralModifyDto;
import me.xueyao.service.OptionGeneralService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:33
 **/
@RestController
@RequestMapping("/optionGeneral")
public class OptionGeneralController {
    @Resource
    private OptionGeneralService optionGeneralService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody OptionGeneralAddDto optionGeneralAddDto) {
        return optionGeneralService.add(optionGeneralAddDto);
    }

    @PutMapping("/modify")
    public R modify(@Validated @RequestBody OptionGeneralModifyDto optionGeneralModifyDto) {
        return optionGeneralService.modify(optionGeneralModifyDto);
    }

    @DeleteMapping("/delete/{optionGeneralId}")
    public R delete(@PathVariable("optionGeneralId") Integer optionGeneralId) {
        return optionGeneralService.delete(optionGeneralId);
    }

    @GetMapping("/getDetail/{optionGeneralId}")
    public R getDetail(@PathVariable("optionGeneralId") Integer optionGeneralId) {
        return optionGeneralService.getDetail(optionGeneralId);
    }
}
