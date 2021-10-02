package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.VO.Write3VO;
import com.VO.WriteVO;

public class Write3DAO {

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
			String sql = "insert into notices ( notice_title, notice_content, input_date, img_pic1, img_pic2, img_pic3, cnt,member_id) values(?,?,sysdate,?,?,?,0,?)";
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


	public Write3VO view(String subject) {
		Write3VO vo2 = null;
		try {
			conn();

			String sql = "select * from notices where notice_title=?"; 
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, subject);

			rs = psmt.executeQuery();

			if (rs.next()) {

				int notice_seq = rs.getInt(1);
				String notice_content = rs.getString(3);
				Date input_date = rs.getDate(4);
				String img_1 = rs.getString(5);
				String img_2 = rs.getString(6);
				String img_3 = rs.getString(7);
				int cnt = rs.getInt(8);
				String memberId = rs.getString(9);


				vo2 = new Write3VO(notice_seq, subject, notice_content,input_date, img_1, img_2, img_3, cnt,memberId);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo2;
	}
	
	public ArrayList<Write3VO> subjectList() {

		ArrayList<Write3VO> list = new ArrayList<Write3VO>();

		conn();

		String sql = "select * from notices";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) { // 나에게 온 메세지가 몇 개인지 모르기때문에 while문 사용
				int notice_seq = rs.getInt(1);
				String notice_title = rs.getString(2);
				String notice_content = rs.getString(3);
				Date input_date = rs.getDate(4);
				String img_1 = rs.getString(5);
				String img_2 = rs.getString(6);
				String img_3 = rs.getString(7);
				int cnt = rs.getInt(8);
				String memberId = rs.getString(9);

				list.add(new Write3VO(notice_seq,notice_title,notice_content,input_date, img_1, img_2, img_3, cnt,memberId));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}
	

	//detail_view에서 사용
	public Write3VO subjectList(int seq) {

		Write3VO vo = null;

		conn();

		String sql = "select * from notice where notice_seq=?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, seq);
			
			rs = psmt.executeQuery();

			while (rs.next()) { // 나에게 온 메세지가 몇 개인지 모르기때문에 while문 사용
				int notice_seq = rs.getInt(1);
				String notice_title = rs.getString(2);
				String notice_content = rs.getString(3);
				Date input_date = rs.getDate(4);
				String img_1 = rs.getString(5);
				String img_2 = rs.getString(6);
				String img_3 = rs.getString(7);
				int cnt = rs.getInt(8);
				String memberId = rs.getString(9);

				vo = new Write3VO(notice_seq,notice_title, notice_content,input_date, img_1, img_2, img_3, cnt,memberId);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;

	}
	
	
	
	// 하나의 게시글을 보는 메소드

	public Write3VO detailview(int notice_seq) {
		Write3VO vo3 = null;
		try {
			conn();

			String sql = "select* from notices where notice_seq=?"; // 다시한번해보세요!
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, notice_seq);

			rs = psmt.executeQuery();

			if (rs.next()) {
				
				
				String notice_title = rs.getString(2);
				String notice_content = rs.getString(3);
				Date input_date = rs.getDate(4);
				String img_1 = rs.getString(5);
				String img_2 = rs.getString(6);
				String img_3 = rs.getString(7);
				int cnt = rs.getInt(8);
				String memberId = rs.getString(9);

				vo3 = new Write3VO(notice_seq,  notice_title, notice_content,input_date, img_1, img_2, img_3, cnt,memberId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo3;
	}
	
	public int cnt_subject(int notice_seq, int cnt) {
		try {
			conn();
			cnt+=1;
			String sql = "update notice set cnt =? where notice_seq=?" ; 
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, cnt);
			psmt.setInt(2, notice_seq);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}return cnt;
	
	}
	
	
		
	


}
