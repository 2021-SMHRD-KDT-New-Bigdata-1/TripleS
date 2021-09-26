package vo;

import java.sql.Date;

public class MatchingVO {

	private String matching_seq;
	private String party_seq;
	private String member_id;
	private Date matching_date;
	private String ott_id;
	private String pay_yn;
	public String getMatching_seq() {
		return matching_seq;
	}
	public void setMatching_seq(String matching_seq) {
		this.matching_seq = matching_seq;
	}
	public String getParty_seq() {
		return party_seq;
	}
	public void setParty_seq(String party_seq) {
		this.party_seq = party_seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getMatching_date() {
		return matching_date;
	}
	public void setMatching_date(Date matching_date) {
		this.matching_date = matching_date;
	}
	public String getOtt_id() {
		return ott_id;
	}
	public void setOtt_id(String ott_id) {
		this.ott_id = ott_id;
	}
	public String getPay_yn() {
		return pay_yn;
	}
	public void setPay_yn(String pay_yn) {
		this.pay_yn = pay_yn;
	}

}
