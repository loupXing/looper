package com.ymm.entity;

import java.io.Serializable;

public class DistrictStreet implements Serializable
{

    private static final long serialVersionUID = -1219928039638986885L;

    private String district;
    
    private String district_n;
    
    private String street;
    
    private String street_n;

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

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getStreet_n()
    {
        return street_n;
    }

    public void setStreet_n(String street_n)
    {
        this.street_n = street_n;
    }
    
    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("DistrictStreet [district=");
        sb.append(district+" ,district_n=");
        sb.append(district_n+" ,street=");
        sb.append(street+" ,street_n="); 
        sb.append(street_n+"]");
        return sb.toString();
    }
}
