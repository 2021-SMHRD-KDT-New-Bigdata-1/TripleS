package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.WriteDAO;
import com.VO.WriteVO;

@WebServlet("/reviewDetailCon.do")
public class reviewDetailCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int seq = Integer.parseInt(request.getParameter("seq"));
		session.setAttribute("seq", seq);
		WriteDAO dao = new WriteDAO();
		WriteVO writevo = dao.subjectList(seq);
		
		
		if (writevo != null) {
			session.setAttribute("writevo", writevo);
			WriteVO cntvo = (WriteVO)session.getAttribute("writevo");
			int cnt = dao.cnt_subject(seq,cntvo.getCnt());
			session.setAttribute("cnt", cnt);
			response.sendRedirect("detail_view.jsp");
			System.out.println("리뷰게시글 불러오기 성공");
		}
		
		
		
	}

}
