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
				// �α��� ����
//				int video_seq;
//				String video_title;
//				String video_content;
//				String video_filename;
//				String upload_date;
//				String genre;
//				String ott_platform;
//				String member_id;
//				String actor;
				String poster = rs.getString(4); // ������ �̹��� �̸� ��������

				vo = new VideoVO(0, null, null, poster, null, null, null, null, null, null);
				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// ���� �� ������ �߻����� �� �������
		} finally {
			close();
		}
		return al;
	}
	
	public VideoVO oneselect(String filename) {
		try {
			conn();

			sql = "SELECT * from videos where video_filename = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, filename);

			rs = psmt.executeQuery();
			while (rs.next()) {
				// �α��� ����
//				int video_seq;
				String video_title = rs.getString(2); // ���� ����
				String video_content = rs.getString(3); // ���� �ó�ý�
				String video_filename = rs.getString(4); // ���� ���ϸ�
				String upload_date = rs.getString(5); // �����⵵
				String running_time = rs.getString(6); // �󿵽ð�
				String genre = rs.getString(7); // �帣
				String ott_platform = rs.getString(8); // ott
//				String member_id = rs.getString(9);
				String actor = rs.getString(10); // �⿬���

				vo = new VideoVO(0, video_title, video_content, video_filename, upload_date, running_time, genre, ott_platform,null,actor);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// ���� �� ������ �߻����� �� �������
		} finally {
			close();
		}
		return vo;
	}

	
	
}
