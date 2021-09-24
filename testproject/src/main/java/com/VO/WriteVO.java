package com.VO;

public class WriteVO {


	
	private String SUBJECT;
	private String MEMBER_ID;
	private String REG_DATE;
	private String CONTENT;
	private String IMG_PIC1;
	private String IMG_PIC2;
	private String IMG_PIC3;
	
	public WriteVO(String sUBJECT, String mEMBER_ID, String rEG_DATE, String cONTENT, String iMG_PIC1, String iMG_PIC2,
			String iMG_PIC3) {
		super();
		SUBJECT = sUBJECT;
		MEMBER_ID = mEMBER_ID;
		REG_DATE = rEG_DATE;
		CONTENT = cONTENT;
		IMG_PIC1 = iMG_PIC1;
		IMG_PIC2 = iMG_PIC2;
		IMG_PIC3 = iMG_PIC3;
	}

	public String getSUBJECT() {
		return SUBJECT;
	}

	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}

	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public String getREG_DATE() {
		return REG_DATE;
	}

	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getIMG_PIC1() {
		return IMG_PIC1;
	}

	public void setIMG_PIC1(String iMG_PIC1) {
		IMG_PIC1 = iMG_PIC1;
	}

	public String getIMG_PIC2() {
		return IMG_PIC2;
	}

	public void setIMG_PIC2(String iMG_PIC2) {
		IMG_PIC2 = iMG_PIC2;
	}

	public String getIMG_PIC3() {
		return IMG_PIC3;
	}

	public void setIMG_PIC3(String iMG_PIC3) {
		IMG_PIC3 = iMG_PIC3;
	}
	
	
	
	
	
	
}
