package com.superlee.my.shop.web.admin.dao;

import com.superlee.my.shop.domain.User;

/**
 * @author : lichao892
 * @date : 2019/12/6 15:15
 * <p>
 * 描述 :    TODO
 */

public interface UserDao {

    /**
     * 根据邮箱和密码获取用户信息
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User getUser(String email, String password);
}
