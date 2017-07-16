package com.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.one.db.DBUtil;
import com.one.model.Data;

public class DataDao {
/**
 * 
 * 添加一条data数据
 * 鉴别条件：device表Signature --写在控制层
 * @throws SQLException 
 */
	public void addData(Data data) throws SQLException{
		
		String sql = " insert into data"+
					 " (SensorID,Time,IP,Value)"+
					 " value"+
					 " (?,current_time,?,?)";//利用mysql函数为时间赋值
		//1.获得数据库连接
		Connection conn = DBUtil.getConnection();
		//2.创建preparestatemetn对象
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//3.为参数赋值
		ptmt.setInt(1, data.getSensorId());
		ptmt.setString(2, data.getIp());
		ptmt.setString(3, data.getValue());
		//4.执行
		ptmt.executeUpdate();
		
	}
/**
 * 
 * 获取sensor的最新N条数据	
 * @param senesorId
 * @param num
 * @return
 * @throws SQLException 
 */
	public List<Data> getDataBySensroId(int senesorID,int num) throws SQLException{
		
		String sql = " select *"+
					 " from data where "+
					 " SensorID = ?"+
					 " order by Time desc limit ?";
		//value：time --不能使用map，数值可能有重复
		//Map<String, Date> map = new HashMap<>();
		
		//Data对象集合
		List<Data> dataList = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, senesorID);
		ptmt.setInt(2, num);
		
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()){
			//封装结果集数据为Data对象
			Data data = new Data();
			data.setId(rs.getInt("ID"));
			data.setIp(rs.getString("IP"));
			data.setSensorId(rs.getInt("SensorID"));
			data.setTime(rs.getTimestamp("Time"));//getData或者getTime只会单独返回日期和时间部分
			data.setValue(rs.getString("Value"));
			//将data对象放入list集合
			dataList.add(data);
		}
		return dataList;
	}
	
}
