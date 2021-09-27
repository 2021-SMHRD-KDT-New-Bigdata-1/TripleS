package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.VO.MemberVO;
import com.VO.WriteVO;

public class WriteDAO {

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

	public int write(String subject, String content, String img_pic1, String img_pic2, String img_pic3, String memberId) {

		int cnt = 0;
		try {
			conn();
			String sql = "insert into articles values(articles_seq.nextval,?,?,?,?,?,?,sysdate,0,0)";
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
	public WriteVO view(String subject) {
		WriteVO vo2 = null;
		try {
			conn();

			String sql = "select * from articles where subject=?";  //다시한번해보세요!
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, subject);
		

			rs = psmt.executeQuery();

			if (rs.next()) {

				
				
				int article_seq = rs.getInt(1);
			
				String content = rs.getString(3);
				String img_1 = rs.getString(4);
				String img_2 = rs.getString(5);
				String img_3 = rs.getString(6);
				String memberId = rs.getString(7); 
				Date reg_date = rs.getDate(8);
				int cnt= rs.getInt(9);
				int rec_cnt= rs.getInt(10);
				
				
				
				vo2 = new WriteVO(article_seq, reg_date, content, img_1,img_2,img_3,memberId,subject, cnt, rec_cnt);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo2;
	}
	

	
	
	


}
