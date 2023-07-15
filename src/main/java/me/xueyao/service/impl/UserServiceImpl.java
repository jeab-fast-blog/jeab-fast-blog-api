package me.xueyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.base.R;
import me.xueyao.constant.Constant;
import me.xueyao.domain.dto.*;
import me.xueyao.domain.entity.User;
import me.xueyao.domain.vo.UserVO;
import me.xueyao.repository.RoleRepository;
import me.xueyao.repository.UserRepository;
import me.xueyao.service.UserService;
import me.xueyao.util.BeanCompareUtils;
import me.xueyao.util.CurrentUserUtil;
import me.xueyao.util.RedisHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 1/28/21 2:50 PM
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private RedisHelper redisHelper;

    @Resource
    private RoleRepository roleRepository;

    @Override
    public R add(UserAddDto userAddDto) {
        Example<User> userExample = Example.of(new User().setUsername(userAddDto.getUsername()));
        Optional<User> userOptional = userRepository.findOne(userExample);
        if (userOptional.isPresent()) {
            return R.ofParamError("不可以添加相同名称的用户");
        }
        User user = new User();
        BeanUtils.copyProperties(userAddDto, user);
        String salt = DigestUtils.md5DigestAsHex(userAddDto.getUsername().getBytes());
        user.setSalt(salt);
        String password = (userAddDto.getPassword() + salt).trim();
        String encodePassword = DigestUtils.md5DigestAsHex(DigestUtils.md5Digest(password.getBytes()));
        user.setPassword(encodePassword);
        userRepository.save(user);
        return R.ofSuccess("添加用户成功");
    }

    @Override
    public R modify(UserModifyDto userModifyDto) {
        Optional<User> userOptional = userRepository.findById(userModifyDto.getId());
        if (!userOptional.isPresent()) {
            return R.ofParamError("该用户不存在");
        }
        User user = userOptional.get();
        BeanUtils.copyProperties(userModifyDto, user, BeanCompareUtils.getEmptyPropertyNames(userModifyDto));

        userRepository.save(user);

        return R.ofSuccess("更新用户成功");
    }

    @Override
    public R delete(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return R.ofParamError("该用户不存在");
        }
        userRepository.deleteById(userId);
        return R.ofSuccess("删除用户成功");
    }

    @Override
    public R getDetail(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return R.ofParamError("该用户不存在");
        }
        return R.ofSuccess("查询用户详情成功", userOptional.get());
    }

    @Override
    public R list(Pageable pageable) {
        Page<User> all = userRepository.findAll(pageable);
        return R.ofSuccess("查询成功", all);
    }

    @Override
    public R register(RegisterDto registerDto) {
        User user = new User();
        BeanUtil.copyProperties(registerDto, user);
        String username = registerDto.getUsername();
        String password = registerDto.getPassword();
        String rePassword = registerDto.getRePassword();
        Assert.isTrue(password.equals(rePassword), "两个密码必须相同");
        String salt = RandomUtil.randomString(8);
        user.setSalt(salt);
        user.setPassword(SecureUtil.sha1(username + password + salt));
        userRepository.save(user);
        return R.ofSuccess("注册成功");
    }

    @Override
    public R forgetPassword(ForgetPasswordDto forgetPasswordDto) {
        String email = forgetPasswordDto.getEmail();
        User user = userRepository.findByEmail(email);
        if (ObjectUtil.isEmpty(user)) {
            log.error("邮箱地址不存在，{}", email);
            return R.ofParamError("邮箱不存在!");
        }

        //发送忘记密码邮件操作

        log.info("发送邮件成功");
        return R.ofSuccess("发送邮件成功");
    }

    @Override
    public R login(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (null == user) {
            return R.ofParamError("用户名不存在");
        }
        String password = SecureUtil.sha1(loginDto.getUsername() + loginDto.getPassword() + user.getSalt());
        if (!user.getPassword().equals(password)) {
            return R.ofParamError("用户名或密码不正确");
        }
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        String token = IdUtil.fastSimpleUUID();
        redisHelper.set(Constant.TOKEN_KEY + token, userVO, 3600);
        Map<String, Object> map = BeanUtil.beanToMap(userVO);
        map.put("token", token);
        return R.ofSuccess("登录成功", map);

    }

    @Override
    public R currentUser() {
        Optional<User> userOptional = userRepository.findById(CurrentUserUtil.getCurrentUserId());
        if (userOptional.isPresent()) {
            UserVO userVO = BeanUtil.copyProperties(userOptional.get(), UserVO.class);
            return R.ofSuccess("查询当前用户信息成功", userVO);
        }

        return R.ofParamError("查询当前用户信息失败");
    }

    @Override
    public R logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        redisHelper.delete(Constant.TOKEN_KEY+token);
        return R.ofSuccess("退出成功");
    }
}
