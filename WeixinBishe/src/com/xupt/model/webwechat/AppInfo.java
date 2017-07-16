package com.xupt.model.webwechat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppInfo {
	@JsonProperty("AppID")
	private String AppID;
	@JsonProperty("Type")
	private int Type;
	public String getAppID() {
		return AppID;
	}
	public void setAppID(String appID) {
		AppID = appID;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "AppInfo [AppID=" + AppID + ", Type=" + Type + "]";
	}

}
