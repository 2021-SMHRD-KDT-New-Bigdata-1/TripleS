package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MatchingDAO;
import com.VO.MemberVO;

@WebServlet("/MatchingWavve")
public class MatchingWavve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		MemberVO vo = null;
		
		String ottid = request.getParameter("ottid");
		String ottpw = request.getParameter("ottpw");
		String bank = request.getParameter("bank");
		String account = request.getParameter("account");
		String accountname = request.getParameter("accountname");
		
		HttpSession session = request.getSession();
		vo = (MemberVO)session.getAttribute("vo");
		String memberId = vo.getMemberId();
		String OTT = (String)session.getAttribute("ott");
		
		
		MatchingDAO dao = new MatchingDAO();
		int cnt = dao.parties(memberId, OTT, ottid, ottpw, account, accountname, bank);
		
		if(cnt > 0) {
			response.sendRedirect("main_index.html");
		}
		
		
	}

}
