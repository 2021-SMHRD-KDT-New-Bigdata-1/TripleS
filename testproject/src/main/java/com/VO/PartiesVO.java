package com.VO;

import java.sql.Date;

/*�Ʒ� Ŭ������ ��Ƽ��Ī�� ������ ���̺���� ������ ������ model Ŭ�����̴� 
 * by �̱�ȯ */
public class PartiesVO {


	private int party_seq;
	private Date open_date;
	private String memberId;
	private String ott;
	private String member1;
	private String member2;
	private String member3;
	private String ottId;
	private String ottPw;
	private String account;
	private String account_name;
	private String bank;
	
	
	/* ��Ƽ������ ��Ƽ��Ī�� ���۵Ǿ� ��Ƽ���� ���������� �ʿ��� �����͵��� �����ϴ� ������ 
	 * by  �̱�ȯ  */
	public PartiesVO(int party_seq, Date open_date, String memberId, String ott, String member1, String member2,
			String member3, String ottId, String ottPw, String account, String account_name, String bank) {
		super();
		this.party_seq = party_seq;
		this.open_date = open_date;
		this.memberId = memberId;
		this.ott = ott;
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
		this.ottId = ottId;
		this.ottPw = ottPw;
		this.account = account;
		this.account_name = account_name;
		this.bank = bank;
	}
	
	
	
	

	/* ��Ƽ������ ��Ƽ��Ī�� �õ��Ͽ� ��Ƽ��Ī�� ����� ���¿� �ʿ��� �����͵��� �����ϴ� ������
	 * by �̱�ȯ  */
	public PartiesVO(String memberId, String member1, String member2, String member3) {
		super();
		this.memberId = memberId;
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
	}





	public int getParty_seq() {
		return party_seq;
	}


	public void setParty_seq(int party_seq) {
		this.party_seq = party_seq;
	}


	public Date getOpen_date() {
		return open_date;
	}


	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getOtt() {
		return ott;
	}


	public void setOtt(String ott) {
		this.ott = ott;
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


	public String getOttId() {
		return ottId;
	}


	public void setOttId(String ottId) {
		this.ottId = ottId;
	}


	public String getOttPw() {
		return ottPw;
	}


	public void setOttPw(String ottPw) {
		this.ottPw = ottPw;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getAccount_name() {
		return account_name;
	}


	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
	
	
}
