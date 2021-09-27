package com.VO;

import java.sql.Date;

public class replyVO {
	
	private int reply_seq;
	private int article_seq;
	private String reply_comment;
	private String memberId;
	private Date reg_date;
	
	public replyVO(int reply_seq, int article_seq, String reply_comment, String memberId, Date reg_date) {
		super();
		this.reply_seq = reply_seq;
		this.article_seq = article_seq;
		this.reply_comment = reply_comment;
		this.memberId = memberId;
		this.reg_date = reg_date;
	}

	public int getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}

	public int getArticle_seq() {
		return article_seq;
	}

	public void setArticle_seq(int article_seq) {
		this.article_seq = article_seq;
	}

	public String getReply_comment() {
		return reply_comment;
	}

	public void setReply_comment(String reply_comment) {
		this.reply_comment = reply_comment;
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
	
	
	
}
