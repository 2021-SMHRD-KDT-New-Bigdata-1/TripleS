package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.Write4DAO;
import com.VO.Write4VO;
import com.VO.WriteVO;

@WebServlet("/noticeDetailCon.do")
public class noticeDetailCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int seq = Integer.parseInt(request.getParameter("seq"));
		session.setAttribute("seq", seq);
		Write4DAO dao = new Write4DAO();
		Write4VO write4vo = dao.subjectList(seq);
		
		
		if (write4vo != null) {
			session.setAttribute("write4vo", write4vo);
			Write4VO cntvo = (Write4VO)session.getAttribute("write4vo");
			int cnt = dao.cnt_subject(seq,cntvo.getCnt());
			session.setAttribute("cnt", cnt);
			response.sendRedirect("detail_view4.jsp");
			System.out.println("리뷰게시글 불러오기 성공");
		}

		
		
		
		
		
	}

}
