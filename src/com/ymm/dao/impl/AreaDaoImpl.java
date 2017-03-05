package com.ymm.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ymm.dao.AreaDao;
import com.ymm.entity.CityDistrict;
import com.ymm.entity.DistrictStreet;
import com.ymm.entity.ProvinceCity;
import com.ymm.util.MyBatisUtil;

public class AreaDaoImpl implements AreaDao
{

    @Override
    public int insertProvinceCity(List<ProvinceCity> provinceCities)
    {
        SqlSession session = MyBatisUtil.getSqlSession();
        int insert = session.insert("com.ymm.dao.AreaDao.insertProvinceCity", provinceCities);
        session.commit();
        MyBatisUtil.closeSession(session);
        return insert;
    }

    @Override
    public int insertCityDistrict(List<CityDistrict> cityDistricts)
    {
        SqlSession session = MyBatisUtil.getSqlSession();
        int insert = session.insert("com.ymm.dao.AreaDao.insertCityDistrict", cityDistricts);
        session.commit();
        MyBatisUtil.closeSession(session);
        return insert;
    }

    @Override
    public int insertDistrictStreet(List<DistrictStreet> districtStreets)
    {
        SqlSession session = MyBatisUtil.getSqlSession();
        int insert = session.insert("com.ymm.dao.AreaDao.insertDistrictStreet", districtStreets);
        session.commit();
        MyBatisUtil.closeSession(session);
        return insert;
    }

}
