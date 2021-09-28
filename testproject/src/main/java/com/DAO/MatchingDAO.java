package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.VO.MemberVO;
import com.VO.PartiesVO;

public class MatchingDAO {

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
	
	public int waiting(String memberId, String OTT) {
		
		int cnt = 0;
		try {
			conn();
			String sql = "insert into waiting values(WAITING_SEQ.NEXTVAL,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, memberId);
			psmt.setString(2, OTT);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
public int parties(String memberId, String OTT, String OTTID, String OTTPW, String Account, String AccountName, String Bank) {
		
		int cnt = 0;
		try {
			conn();
			String sql = "insert into parties values(PARTIES_SEQ.NEXTVAL,sysdate,?,?,null,null,null,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, memberId);
			psmt.setString(2, OTT);
			psmt.setString(3, OTTID);
			psmt.setString(4, OTTPW);
			psmt.setString(5, Account);
			psmt.setString(6, AccountName);
			psmt.setString(7, Bank);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

public String hostId(String OTT) {
	
	String hostId = "";
	try {
		conn();
		String sql = "select member_id from parties where ott_platform = ? and (member_1 is null or member_2 is null or member_3 is null) and rownum = 1 order by party_seq";
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, OTT);

		rs = psmt.executeQuery();
		
		if (rs.next()) {

			hostId = rs.getString(1);
		} else {
			hostId = null;
		}
		

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return hostId;
}


public PartiesVO member123(String hostId) {
	PartiesVO vo =null;
	/* String[] member_list = new String [3]; */
	try {
		conn();
		String sql = "select member_1, member_2, member_3 from parties where member_id = ?";
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, hostId);

		rs = psmt.executeQuery();
		
		if (rs.next()) {

			String member_1 = rs.getString(1);
			String member_2 = rs.getString(2);
			String member_3 = rs.getString(3);
			
			vo = new PartiesVO(hostId, member_1, member_2, member_3);

		}
		

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return vo;
}

public int member1(String memberId , String hostId) {
	
	int cnt = 0;
	try {
		conn();
		String sql = "update parties set member_1 = ? where member_id = ?";
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, memberId);
		psmt.setString(2, hostId);

		cnt = psmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return cnt;
	
}


public int member2(String memberId , String hostId) {
	
	int cnt = 0;
	try {
		conn();
		String sql = "update parties set member_2 = ? where member_id = ?";
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, memberId);
		psmt.setString(2, hostId);

		cnt = psmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return cnt;
	
}
	

public int member3(String memberId , String hostId) {
	
	int cnt = 0;
	try {
		conn();
		String sql = "update parties set member_3 = ? where member_id = ?";
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, memberId);
		psmt.setString(2, hostId);

		cnt = psmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return cnt;
	
}
	
}
