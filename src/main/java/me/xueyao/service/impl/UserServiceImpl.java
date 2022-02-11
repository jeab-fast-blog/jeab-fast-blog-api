package me.xueyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import me.xueyao.base.R;
import me.xueyao.constant.Constant;
import me.xueyao.entity.User;
import me.xueyao.entity.dto.LoginDto;
import me.xueyao.entity.vo.UserVO;
import me.xueyao.repository.UserRepository;
import me.xueyao.service.UserService;
import me.xueyao.util.CurrentUserUtil;
import me.xueyao.util.RedisHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 1/28/21 2:50 PM
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private RedisHelper redisHelper;

    @Override
    public R login(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (null == user) {
            return R.ofParam("用户名不存在");
        }
        if (!user.getPassword().equals(loginDto.getPassword())) {
            return R.ofParam("用户名或密码不正确");
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

        return R.ofParam("查询当前用户信息失败");
    }

    @Override
    public R logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        redisHelper.delete(Constant.TOKEN_KEY+token);
        return R.ofSuccess("退出成功");
    }
}
