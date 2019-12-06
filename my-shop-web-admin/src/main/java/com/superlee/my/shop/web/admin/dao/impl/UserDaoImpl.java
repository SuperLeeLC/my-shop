package com.superlee.my.shop.web.admin.dao.impl;

import com.superlee.my.shop.domain.User;
import com.superlee.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author : lichao892
 * @date : 2019/12/6 15:16
 * <p>
 * 描述 :    TODO
 */

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User getUser(String email, String password) {

        logger.debug("调用getUser()方法, email：{} password：{}", email, password);

        User user = null;

        if ("admin@lee.com".equals(email)) {
            if ("admin".equals(password)){
                user = new User();
                user.setEmail("admin@lee.com");
                user.setUsername("SuperLee");

                logger.info("成功获取 \"{}\" 的用户信息", user.getUsername());
            }
        } else {
            logger.warn("获取 \"{}\" 的用户信息失败", email);
        }

        return user;
    }
}
