package com.lee.phoenix.controller.rest;


import com.lee.phoenix.common.consts.HttpHeaderKeys;
import com.lee.phoenix.common.generic.AjaxResponse;
import com.lee.phoenix.config.ExtraConfig;
import com.lee.phoenix.contract.auth.TLogin;
import com.lee.phoenix.entity.User;
import com.lee.phoenix.security.Account;
import com.lee.phoenix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json;charset=UTF-8")
public class AuthController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@Valid @RequestBody TLogin login)  {
        User user = userService.findByUsernameOrPhone(login.getUsername());
        if (user == null || user.getPassword() == null || !BCrypt.checkpw(login.getPassword(), user.getPassword())) {
            if (!ExtraConfig.isDev() || user == null) {
                return AjaxResponse.fail("账号不存在或者密码错误！");
            }
        }
        Map<String, Object> resp = new HashMap<>();
//        resp.put("user", Account.fromDomain(trainer));
//        resp.put(HttpHeaderKeys.AUTH_HEADER_NAME, tokenUtil.getToken(trainer));

        return AjaxResponse.success(resp);
    }

}


