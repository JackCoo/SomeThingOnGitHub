package com.one.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.one.model.Data;

public class DataDaoTest {

	@Test
	public void testAddData() throws SQLException {
	
		Data d = new Data();
		d.setSensorId(10001);
		d.setValue("59");
		d.setIp("127.0.0.1");
		
		DataDao dataDao = new DataDao();
		dataDao.addData(d);
	}
	
	//@Test
	public void testGetDataBySensroId() throws SQLException {
	
		DataDao dataDao = new DataDao();
		List<Data> datalist = dataDao.getDataBySensroId(10001, 2);
		
		for(int i = 0;i < datalist.size();i++){
			
			Data data = datalist.get(i);
			System.out.print(data.getId() +"  ");
			System.out.print(data.getIp() +"  ");
			System.out.print(data.getSensorId() +"  ");
			System.out.print(data.getValue() +"  ");
			System.out.print(data.getTime() +"  ");
			System.out.println();
		}
		
	}

}