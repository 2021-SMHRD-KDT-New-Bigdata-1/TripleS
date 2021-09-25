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

@WebServlet("/Matchingmember")
public class Matchingmember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo = null;
		
		
		HttpSession session = request.getSession();
		vo = (MemberVO)session.getAttribute("vo");
		String memberId = vo.getMemberId();
		String OTT = (String)session.getAttribute("ott");

		System.out.println(memberId);
		
		MatchingDAO dao = new MatchingDAO();
		int cnt = dao.waiting(memberId, OTT);
		
		if(cnt > 0) {
			response.sendRedirect("main_index.html");
		}
		
		
		
	}

}
