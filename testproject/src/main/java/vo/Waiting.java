package vo;

public class Waiting {
	
	private int waiting_seq;
	private String memberId;
	private String ott;
	
	
	public Waiting(int waiting_seq, String memberId, String ott) {
		super();
		this.waiting_seq = waiting_seq;
		this.memberId = memberId;
		this.ott = ott;
	}


	public int getWaiting_seq() {
		return waiting_seq;
	}


	public void setWaiting_seq(int waiting_seq) {
		this.waiting_seq = waiting_seq;
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
	
	
	
	

}
