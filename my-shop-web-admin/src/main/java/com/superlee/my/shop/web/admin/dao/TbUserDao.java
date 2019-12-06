package com.superlee.my.shop.web.admin.dao;

import com.superlee.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : lichao892
 * @date : 2019/12/6 18:53
 * <p>
 * 描述 :    TODO
 */

@Repository
public interface TbUserDao {

    /**
     *  查询用户表全部信息
     * @return
     */
    public List<TbUser> selectAll();
}
