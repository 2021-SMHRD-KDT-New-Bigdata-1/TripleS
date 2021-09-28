package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MatchingDAO;
import com.VO.MemberVO;
import com.VO.PartiesVO;

@WebServlet("/Matchingmember")
public class Matchingmember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo = null;
		int cnt = 0;
		
		
		HttpSession session = request.getSession();
		vo = (MemberVO)session.getAttribute("vo");
		String memberId = vo.getMemberId();
		String OTT = (String)session.getAttribute("ott");

		System.out.println(memberId);
		
		
		MatchingDAO dao = new MatchingDAO();
		
		String hostId = dao.hostId(OTT);
		System.out.println(OTT);
		
		System.out.println(hostId);
		
		if(hostId==null) {
			cnt = dao.waiting(memberId, OTT);
		} else {
			

			PartiesVO vo2 = dao.member123(hostId);
			System.out.println(vo2.getMember1());
			System.out.println(vo2.getMember2());
			System.out.println(vo2.getMember3());
			
			String member1 = vo2.getMember1();
			String member2 = vo2.getMember2();
			String member3 = vo2.getMember3();
			
			
			if(member1==null) {
				cnt = dao.member1(memberId, hostId);
			} else if(member2==null) {
				cnt = dao.member2(memberId, hostId);
			} else if(member3==null) {
				cnt = dao.member3(memberId, hostId);
			} 
			
		}
		
		
		if(cnt > 0) {
			response.sendRedirect("main_index.html");
		}
		
		
		
	}

}
