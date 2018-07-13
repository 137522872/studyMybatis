package com.hzbl360.main;


import com.hzbl360.mapper.UserMapper;
import com.hzbl360.model.SysRole;
import com.hzbl360.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Date;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

public class DemoTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){

        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);

            resourceAsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<SysUser> sysUsers = mapper.selectAll();
            for( SysUser sysUser:sysUsers){
                System.out.println(sysUser);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectById(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            SysUser sysUser = mapper.selectById(16L);
            System.out.println(sysUser);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public  void testselectRoleByUserId(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<SysRole> sysRoles = mapper.selectRoleByUserId(1L);

            for (SysRole sysRole: sysRoles){
                System.out.println(sysRole);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        SysUser sysUser = new SysUser();
        sysUser.setUserName("test_hzxs12");
        sysUser.setUserPassword("123456");
        sysUser.setHeadImg(new byte[]{1,2,3});
        sysUser.setUserInfo("这是一个Mybatis测试用户");
        sysUser.setCreateTime(new Date());
        sysUser.setUserEmail("mybatis@hzbl360.com");


        int insert = mapper.insert(sysUser);
        System.out.println(insert);
    }

    @Test
    public void testUpdateById(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        SysUser sysUser = mapper.selectById(16L);

        sysUser.setUserName("admin_test");
        sysUser.setUserEmail("admin@hzbl360.com");

        int i = mapper.updateById(sysUser);
        System.out.println(i);

    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<SysRole> sysRoles = mapper.selectRolesByUserIdAndRoleEnabled(1l, 1l);

        for(SysRole sysRole :sysRoles){
            System.out.println(sysRole);
        }
    }

    @Test
    public void testSelectRolesByUserAndRole(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        SysUser sysUser = new SysUser();
        SysRole sysRole = new SysRole();

        sysUser.setId(1L);
        sysRole.setEnabled(1L);

        List<SysRole> sysRoles = mapper.selectRolesByUserAndRole(sysUser,sysRole);

        for(SysRole sysRole1:sysRoles){
            System.out.println(sysRole1);
        }

    }

    @Test
    public void testSelectByIdOrUserName(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        SysUser sysUser = new SysUser();
//        sysUser.setId(1l);

        sysUser.setUserName("admin1");

        SysUser sysUser1 = mapper.selectByIdOrUserName(sysUser);

        System.out.println(sysUser1);

    }

    @Test
    public void testselectByUser() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        SysUser sysUser = mapper.selectByUser("admin","user@map.com");
        sleep(5000);
        System.out.println(sysUser);

    }

    @Test
    public void testUpdateByMap(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("user_name","test@navicate.com");
        map.put("id",1L);
        map.put("user_password","1234545");


        mapper.updateByMap(map);
    }

    @Test
    public void testSelectUserAndRoleById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        List<SysUser> sysUsers = mapper.selectUserAndRoleById(1L);
        for(SysUser sysUser:sysUsers){
            System.out.println(sysUser);
        }
    }


    @Test
    public void selectUserAndRoleByIdSelect(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        List<SysUser> sysUsers = mapper.selectUserAndRoleByIdSelect(1L);

        for(SysUser sysUser:sysUsers){
            System.out.println(sysUser);
        }
    }
}
