package com.ymm.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil
{
    private static String resource = "mybatis-config.xml";

    public static SqlSession getSqlSession()
    {
        try
        {
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            SqlSession session = factory.openSession();
            return session;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void closeSession(SqlSession session)
    {
        session.close();
    }
}
