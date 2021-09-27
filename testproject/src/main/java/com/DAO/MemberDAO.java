package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.MemberVO;
import com.VO.PartiesVO;

public class MemberDAO {
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

	public int join(String nickname, String password, String phone, String memberId, String adminYN) {

		int cnt = 0;
		try {
			conn();
			String sql = "insert into members values(?, sysdate, ?, ? , ?, 0, ?,'N')";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, nickname);
			psmt.setString(2, password);
			psmt.setString(3, phone);
			psmt.setString(4, memberId);
			psmt.setString(5, adminYN);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public boolean emailCheck(String memberId) {
		// 사용자가 입력한 이메일이 테이블에 존재하는지 확인 유무
		boolean check = false;
		try {
			conn();

			String sql = "select member_Id from members where member_Id=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, memberId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				// 사용자가 입력한 이메일이 테이블에 존재하는 경우
				check = true;
			} else {
				// 사용자가 입력한 이메일이 테이블에 존재하지 않는 경우
				check = false;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}

	public boolean nicknameCheck(String nickname) {
		// 사용자가 입력한 이메일이 테이블에 존재하는지 확인 유무
		boolean check = false;
		try {
			conn();

			String sql = "select nickname from members where nickname=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, nickname);

			rs = psmt.executeQuery();

			if (rs.next()) {
				// 사용자가 입력한 이메일이 테이블에 존재하는 경우
				check = true;
			} else {
				// 사용자가 입력한 이메일이 테이블에 존재하지 않는 경우
				check = false;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}

	public MemberVO login(String memberId, String password) {
		MemberVO vo = null;
		try {
			conn();

			String sql = "select * from members where member_Id=? and password=?";  //다시한번해보세요!
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, memberId);
			psmt.setString(2, password);

			rs = psmt.executeQuery();

			if (rs.next()) {

				String nickname = rs.getString(1);
				Date entryDate = rs.getDate(2);
				String phone = rs.getString(4);
				int mileage = rs.getInt(6);
				String adminYN = rs.getString(7);
				String payYN = rs.getString(8);

				vo = new MemberVO(nickname, entryDate, password, phone, memberId, mileage, adminYN, payYN);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public ArrayList<PartiesVO> share(String memberId) {
		ArrayList<PartiesVO> al = new ArrayList<PartiesVO>();
		try {
			conn();

			String sql = "select * from Parties where member_Id=? or member_1=? or member_2=? or member_3=?";  //다시한번해보세요!
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, memberId);
			psmt.setString(2, memberId);
			psmt.setString(3, memberId);
			psmt.setString(4, memberId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				
				String partyseq = rs.getString(1);
				Date onpenday = rs.getDate(2);
				String member_cnt = rs.getString("member_id");
				String member_Id = rs.getString(3);
				String matchingday = rs.getString("member_id");
				String platform = rs.getString(4);
				String pay_yn = rs.getString("member_2");
				String member1 = rs.getString(5);
				String member2 = rs.getString(6);
				String member3 = rs.getString(7);
				String oTTid = rs.getString(8);
				String oTTpw = rs.getString(9);
				
				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}
}
