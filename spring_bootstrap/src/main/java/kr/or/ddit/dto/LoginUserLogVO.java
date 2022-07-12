package kr.or.ddit.dto;

import java.util.Date;

public class LoginUserLogVO {
	private String id;
	private String phone;
	private String email;
	private String ipAddress;
	private Date indate;
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public Date getIndate() {
		return indate;
	}
	
	
}
