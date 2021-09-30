package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.VideoVO;
import com.VO.replyVO;

public class replyDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String sql = null;
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
	// 댓글 DB에 저장하기
	// video_seq 널가능
	// 게시판 댓글에서는 video_seq 널값으로 지정하세여
	public int insert(int article_seq,String reply_comment, String memberId,String video_seq,String nickname) {
		int cnt = 0;
		try {
			conn();
			sql = "insert into replies values(replies_seq.nextval,?,?,?,sysdate,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, article_seq);
			psmt.setString(2, reply_comment);
			psmt.setString(3, memberId);
			psmt.setString(4, video_seq);
			psmt.setString(5, nickname);
			

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public ArrayList<replyVO> rselect(String video_seq) {
		ArrayList<replyVO> al = new ArrayList<replyVO>();

		try {
			conn();

			sql = "SELECT * from replies where video_seq = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, video_seq);

			rs = psmt.executeQuery();
			while (rs.next()) {
				int REPLY_SEQ = rs.getInt(1);
				int ARTICLE_SEQ = rs.getInt(2);
				String REPLY_COMMENT = rs.getString(3);
				String MEMBER_ID = rs.getString(4);
				Date REG_DATE = rs.getDate(5);
				String VIDEO_SEQ = rs.getString(6);
				String NICKNAME = rs.getString(7);

				replyVO  rvo = new replyVO(REPLY_SEQ, ARTICLE_SEQ, REPLY_COMMENT, MEMBER_ID, REG_DATE, VIDEO_SEQ,NICKNAME );
				al.add(rvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// 실행 후 오류가 발생했을 때 에러출력
		} finally {
			close();
		}
		return al;
	}
	
	public ArrayList<replyVO> dselect(int article_seq) {
		ArrayList<replyVO> al = new ArrayList<replyVO>();

		try {
			conn();

			sql = "SELECT * from replies where ARTICLE_SEQ = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, article_seq);

			rs = psmt.executeQuery();
			while (rs.next()) {
				int REPLY_SEQ = rs.getInt(1);
				int ARTICLE_SEQ = rs.getInt(2);
				String REPLY_COMMENT = rs.getString(3);
				String MEMBER_ID = rs.getString(4);
				Date REG_DATE = rs.getDate(5);
				String VIDEO_SEQ = rs.getString(6);
				String NICKNAME = rs.getString(7);

				replyVO  rvo = new replyVO(REPLY_SEQ, ARTICLE_SEQ, REPLY_COMMENT, MEMBER_ID, REG_DATE, VIDEO_SEQ,NICKNAME );
				al.add(rvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// 실행 후 오류가 발생했을 때 에러출력
		} finally {
			close();
		}
		return al;
	}
	
	
	
}
