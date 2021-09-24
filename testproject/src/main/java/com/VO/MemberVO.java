package com.VO;

import java.sql.Date;

public class MemberVO {

	private String nickname;
	private Date entryDate;
	private String password;
	private String phone;
	private String memberId;
	private int mileage;
	private String adminYN;
	private String payYN;
	
	public MemberVO(String nickname, Date entryDate, String password, String phone, String memberId, int mileage,
			String adminYN, String payYN) {
		super();
		this.nickname = nickname;
		this.entryDate = entryDate;
		this.password = password;
		this.phone = phone;
		this.memberId = memberId;
		this.mileage = mileage;
		this.adminYN = adminYN;
		this.payYN = payYN;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getAdminYN() {
		return adminYN;
	}

	public void setAdminYN(String adminYN) {
		this.adminYN = adminYN;
	}

	public String getPayYN() {
		return payYN;
	}

	public void setPayYN(String payYN) {
		this.payYN = payYN;
	}
	
	
	
	
	
	
}
