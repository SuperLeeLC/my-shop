package com.superlee.my.shop.web.admin.service;

import com.superlee.my.shop.commons.dto.BaseResult;
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

    BaseResult save(TbUser tbUser);

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

    /**
     * 搜索功能
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    List<TbUser> page(int start, int length);

    /**
     * 查询总笔数
     * @return
     */
    int count();
}
