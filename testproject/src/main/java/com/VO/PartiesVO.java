package com.VO;

import java.sql.Date;

public class PartiesVO {

	private int partyseq;
	private Date onpenday;
	private int member_cnt;
	private String memberId;
	private Date matchingday;
	private String platform;
	private String pay_yn;
	private String member1;
	private String member2;
	private String member3;
	private String OTTid;
	private String OTTpw;
	
	
	public PartiesVO(int partyseq, Date onpenday, int member_cnt, String memberId, Date matchingday, String platform,
			String pay_yn, String member1, String member2, String member3, String oTTid, String oTTpw) {
		super();
		this.partyseq = partyseq;
		this.onpenday = onpenday;
		this.member_cnt = member_cnt;
		this.memberId = memberId;
		this.matchingday = matchingday;
		this.platform = platform;
		this.pay_yn = pay_yn;
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
		OTTid = oTTid;
		OTTpw = oTTpw;
	}


	public int getPartyseq() {
		return partyseq;
	}


	public void setPartyseq(int partyseq) {
		this.partyseq = partyseq;
	}


	public Date getOnpenday() {
		return onpenday;
	}


	public void setOnpenday(Date onpenday) {
		this.onpenday = onpenday;
	}


	public int getMember_cnt() {
		return member_cnt;
	}


	public void setMember_cnt(int member_cnt) {
		this.member_cnt = member_cnt;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public Date getMatchingday() {
		return matchingday;
	}


	public void setMatchingday(Date matchingday) {
		this.matchingday = matchingday;
	}


	public String getPlatform() {
		return platform;
	}


	public void setPlatform(String platform) {
		this.platform = platform;
	}


	public String getPay_yn() {
		return pay_yn;
	}


	public void setPay_yn(String pay_yn) {
		this.pay_yn = pay_yn;
	}


	public String getMember1() {
		return member1;
	}


	public void setMember1(String member1) {
		this.member1 = member1;
	}


	public String getMember2() {
		return member2;
	}


	public void setMember2(String member2) {
		this.member2 = member2;
	}


	public String getMember3() {
		return member3;
	}


	public void setMember3(String member3) {
		this.member3 = member3;
	}


	public String getOTTid() {
		return OTTid;
	}


	public void setOTTid(String oTTid) {
		OTTid = oTTid;
	}


	public String getOTTpw() {
		return OTTpw;
	}


	public void setOTTpw(String oTTpw) {
		OTTpw = oTTpw;
	}
	
	
	
	
}
