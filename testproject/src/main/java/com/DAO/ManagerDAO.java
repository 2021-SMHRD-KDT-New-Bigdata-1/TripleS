package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.MemberVO;
import com.VO.Write2VO;
import com.VO.WriteVO;

public class ManagerDAO {
	
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
	

	public ArrayList<MemberVO> select() {
		ArrayList<MemberVO> al = new ArrayList<MemberVO>();
		try {
			conn();

			String sql = "select * from members";  //다시한번해보세요!
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				
				String nickname = rs.getString(1);
				Date entryDate = rs.getDate(2);
				String password = rs.getString(3);
				String phone = rs.getString(4);
				String memberId = rs.getString(5);
				int mileage = rs.getInt(6);
				String adminYN = rs.getString(7);
				String payYN = rs.getString(8);
				String mileage_date = rs.getString(9);
				
				MemberVO vo = new MemberVO(nickname, entryDate, password, phone, memberId, mileage, adminYN, payYN, mileage_date);
				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}
	
	public int selectCnt() {
		int result = 0;
		conn();

		String sql = "select count(*) from members ";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public void delete(String memberId) {
		
		conn();

		String sql = "delete from members where member_id=? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);

			psmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public ArrayList<WriteVO> select_best1() {
		ArrayList<WriteVO> al = new ArrayList<WriteVO>();
		try {
		conn();
		String sql = "select * from articles order by rec_cnt desc"; // 다시한번해보세요!
		psmt = conn.prepareStatement(sql);


		rs = psmt.executeQuery();

		while(rs.next()) {

			int article_seq = rs.getInt(1);
			String subject = rs.getString(2);
			String content = rs.getString(3);
			String img_1 = rs.getString(4);
			String img_2 = rs.getString(5);
			String img_3 = rs.getString(6);
			String memberId = rs.getString(7);
			Date reg_date = rs.getDate(8);
			int cnt = rs.getInt(9);
			int rec_cnt = rs.getInt(10);
			String nickname = rs.getString(11);

			WriteVO vo = new WriteVO(article_seq, subject, content, img_1, img_2, img_3, memberId, reg_date, cnt, rec_cnt, nickname);
			al.add(vo);
		} }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}return al;
	}
	
	public ArrayList<Write2VO> select_best2() {
		ArrayList<Write2VO> al = new ArrayList<Write2VO>();
		try {
		conn();
		String sql = "select * from articles_2 order by rec_cnt desc"; // 다시한번해보세요!
		psmt = conn.prepareStatement(sql);


		rs = psmt.executeQuery();

		while (rs.next()) {

			int article_seq = rs.getInt(1);
			String subject = rs.getString(2);
			String content = rs.getString(3);
			String img_1 = rs.getString(4);
			String img_2 = rs.getString(5);
			String img_3 = rs.getString(6);
			String memberId = rs.getString(7);
			Date reg_date = rs.getDate(8);
			int cnt = rs.getInt(9);
			int rec_cnt = rs.getInt(10);
			String nickname = rs.getString(11);

			Write2VO vo = new Write2VO(article_seq, subject, content, img_1, img_2, img_3, memberId, reg_date, cnt, rec_cnt, nickname);
			al.add(vo);
		} }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}return al;
	}
	
	public MemberVO bSelect(String memberId) {
		MemberVO vo = null;
		try {
		conn();
		String sql = "select * from members where member_id=?"; // 다시한번해보세요!
		psmt = conn.prepareStatement(sql);

		psmt.setString(1, memberId);

		rs = psmt.executeQuery();

		if (rs.next()) {

			String nickname = rs.getString(1);
			Date entryDate = rs.getDate(2);
			String password = rs.getString(3);
			String phone = rs.getString(4);
			int mileage = rs.getInt(6);
			String adminYN = rs.getString(7);
			String payYN = rs.getString(8);
			String mileage_date = rs.getString(9);
			
			vo = new MemberVO(nickname, entryDate, password, phone, memberId, mileage, adminYN, payYN, mileage_date);
		} }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}return vo;
	}
	
	
}
