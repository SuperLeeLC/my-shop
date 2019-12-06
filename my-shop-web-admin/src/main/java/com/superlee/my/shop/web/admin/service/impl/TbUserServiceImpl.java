package com.superlee.my.shop.web.admin.service.impl;

import com.superlee.my.shop.domain.TbUser;
import com.superlee.my.shop.web.admin.dao.TbUserDao;
import com.superlee.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : lichao892
 * @date : 2019/12/6 18:57
 * <p>
 * 描述 :    TODO
 */

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }
}
