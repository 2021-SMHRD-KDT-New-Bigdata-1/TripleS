package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.MemberVO;

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
	
	
}
