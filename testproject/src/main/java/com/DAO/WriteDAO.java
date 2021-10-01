package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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

	public int write(String subject, String content, String img_pic1, String img_pic2, String img_pic3,
			String memberId) {

		int cnt = 0;
		try {
			conn();
			String sql = "insert into articles (subject, content, img_pic1, img_pic2, img_pic3, member_id, reg_date, cnt, rec_cnt) values(?,?,?,?,?,?,sysdate,0,0)";
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

			String sql = "select * from articles where subject=?"; // 다시한번해보세요!
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
				int cnt = rs.getInt(9);
				int rec_cnt = rs.getInt(10);

				vo2 = new WriteVO(article_seq, subject, content, img_1, img_2, img_3, memberId, reg_date, cnt, rec_cnt);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo2;
	}
	
	public ArrayList<WriteVO> subjectList() {

		ArrayList<WriteVO> list = new ArrayList<WriteVO>();

		conn();

		String sql = "select * from articles ";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) { // 나에게 온 메세지가 몇 개인지 모르기때문에 while문 사용
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

				list.add(new WriteVO(article_seq, subject, content, img_1, img_2, img_3, memberId, reg_date, cnt,
						rec_cnt));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}
	

	//detail_view에서 사용
	public WriteVO subjectList(int seq) {

		WriteVO vo = null;

		conn();

		String sql = "select * from articles where article_seq=?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, seq);
			
			rs = psmt.executeQuery();

			while (rs.next()) { // 나에게 온 메세지가 몇 개인지 모르기때문에 while문 사용
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

				vo = new WriteVO(article_seq, subject, content, img_1, img_2, img_3, memberId, reg_date, cnt,
						rec_cnt);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;

	}
	
	
	public ArrayList<WriteVO> selectPage(int start, int pageCnt) {

		ArrayList<WriteVO> list = new ArrayList<WriteVO>();

		conn();

		/* String sql = "select * from articles "; */
		String sql = "select* from articles where article_seq between ? and ? ";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, start);
			psmt.setInt(2, pageCnt);

			rs = psmt.executeQuery();

			while (rs.next()) { // 나에게 온 메세지가 몇 개인지 모르기때문에 while문 사용
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

				list.add(new WriteVO(article_seq, subject, content, img_1, img_2, img_3, memberId, reg_date, cnt,
						rec_cnt));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

	public int bestCnt() {
		int result = 0;
		conn();

		String sql = "select * rec_cnt from articles where rec_cnt >5 ";

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
	
	public int selectCnt() {
		int result = 0;
		conn();

		String sql = "select count(*) from articles ";

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
	// 하나의 게시글을 보는 메소드

	public WriteVO detailview(int article_seq) {
		WriteVO vo3 = null;
		try {
			conn();

			String sql = "select* from articles where article_seq=?"; // 다시한번해보세요!
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, article_seq);

			rs = psmt.executeQuery();

			if (rs.next()) {
				
				String subject = rs.getString(2);
				String content = rs.getString(3);
				String img_1 = rs.getString(4);
				String img_2 = rs.getString(5);
				String img_3 = rs.getString(6);
				String memberId = rs.getString(7);
				Date reg_date = rs.getDate(8);
				int cnt = rs.getInt(9);
				int rec_cnt = rs.getInt(10);

				vo3 = new WriteVO(article_seq, subject, content, img_1, img_2, img_3, memberId, reg_date, cnt, rec_cnt);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo3;
	}
	
	public int cnt_subject(int article_seq, int cnt) {
		try {
			conn();
			cnt+=1;
			String sql = "update articles set cnt =? where article_seq=?" ; 
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, cnt);
			psmt.setInt(2, article_seq);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}return cnt;
	
	}
	
	public int like( int like,int article) {
		try {
			conn();
			like+=1;
	
			
			String sql = "update articles set REC_CNT=? where article_seq=?" ; // 다시한번해보세요!
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, like);
			psmt.setInt(2, article);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}return like;
	
	}
		
	


}
