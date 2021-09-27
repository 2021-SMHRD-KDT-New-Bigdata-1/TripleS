package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	
	
}
