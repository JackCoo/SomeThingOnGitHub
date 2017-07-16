package com.one.action;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UploadDataTest {

	@Test
	public void testUpload() throws SQLException {
	
		Map<String, String> map = new HashMap();
		map.put("sensorID", "10001");	
		map.put("value", "101");
		map.put("signature", "55b71d8");
		
		new UploadData().upload(map);
	}

}
