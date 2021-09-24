package com.VO;

public class WriteVO {


	
	private String subject;
	private String content;
	private String img_pic1;
	private String img_pic2;
	private String img_pic3;
	
	public WriteVO(String subject, String content, String img_pic1, String img_pic2, String img_pic3) {
		super();
		this.subject = subject;
		this.content = content;
		this.img_pic1 = img_pic1;
		this.img_pic2 = img_pic2;
		this.img_pic3 = img_pic3;
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
	
	
	

	
	
	
}
