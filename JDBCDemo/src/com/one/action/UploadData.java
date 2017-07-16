package com.one.action;

import java.sql.SQLException;
import java.util.Map;

import com.one.dao.DataDao;
import com.one.dao.SensorDao;
import com.one.dao.userDao;
import com.one.model.Data;

/**
 * 节点上传数据
 * @author C4y
 *
 */
public class UploadData {

	public void upload(Map<String,String> map) throws SQLException{
		
		int sensorID = Integer.parseInt(map.get("sensorID"));//通过Integer的parseInt方法将String转成int类型
		String value = map.get("value");
		String ip = "127.0.0.1";
		String signature = map.get("signature");
		
		if (new SensorDao().checkSignatureBySensorID(sensorID, signature)){//验证signature是否匹配sensorID所属的device
			//封装map为data对象
			Data d = new Data();
			d.setIp(ip);
			d.setSensorId(sensorID);
			d.setValue(value);
			//调用DataDao将数据写入数据库
			DataDao dd = new DataDao();
			dd.addData(d);
		}else{
			System.out.println("UploadData.upload:Signature或者SensorID有误！");
		}
	
	}
}
