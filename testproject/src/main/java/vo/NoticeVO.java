package vo;

import java.sql.Date;

public class NoticeVO {

	
	private String notice_seq;
	private String notice_title;
	private String notice_content;
	private Date input_date;
	private String img_pic1;
	private String img_pic2;
	private String img_pic3;
	private int cnt;
	private String member_id;
	
	public String getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(String notice_seq) {
		this.notice_seq = notice_seq;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Date getInput_date() {
		return input_date;
	}
	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}
	public String getImg_pic1() {
		return img_pic1;
	}
	public void setImg_pic1(String img_pic1) {
		this.img_pic1 = img_pic1;
	}
	public String getImg_pic2() {
		return img_pic2;
	}
	public void setImg_pic2(String img_pic2) {
		this.img_pic2 = img_pic2;
	}
	public String getImg_pic3() {
		return img_pic3;
	}
	public void setImg_pic3(String img_pic3) {
		this.img_pic3 = img_pic3;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	
}
