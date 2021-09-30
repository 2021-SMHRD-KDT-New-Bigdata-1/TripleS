package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class write2DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

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
	public int write(String subject, String content, String img_pic1, String img_pic2, String img_pic3,
			String memberId) {

		int cnt = 0;
		try {
			conn();
			String sql = "insert into articles_2 (subject, content, img_pic1, img_pic2, img_pic3, member_id, reg_date, cnt, rec_cnt) values(?,?,?,?,?,?,sysdate,0,0)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, subject);
			psmt.setString(2, content);
			psmt.setString(3, img_pic1);
			psmt.setString(4, img_pic2);
			psmt.setString(5, img_pic3);
			psmt.setString(6, memberId);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

}
