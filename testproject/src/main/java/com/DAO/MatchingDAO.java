package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.MemberVO;
import com.VO.PartiesVO;

/*아래 MatchingDAO 클래스는 파티매칭에 관련된 데이터를 조회하기위해 DB의 접근하여 조작하는 클래스이다
 * by 이길환*/
public class MatchingDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 데이터베이스와 연결하는 메소드
	// by 이길환
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
	// 사용했던 객체를 닫아주는 메소드
	// by 이길환
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

	// 파티원으로 파티매칭시 생성된 방이 없을때 대기자로 분류해주는 메소드
	// by 이길환
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

	// 파티장으로 파티매칭을 진행할 경우 새로운 파티방을 생성해주는 메소드
	// by 이길환
	public int parties(String memberId, String OTT, String OTTID, String OTTPW, String Account, String AccountName,
			String Bank) {

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

	// 각 플랫폼별 생성된 파티의 파티원의 자리가 비어있는지 환인해주고 선택적으로 조회해주는 메소드
	// by 이길환
	public String hostId(String OTT) {

		String hostId = "";
		try {
			conn();
			String sql = "select member_id from parties where ott_platform = ? and "
					+ "(member_1 is null or member_2 is null or member_3 is null) and "
					+ "rownum = 1 order by party_seq";
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

	// 파티장의 아이디와 파티원 1,2,3의 아이디를 객체로 반환시켜주는 메소드
	// by 이길환
	public PartiesVO member123(String hostId) {
		PartiesVO vo = null;

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

	// 파티의 1번쨰 자리에 매칭이 완료되면 완료된 상태를 반환해주는 메소드
	// by 이길환
	public int member1(String memberId, String hostId) {

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

	// 파티의 2번쨰 자리에 매칭이 완료되면 완료된 상태를 반환해주는 메소드
	// by 이길환
	public int member2(String memberId, String hostId) {

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

	// 파티의 3번쨰 자리에 매칭이 완료되면 완료된 상태를 반환해주는 메소드
	// by 이길환
	public int member3(String memberId, String hostId) {

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

	// 플랫폼에 맞게 가장 먼저 대기하고있던 대기자를 선발해주는 메소드
	// by 이길환
	public ArrayList<String> member_check(String OTT) {

		ArrayList<String> members = new ArrayList<>();
		try {
			conn();
			String sql = "SELECT member_id FROM waiting WHERE ott_platform = ? and "
					+ "ROWNUM <= 4 order by waiting_seq";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, OTT);

			rs = psmt.executeQuery();

			while (rs.next()) {
				members.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return members;
	}

	// 파티가 생성되어서 대기자들이 자동매칭되어 대기테이블에서 제거해주는 메소드
	// by 이길환
	public int delete_member1(String member1) {
		int cnt = 0;
		try {
			conn();
			String sql = "delete from waiting where member_id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member1);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 파티가 생성되어서 대기자들이 자동매칭되어 대기테이블에서 제거해주는 메소드(2명의 대기자 제거)
	// by 이길환
	public int delete_member2(String member1, String member2) {
		int cnt = 0;
		try {
			conn();
			String sql = "delete from waiting where member_id in(?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member1);
			psmt.setString(2, member2);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 파티가 생성되어서 대기자들이 자동매칭되어 대기테이블에서 제거해주는 메소드(3명의 대기자 제거)
	// by 이길환
	public int delete_member3(String member1, String member2, String member3) {
		int cnt = 0;
		try {
			conn();
			String sql = "delete from waiting where member_id in (?,?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member1);
			psmt.setString(2, member2);
			psmt.setString(3, member3);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 파티가 생성되면서 대기 테이블에서 대기중이던 1명의 파티원이 자동으로 매칭되어 공석을 채워주는 역할을 하는 메소드
	// 이길환
	public int change_member1(String member1, String memberId) {

		int cnt = 0;
		try {
			conn();
			String sql = "update parties set member_1 = ? where member_id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member1);
			psmt.setString(2, memberId);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;

	}

	// 파티가 생성되면서 대기 테이블에서 대기중이던 2명의 파티원들이 자동으로 매칭되어 공석을 채워주는 역할을 하는 메소드
	// 이길환
	public int change_member2(String member1, String member2, String memberId) {

		int cnt = 0;
		try {
			conn();
			String sql = "update parties set member_1 = ?, member_2 = ? where member_id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member1);
			psmt.setString(2, member2);
			psmt.setString(3, memberId);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;

	}

	// 파티가 생성되면서 대기 테이블에서 대기중이던 3명의 파티원들이 자동으로 매칭되어 공석을 채워주는 역할을 하는 메소드
	// 이길환
	public int change_member3(String member1, String member2, String member3, String memberId) {

		int cnt = 0;
		try {
			conn();
			String sql = "update parties set member_1 = ?, member_2 = ?, member_3 = ? where member_id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member1);
			psmt.setString(2, member2);
			psmt.setString(3, member3);
			psmt.setString(4, memberId);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;

	}

}
