package com.VO;

import java.sql.Date;

public class WriteVO {

	private int article_seq;
	private String subject;
	private String content;
	private String img_pic1;
	private String img_pic2;
	private String img_pic3;
	private String memberId;
	private Date reg_date;
	private int cnt;
	private int rec_cnt;
	
	public WriteVO(int articles_seq, String subject, String content, String img_pic1, String img_pic2, String img_pic3,
			String memberId, Date reg_date, int cnt, int rec_cnt) {
		super();
		this.article_seq = articles_seq;
		this.subject = subject;
		this.content = content;
		this.img_pic1 = img_pic1;
		this.img_pic2 = img_pic2;
		this.img_pic3 = img_pic3;
		this.memberId = memberId;
		this.reg_date = reg_date;
		this.cnt = cnt;
		this.rec_cnt = rec_cnt;
	}
	
	public int getArticles_seq() {
		return article_seq;
	}

	public void setArticles_seq(int articles_seq) {
		this.article_seq = articles_seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getRec_cnt() {
		return rec_cnt;
	}

	public void setRec_cnt(int rec_cnt) {
		this.rec_cnt = rec_cnt;
	}


	
	

}
