package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.VideoVO;


public class VideoDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String sql = null;
	VideoVO vo = null;
	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_6";
			String dbpw = "smhrd6";
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<VideoVO> select() {
		ArrayList<VideoVO> al = new ArrayList<VideoVO>();

		try {
			conn();

			sql = "SELECT * from videos";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				// 로그인 성공
//				int video_seq;
//				String video_title;
//				String video_content;
//				String video_filename;
//				String upload_date;
//				String genre;
//				String ott_platform;
//				String member_id;
//				String actor;
				String poster = rs.getString(4); // 포스터 이미지 이름 가져오기

				vo = new VideoVO(0, null, null, poster, null, null, null, null, null);
				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// 실행 후 오류가 발생했을 때 에러출력
		} finally {
			close();
		}
		return al;
	}

	
	
}
