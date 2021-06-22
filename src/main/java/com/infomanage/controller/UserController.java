package com.infomanage.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.infomanage.commom.dto.LoginDto;
import com.infomanage.commom.lang.Result;
import com.infomanage.entity.User;
import com.infomanage.service.UserService;
import com.infomanage.util.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author seakr
 * @since 2021-06-22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("/setuser")
    @ApiOperation(value = "更改用户信息")
    public Result setuser(@RequestBody User user) {
        if(user.getPassword()!=null)
            user.setPassword(SecureUtil.md5(user.getPassword()));
        userService.saveOrUpdate(user);
        return Result.succ(user);
    }
    //@RequiresAuthentication //使用此注解后接口访问需要提供token
    @GetMapping("/getall")
    @ApiOperation(value = "获取所有用户信息")
    public Result getusers(){
        return Result.succ(userService.list());
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Result login(@Validated @RequestBody LoginDto loginDto,
                        HttpServletResponse response) {
        User user = userIsNull(loginDto.getAccount());
        Assert.notNull(user, "用户不存在");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("token", jwt);
        response.setHeader("Access-control-Expose-Headers", "token");
        return Result.succ(MapUtil.builder().put("token",jwt).map());
    }
    public User userIsNull(String account){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account",account);
        return userService.getOne(wrapper);
    }

}
