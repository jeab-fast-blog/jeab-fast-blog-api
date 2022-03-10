package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.OptionGeneralModifyDto;
import me.xueyao.service.OptionGeneralService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:33
 **/
@Api(tags = "常规选项")
@RestController
@RequestMapping("/optionGeneral")
public class OptionGeneralController {
    @Resource
    private OptionGeneralService optionGeneralService;


    @ApiOperation(value = "更新")
    @PostMapping("/modify")
    public R modify(@Validated @RequestBody OptionGeneralModifyDto optionGeneralModifyDto) {
        return optionGeneralService.modify(optionGeneralModifyDto);
    }


    @ApiOperation(value = "查询详情")
    @GetMapping("/getDetail")
    public R getDetail(@RequestParam("optionGeneralId") Integer optionGeneralId) {
        return optionGeneralService.getDetail(optionGeneralId);
    }
}
