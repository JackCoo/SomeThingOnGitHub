package com.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.one.db.DBUtil;

public class SensorDao {

	
	public boolean checkSignatureBySensorID(int sensorID,String signature) throws SQLException{
		
		String sql = " select device.ID from device"+
					 " join sensor on device.ID = sensor.DeviceID"+
					 " where sensor.ID = ? and device.Signature = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, sensorID);
		ptmt.setString(2, signature);
	    
		ResultSet rs = ptmt.executeQuery();
		if (rs.next()){
			
			return true;		
		}else{
			
			return false;
		}
		
	}
}
