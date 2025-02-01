package com.org.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException
    {
        String path=".\\testData\\OpenCart_LoginData.XLSX";//Taking Excel File Path

        ExcelUtility xlutil=new ExcelUtility(path);//Object for UtilityClass

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalColumns=xlutil.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalrows][totalColumns];//Created 2D Array

        for(int i=1;i<=totalrows;i++)
        {
            for(int j=0;j<totalColumns;j++)
            {
                loginData[i-1][j]= xlutil.getCellData("Sheet1",i,j);
            }
        }
        return loginData; //Return 2D Array

    }

}
