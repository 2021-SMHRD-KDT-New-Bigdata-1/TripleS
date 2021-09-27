package vo;

import java.sql.Date;

public class ArticleVO {

	
	private int article_seq;
	public int getArticle_seq() {
		return article_seq;
	}
	public void setArticle_seq(int article_seq) {
		this.article_seq = article_seq;
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
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	private String subject;
	private String content;
	private String img_pic1;
	private String img_pic2;
	private String img_pic3;
	private String member_id;
	private Date reg_date;
	private int cnt;
	private int rec_cnt;

	
}
