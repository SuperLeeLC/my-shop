package com.superlee.my.shop.web.admin.service.impl;

import com.superlee.my.shop.commons.dto.BaseResult;
import com.superlee.my.shop.commons.utils.RegexpUtils;
import com.superlee.my.shop.domain.TbUser;
import com.superlee.my.shop.web.admin.dao.TbUserDao;
import com.superlee.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);

        // 通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdate(new Date());

            // 新增用户
            if (tbUser.getId() == null) {
                //密码加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }

            // 编辑用户
            else {
                tbUserDao.update(tbUser);
            }

            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByUsername(String username) {
        return tbUserDao.selectByUsername(username);
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null) {
            // 明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            // 判断加密后的密码和数据库中存放的密码是否匹配，匹配则表示允许登录
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }

        return null;
    }

    @Override
    public List<TbUser> search(TbUser tbUser) {
        return tbUserDao.search(tbUser);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public List<TbUser> page(int start, int length) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        return tbUserDao.page(params);
    }

    @Override
    public int count() {
        return tbUserDao.count();
    }

    /**
     * 用户信息的有效性验证
     * @param tbUser
     */
    private BaseResult checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();

        // 非空判断
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        }

        else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult.setMessage("邮箱格式不正确，请重新输入");
        }

        else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        }

        else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空，请重新输入");
        }

        else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult.setMessage("手机格式不正确，请重新输入");
        }

        return baseResult;
    }

}
