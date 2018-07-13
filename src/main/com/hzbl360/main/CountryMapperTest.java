package com.hzbl360.main;

import com.hzbl360.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest {

//    private static SqlSessionFactory sqlSessionFactory;
//
//    @BeforeClass
//    public static void init(){
//
//        try {
//            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
//
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
//
//            resourceAsReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public SqlSession getSqlSession(){
//
//        return sqlSessionFactory.openSession();
//    }
//
//    @Test
//    public void testSelectAll(){
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        try {
//            List<Object> countryList = sqlSession.selectList("selectAll");
//            for (Object country : countryList){
//                System.out.println(country);
//            }
//        } finally {
//            sqlSession.close();
//        }
//    }
}
