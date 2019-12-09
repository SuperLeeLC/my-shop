package com.superlee.my.shop.web.admin.service;

import com.superlee.my.shop.domain.TbUser;
import org.springframework.util.FastByteArrayOutputStream;

import java.util.List;

/**
 * @author : lichao892
 * @date : 2019/12/6 18:55
 * <p>
 * 描述 :    TODO
 */

public interface TbUserService {

    List<TbUser> selectAll();

    void insert(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
