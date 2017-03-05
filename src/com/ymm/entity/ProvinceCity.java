package com.ymm.entity;

import java.io.Serializable;

public class ProvinceCity implements Serializable
{

    private static final long serialVersionUID = -4468515806841956368L;
    
    private String province;
    
    private String province_n;
    
    private String city;
    
    private String city_n;

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince_n()
    {
        return province_n;
    }

    public void setProvince_n(String province_n)
    {
        this.province_n = province_n;
    }

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
    
    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("ProvinceCity [province=");
        sb.append(province+" ,province_n=");
        sb.append(province_n+" ,city=");
        sb.append(city+" ,city_n="); 
        sb.append(city_n+"]");
        return sb.toString();
    }

}
