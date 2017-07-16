package com.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.one.db.DBUtil;

public class DeviceDao {
/**
 * 根据deviceID验证signature
 * @param deviceID
 * @param signature
 * @return
 * @throws SQLException
 */
	public boolean checkSignatureByDeviceID (String deviceID,String signature) throws SQLException{
		//拼接sql语句
		String sql  = " select id from device where"+
					  " id = ? and signature = ?";
		//获取数据库连接	
		Connection conn = DBUtil.getConnection();
		//创建preparestatement对象
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//为参数赋值
		ptmt.setString(1, deviceID);
		ptmt.setString(2, signature);
		//执行获得结果集
		ResultSet rs = ptmt.executeQuery();
		//结果集是否为空
		return rs.next();

	}
}
