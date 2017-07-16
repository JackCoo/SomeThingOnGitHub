package org.fkit.model;

import java.io.Serializable;
import java.util.Date;

/**
create table user(
   id bigint primary key auto_increment,
   phone varchar(255),
   username varchar(255),
   password varchar(255),
   email varchar(32),
   campus_id int,
   register_time datetime,
   sex int ,
   major varchar(32),
   last_login datetime,
   credit_rating int ,
   head_pic varchar(32),
   token varchar(32),
   is_del int 
);


 * */
public class User implements Serializable{

	private Integer id;//用户ID
	private  String phone;//用户电话
	private String username;//
	private String password;
	private String email;
	private Date registerTime;
	private Integer sex;
	
	private Campus campus;
	
	private String major;
	private Date lastLogin;
	private Integer creditRating;
	private String headPic;
	private String token;
	private Integer isDel;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getRegisterTime() {
		return registerTime;
	}


	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}


	public Integer getSex() {
		return sex;
	}


	public void setSex(Integer sex) {
		this.sex = sex;
	}


	public Campus getCampus() {
		return campus;
	}


	public void setCampus(Campus campus) {
		this.campus = campus;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public Date getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}


	public Integer getCreditRating() {
		return creditRating;
	}


	public void setCreditRating(Integer creditRating) {
		this.creditRating = creditRating;
	}


	public String getHeadPic() {
		return headPic;
	}


	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Integer getIsDel() {
		return isDel;
	}


	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", username=" + username + ", password=" + password + ", email="
				+ email + ", registerTime=" + registerTime + ", sex=" + sex + ", campus=" + campus + ", major=" + major
				+ ", lastLogin=" + lastLogin + ", creditRating=" + creditRating + ", headPic=" + headPic + ", token="
				+ token + ", isDel=" + isDel + "]";
	}
	
	
	
}
