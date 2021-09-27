package vo;

import java.sql.Date;

public class VideoVO {
	
	
	private String video_seq ;
	private String video_title;
	private String video_content ;
	private String video_filename;
	private String video_link;
	private int cnt;
	private int like_cnt ;
	private int dislike_cnt;
	private Date upload_date;
	private int running_time;
	private String genre;
	private String maker;
	private String ott_platform;
	private String member_id;
	
	public String getVideo_seq() {
		return video_seq;
	}
	public void setVideo_seq(String video_seq) {
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
	public String getVideo_link() {
		return video_link;
	}
	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	public int getDislike_cnt() {
		return dislike_cnt;
	}
	public void setDislike_cnt(int dislike_cnt) {
		this.dislike_cnt = dislike_cnt;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public int getRunning_time() {
		return running_time;
	}
	public void setRunning_time(int running_time) {
		this.running_time = running_time;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
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
	
	
	
	

}
