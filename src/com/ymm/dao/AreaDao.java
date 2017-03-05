package com.ymm.dao;

import java.util.List;

import com.ymm.entity.CityDistrict;
import com.ymm.entity.DistrictStreet;
import com.ymm.entity.ProvinceCity;

public interface AreaDao
{
    /**
     * 插入省市
     *
     * @param provinceCity
     * @return
     */
    public int insertProvinceCity(List<ProvinceCity> provinceCities);
    
    /**
     * 插入市区
     *
     * @param cityDistrict
     * @return
     */
    public int insertCityDistrict(List<CityDistrict> cityDistricts);
    
    /**
     * 插入县镇
     *
     * @param districtStreet
     * @return
     */
    public int insertDistrictStreet(List<DistrictStreet> districtStreets);
}
