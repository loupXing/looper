package com.ymm.entity;

import java.io.Serializable;

public class CityDistrict implements Serializable
{

    private static final long serialVersionUID = -3879529080702096939L;
    
    private String city;
    
    private String city_n;
    
    private String district;
    
    private String district_n;

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity_n()
    {
        return city_n;
    }

    public void setCity_n(String city_n)
    {
        this.city_n = city_n;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getDistrict_n()
    {
        return district_n;
    }

    public void setDistrict_n(String district_n)
    {
        this.district_n = district_n;
    }
    
    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("CityDistrict [city=");
        sb.append(city+" ,city_n=");
        sb.append(city_n+" ,district=");
        sb.append(district+" ,district_n="); 
        sb.append(district_n+"]");
        return sb.toString();
    }
    
}
