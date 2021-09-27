package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.replyDAO;
import com.VO.MemberVO;

@WebServlet("/replyboard")
public class replyboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String reply_comment = request.getParameter("reply");
		
		System.out.println(reply_comment);
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		String memberId = vo.getMemberId();
		
		replyDAO dao = new replyDAO();
		
		int cnt = dao.reply(reply_comment, memberId);
		
		if (cnt>0) {
			response.sendRedirect("view_board.jsp");
			System.out.println("댓글 작성 성공");
			
		}
	}

}
