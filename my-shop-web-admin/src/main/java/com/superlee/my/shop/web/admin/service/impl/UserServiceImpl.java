package com.superlee.my.shop.web.admin.service.impl;

import com.superlee.my.shop.domain.User;
import com.superlee.my.shop.web.admin.dao.UserDao;
import com.superlee.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : lichao892
 * @date : 2019/12/6 15:21
 * <p>
 * 描述 :    TODO
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
