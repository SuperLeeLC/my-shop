package com.superlee.my.shop.web.admin.web.controller;

import com.superlee.my.shop.domain.TbUser;
import com.superlee.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author : lichao892
 * @date : 2019/12/6 19:43
 * <p>
 * 描述 :    TODO
 */

@Controller
public class Test {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
}
