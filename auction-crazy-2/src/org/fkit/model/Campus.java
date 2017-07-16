package org.fkit.model;
/**
 * 
 *
 create table campus(
   id bigint primary key auto_increment,
   name varchar(32),
   city varchar(32),
   status int ,
   user_defined int 
);
 * @author ASUS
 *
 */
public class Campus {

	private Integer id;
	private String name;
	private String city;
	private Integer status;
	private Integer userDefined;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getUserDefined() {
		return userDefined;
	}


	public void setUserDefined(Integer userDefined) {
		this.userDefined = userDefined;
	}


	@Override
	public String toString() {
		return "Campus [id=" + id + ", name=" + name + ", city=" + city + ", status=" + status + ", userDefined="
				+ userDefined + "]";
	}
	
	
}
