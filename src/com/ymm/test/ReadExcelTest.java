package com.ymm.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

import com.ymm.util.ReadExcel;

public class ReadExcelTest
{
    @Test
    public void loadExcelTest()
    {
        String filePath = "D:\\下单模板 -5.31(1).xlsx";
        ReadExcel.loadExcel(filePath);
    }
    
    @Test
    public void getResourceXml()
    {
        try
        {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            System.out.println("reader:" + reader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
