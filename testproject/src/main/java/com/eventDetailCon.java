package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.Write3DAO;
import com.VO.Write3VO;

@WebServlet("/eventDetailCon.do")
public class eventDetailCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int seq = Integer.parseInt(request.getParameter("seq"));
		System.out.println("seq : "+seq);
		session.setAttribute("seq", seq);
		Write3DAO dao = new Write3DAO();
		Write3VO write3vo = dao.subjectList(seq);
		
		if (write3vo != null) {
			session.setAttribute("write3vo", write3vo);
			Write3VO cntvo = (Write3VO)session.getAttribute("write3vo");
			int cnt = dao.cnt_subject(seq,cntvo.getCnt());
			session.setAttribute("cnt", cnt);
			response.sendRedirect("event_view.jsp");
			System.out.println("리뷰게시글 불러오기 성공");
		}

		
		
		
		
		
	}

}
