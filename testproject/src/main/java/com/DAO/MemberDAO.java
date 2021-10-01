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
			String sql = "insert into members values(?, sysdate, ?, ? , ?, 0, ?,'N',sysdate)";
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
		// ����ڰ� �Է��� �̸����� ���̺� �����ϴ��� Ȯ�� ����
		boolean check = false;
		try {
			conn();

			String sql = "select member_Id from members where member_Id=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, memberId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				// ����ڰ� �Է��� �̸����� ���̺� �����ϴ� ���
				check = true;
			} else {
				// ����ڰ� �Է��� �̸����� ���̺� �������� �ʴ� ���
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
		// ����ڰ� �Է��� �̸����� ���̺� �����ϴ��� Ȯ�� ����
		boolean check = false;
		try {
			conn();

			String sql = "select nickname from members where nickname=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, nickname);

			rs = psmt.executeQuery();

			if (rs.next()) {
				// ����ڰ� �Է��� �̸����� ���̺� �����ϴ� ���
				check = true;
			} else {
				// ����ڰ� �Է��� �̸����� ���̺� �������� �ʴ� ���
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

			String sql = "select * from members where member_Id=? and password=?";  //�ٽ��ѹ��غ�����!
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
				String mileage_date = rs.getString(9);

				vo = new MemberVO(nickname, entryDate, password, phone, memberId, mileage, adminYN, payYN,mileage_date);

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

			String sql = "select * from Parties where member_Id=? or member_1=? or member_2=? or member_3=?";  //�ٽ��ѹ��غ�����!
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, memberId);
			psmt.setString(2, memberId);
			psmt.setString(3, memberId);
			psmt.setString(4, memberId);

			rs = psmt.executeQuery();

			while (rs.next()) {
				
				int partyseq = rs.getInt(1);
				Date onpenday = rs.getDate(2);
				String member_Id = rs.getString(3);
				String ott = rs.getString(4);
				String member1 = rs.getString(5);
				String member2 = rs.getString(6);
				String member3 = rs.getString(7);
				String oTTid = rs.getString(8);
				String oTTpw = rs.getString(9);
				String account = rs.getString(10);
				String account_name = rs.getString(11);
				String bank = rs.getString(12);
				
				PartiesVO vo = new PartiesVO(partyseq, onpenday, memberId, ott, member1, member2, member3, oTTid, oTTpw, account, account_name, bank);
				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	public String findPw(String memberId, String phone) {
		

		String pw = null;
		try {
			conn();
			String sql = "select * from members where member_id=? and phone=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, memberId);
			psmt.setString(2, phone);


			rs = psmt.executeQuery();

			if (rs.next()) {
				
			pw= rs.getString(3);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return pw;
	}
	
	public int mileage(int mileage, String memberId, String mileage_date) {

		mileage += 5;
		try {
			conn();
			String sql = "update members set mileage=?,mileage_date=sysdate where member_id=?";
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, mileage);
			psmt.setString(2, memberId);

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mileage;
	}
}
