package com.superlee.my.shop.web.admin.service;

import com.superlee.my.shop.domain.User;

/**
 * @author : lichao892
 * @date : 2019/12/6 15:20
 * <p>
 * 描述 :    TODO
 */

public interface UserService {

    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User login(String email, String password);
}
