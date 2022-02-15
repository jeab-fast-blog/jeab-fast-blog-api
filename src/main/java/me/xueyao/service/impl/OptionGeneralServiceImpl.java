package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.entity.OptionGeneral;
import me.xueyao.entity.dto.OptionGeneralAddDto;
import me.xueyao.entity.dto.OptionGeneralModifyDto;
import me.xueyao.repository.OptionGeneralRepository;
import me.xueyao.service.OptionGeneralService;
import me.xueyao.util.BeanCompareUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:43
 **/
@Service("optionsGeneralService")
public class OptionGeneralServiceImpl implements OptionGeneralService {
    @Resource
    private OptionGeneralRepository optionGeneralRepository;

    @Override
    public R add(OptionGeneralAddDto optionGeneralAddDto) {
        List<OptionGeneral> optionGeneralList = optionGeneralRepository.findAll();
        long count = optionGeneralList.stream().count();
        if (0 < count) {
            return R.ofParamError("不可以重复添加常规选项");
        }

        OptionGeneral optionGeneral = new OptionGeneral();
        BeanUtils.copyProperties(optionGeneralAddDto, optionGeneral);
        optionGeneralRepository.save(optionGeneral);
        return R.ofSuccess("添加常规选项成功");
    }

    @Override
    public R modify(OptionGeneralModifyDto optionGeneralModifyDto) {
        Optional<OptionGeneral> optionGeneralOptional = optionGeneralRepository.findById(optionGeneralModifyDto.getId());
        if (!optionGeneralOptional.isPresent()) {
            return R.ofParamError("该常规选项不存在");
        }

        OptionGeneral optionGeneral = new OptionGeneral();
        BeanUtils.copyProperties(optionGeneralModifyDto, optionGeneral, BeanCompareUtils.getEmptyPropertyNames(optionGeneralModifyDto));
        optionGeneralRepository.save(optionGeneral);
        return R.ofSuccess("更新常规选项成功");
    }

    @Override
    public R delete(Integer optionsGeneralId) {
        Optional<OptionGeneral> optionGeneralOptional = optionGeneralRepository.findById(optionsGeneralId);
        if (!optionGeneralOptional.isPresent()) {
            return R.ofParamError("该常规选项不存在");
        }
        optionGeneralRepository.deleteById(optionsGeneralId);
        return R.ofSuccess("删除常规选项成功");
    }

    @Override
    public R getDetail(Integer optionGeneralId) {
        Optional<OptionGeneral> optionGeneralOptional = optionGeneralRepository.findById(optionGeneralId);
        if (!optionGeneralOptional.isPresent()) {
            return R.ofParamError("该常规选项不存在");
        }
        return R.ofSuccess("查询常规选项成功", optionGeneralOptional.get());
    }


}
