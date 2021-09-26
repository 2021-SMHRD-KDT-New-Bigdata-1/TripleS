package vo;

import java.sql.Date;

public class OttidVO {
	
	private String ott_id; 
	private String ott_pwd; 
	private String ott_platform; 
	private Date ott_entrydate;
	public String getOtt_id() {
		return ott_id;
	}
	public void setOtt_id(String ott_id) {
		this.ott_id = ott_id;
	}
	public String getOtt_pwd() {
		return ott_pwd;
	}
	public void setOtt_pwd(String ott_pwd) {
		this.ott_pwd = ott_pwd;
	}
	public String getOtt_platform() {
		return ott_platform;
	}
	public void setOtt_platform(String ott_platform) {
		this.ott_platform = ott_platform;
	}
	public Date getOtt_entrydate() {
		return ott_entrydate;
	}
	public void setOtt_entrydate(Date ott_entrydate) {
		this.ott_entrydate = ott_entrydate;
	} 
	
}
