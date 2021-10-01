package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.replyDAO;
import com.DAO.write2DAO;
import com.VO.MemberVO;
import com.VO.Write2VO;
import com.VO.WriteVO;

@WebServlet("/commuDetailCon.do")
public class commuDetailCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int seq = Integer.parseInt(request.getParameter("seq1"));
		session.setAttribute("seq1", seq);
		write2DAO dao = new write2DAO();
		Write2VO write2vo = dao.subjectList(seq);
		
		if (write2vo != null) {
			session.setAttribute("write2vo", write2vo);
			response.sendRedirect("detail_view2.jsp");
			System.out.println("리뷰게시글 불러오기 성공");
		}


		
		
	}

}
