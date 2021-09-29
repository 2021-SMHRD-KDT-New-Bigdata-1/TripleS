package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MatchingDAO;
import com.VO.MemberVO;

@WebServlet("/MatchingWatcha")
public class MatchingWatcha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		MemberVO vo = null;
		
		String ottid = request.getParameter("ottid");
		String ottpw = request.getParameter("ottpw");
		String bank = request.getParameter("bank");
		String account = request.getParameter("account");
		String accountname = request.getParameter("accountname");
		String member1 = null;
		String member2 = null;
		String member3 = null;
		int cnt = 0;
		
		HttpSession session = request.getSession();
		vo = (MemberVO)session.getAttribute("vo");
		String memberId = vo.getMemberId();
		String OTT = (String)session.getAttribute("ott");
		
		
		MatchingDAO dao = new MatchingDAO();
		cnt = dao.parties(memberId, OTT, ottid, ottpw, account, accountname, bank);
		ArrayList<String> members = dao.member_check(OTT);
		
		
		if (members.size() == 0) {
		} else if(members.size() == 1) {
			member1 = members.get(0);
			cnt = dao.delete_member1(member1);
			cnt = dao.change_member1(member1, memberId);
		} else if(members.size() == 2) {
			member1 = members.get(0);
			member2 = members.get(1);
			cnt = dao.delete_member2(member1, member2);
			cnt = dao.change_member2(member1, member2, memberId);
		} else if (members.size() == 3) {
			member1 = members.get(0);
			member2 = members.get(1);
			member3 = members.get(2);
			cnt = dao.delete_member3(member1, member2, member3);
			cnt = dao.change_member3(member1, member2, member3, memberId);
		}
		
		if(cnt > 0) {
			response.sendRedirect("success_host.html");
		} 
		
	}

}
