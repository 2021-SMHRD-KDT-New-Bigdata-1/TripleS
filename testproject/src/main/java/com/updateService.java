package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.WriteDAO;
import com.VO.MemberVO;
import com.VO.WriteVO;

@WebServlet("/updateService")
public class updateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("vo");
		WriteVO writevo = (WriteVO)session.getAttribute("writevo");
		WriteDAO dao = new WriteDAO();
		int cnt = dao.update_board(subject, content, writevo.getArticles_seq());
		System.out.println("ㅇㄴㅇ"+writevo.getArticles_seq());
		System.out.println("2222"+subject);
		System.out.println("1111"+content);
		if (cnt > 0) {
			response.sendRedirect("review_board.jsp");
			System.out.println("업데이트 완료");
		}

		
		
	}

}
