package com.superlee.my.shop.web.admin.service.test;

import com.sun.javaws.IconUtil;
import com.superlee.my.shop.domain.TbUser;
import com.superlee.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author : lichao892
 * @date : 2019/12/6 19:09
 * <p>
 * 描述 :    TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("SuperLee");
        tbUser.setPhone("15888888888");
        tbUser.setEmail("test@superlee.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setCreated(new Date());
        tbUser.setUpdate(new Date());

        tbUserService.save(tbUser);
    }

    @Test
    public void testDelete() {
        tbUserService.delete(38L);
    }

    @Test
    public void testGetById() {
        TbUser tbUser = tbUserService.getById(36L);
        System.out.println(tbUser.getUsername());
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("SuperLee");
        tbUserService.update(tbUser);
    }

    @Test
    public void testSelectByUsername() {
        List<TbUser> tbUsers = tbUserService.selectByUsername("uni");
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testMd5(){
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
    }
}
