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
import com.VO.Write2VO;
import com.VO.Write4VO;

@WebServlet("/articlecommentcon4")
public class articlecommentcon4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("reply");
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("vo");
		String memberId = mvo.getMemberId();
		String nickname = mvo.getNickname();
		Write4VO write4vo = (Write4VO)session.getAttribute("Write4vo");
		System.out.println("writevo 불러오");
		int seq = (int)session.getAttribute("seq");
		System.out.println("seq는 :"+seq);
		replyDAO rdao = new replyDAO();
		int cnt = rdao.insert(seq, comment, memberId, "0",nickname,"QA");
		
		if (cnt > 0) {
			response.sendRedirect("detail_view4.jsp");
			System.out.println("댓글 작성 성공");
		}

		
		
		
		
		
		
	}

}
