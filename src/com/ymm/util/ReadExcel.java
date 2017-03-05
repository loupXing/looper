package com.ymm.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ymm.dao.AreaDao;
import com.ymm.dao.impl.AreaDaoImpl;
import com.ymm.entity.CityDistrict;
import com.ymm.entity.DistrictStreet;
import com.ymm.entity.ProvinceCity;

public class ReadExcel
{
    private static final Logger LOGGER = Logger.getLogger(ReadExcel.class);

    private static List<ProvinceCity> provinceCities = new ArrayList<ProvinceCity>();

    private static List<CityDistrict> cityDistricts = new ArrayList<CityDistrict>();

    private static List<DistrictStreet> districtStreets = new ArrayList<DistrictStreet>();

    /**
     * 读取Excel
     *
     * @param filePath
     * @param sheetInex
     */
    public static void loadExcel(String filePath)
    {
        LOGGER.debug("enter loadExcel,filePath:" + filePath);
        InputStream in = null;
        Workbook workbook = null;
        Sheet sheet = null;
        try
        {
            in = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(in);
            for (int i = 1; i < 4; i++)
            {
                sheet = workbook.getSheetAt(i);
                getSheetData(sheet, i);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            LOGGER.error("load excel failed,desc:::" + e, e);
        }
    }

    private static void getSheetData(Sheet sheet, int sheetInex)
    {
        AreaDao areaDao = new AreaDaoImpl();
        int rowNum = sheet.getLastRowNum();
        // 获取第一行
        Row rowFirst = sheet.getRow(0);
        Row row = null;
        Cell cell = null;
        String cellValue = null;
        int firstCellNum = rowFirst.getLastCellNum();
        String firstValue = null;
        String lastValue = null;
        
        for (int i = sheetInex == 1 ? 2 : 0; i <= firstCellNum; i++)
        {
            for (int j = 0; j <= rowNum; j++)
            {
                row = sheet.getRow(j);
                if (null != row)
                {
                    cell = row.getCell(i);
                    if (null != cell)
                    {
                        cellValue = cell.getStringCellValue();
                        if ((null != cellValue) && !"".equals(cellValue))
                        {
                            int indexN = cellValue.indexOf("N");
                            String subValue = cellValue.substring(0, indexN);
                            if (j == 0)
                            {
                                firstValue = subValue;
                                lastValue = cellValue;
                                continue;
                            }
                            if (sheetInex == 1)
                            {
                                ProvinceCity provinceCity = new ProvinceCity();
                                provinceCity.setProvince(firstValue);
                                provinceCity.setProvince_n(lastValue);
                                provinceCity.setCity(subValue);
                                provinceCity.setCity_n(cellValue);
                                provinceCities.add(provinceCity);
                            }
                            if (sheetInex == 2)
                            {
                                CityDistrict cityDistrict = new CityDistrict();
                                cityDistrict.setCity(firstValue);
                                cityDistrict.setCity_n(lastValue);
                                cityDistrict.setDistrict(subValue);
                                cityDistrict.setDistrict_n(cellValue);
                                cityDistricts.add(cityDistrict);
                            }
                            if (sheetInex == 3)
                            {
                                DistrictStreet districtStreet = new DistrictStreet();
                                districtStreet.setDistrict(firstValue);
                                districtStreet.setDistrict_n(lastValue);
                                districtStreet.setStreet(subValue);
                                districtStreet.setStreet_n(cellValue);
                                districtStreets.add(districtStreet);
                            }
                        }
                        
                    }
                }
            }
        }
        
        if (sheetInex == 1)
        {
            LOGGER.debug("provinceCities:" + provinceCities);
            areaDao.insertProvinceCity(provinceCities);
        }
        if (sheetInex == 2)
        {
            LOGGER.debug("cityDistricts:" + cityDistricts);
            areaDao.insertCityDistrict(cityDistricts);
        }
        if (sheetInex == 3)
        {
            LOGGER.debug("districtStreets:" + districtStreets);
            areaDao.insertDistrictStreet(districtStreets);
        }
        
    }
    
}
