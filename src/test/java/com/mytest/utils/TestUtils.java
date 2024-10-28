package com.mytest.utils;

import java.io.Reader;
import java.util.ArrayList;

import com.myutils.utils.Xls_Reader;

public class TestUtils {
	static Xls_Reader reader;

	public static ArrayList<Object[][]> getDataFromUtils() {
		ArrayList<Object[][]> myDate = new ArrayList<Object[][]>();
		try {
			reader = new Xls_Reader(System.getProperty("user.dir")+ "\\DataFile\\TestDataFile.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum<=reader.getRowCount("invalidLogin");rowNum++) {
			String username = reader.getCellData("invalidLogin", "username", rowNum);
			String password = reader.getCellData("invalidLogin", "password", rowNum);
			Object[][] obj = {{username,password}};
			myDate.add(obj);
		}
		return myDate;
		
		
	}
}
