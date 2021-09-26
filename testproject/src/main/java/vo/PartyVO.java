package vo;

import java.sql.Date;

public class PartyVO {
	
	private String party_seq;
	private String party_name;
	private Date open_date;
	private String account_name;
	private int permit_cnt;
	private String member_id;
	
	
	public String getParty_seq() {
		return party_seq;
	}
	public void setParty_seq(String party_seq) {
		this.party_seq = party_seq;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public int getPermit_cnt() {
		return permit_cnt;
	}
	public void setPermit_cnt(int permit_cnt) {
		this.permit_cnt = permit_cnt;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
}
