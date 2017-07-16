package com.one.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class SensorDaoTest {

	@Test
	public void testCheckSignatureBySensorID() throws SQLException {
		
		boolean sd = new SensorDao().checkSignatureBySensorID(10002, "55b71d");
		System.out.println(sd);
	}

}
