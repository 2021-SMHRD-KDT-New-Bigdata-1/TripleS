package com.VO;

public class VideoVO {
	
	private int video_seq;
	private String video_title;
	private String video_content;
	private String video_filename;
	private String upload_date;
	private String genre;
	private String ott_platform;
	private String member_id;
	private String actor;
	
	
	
	public VideoVO(int video_seq, String video_title, String video_content, String video_filename, String upload_date,
			String genre, String ott_platform, String member_id, String actor) {
		super();
		this.video_seq = video_seq;
		this.video_title = video_title;
		this.video_content = video_content;
		this.video_filename = video_filename;
		this.upload_date = upload_date;
		this.genre = genre;
		this.ott_platform = ott_platform;
		this.member_id = member_id;
		this.actor = actor;
	}
	
	
	public int getVideo_seq() {
		return video_seq;
	}
	public void setVideo_seq(int video_seq) {
		this.video_seq = video_seq;
	}
	public String getVideo_title() {
		return video_title;
	}
	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	public String getVideo_content() {
		return video_content;
	}
	public void setVideo_content(String video_content) {
		this.video_content = video_content;
	}
	public String getVideo_filename() {
		return video_filename;
	}
	public void setVideo_filename(String video_filename) {
		this.video_filename = video_filename;
	}
	public String getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getOtt_platform() {
		return ott_platform;
	}
	public void setOtt_platform(String ott_platform) {
		this.ott_platform = ott_platform;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
}
