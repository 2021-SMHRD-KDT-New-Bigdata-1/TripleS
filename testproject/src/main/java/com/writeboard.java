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

@WebServlet("/writeboard")
public class writeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("euc-kr");
		
		String subject = request.getParameter("subject");
		String content= request.getParameter("content");
		String img_pic1= request.getParameter("img_pic1");
		String img_pic2= request.getParameter("img_pic2");
		String img_pic3= request.getParameter("img_pic3");
		


		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		String memberId = vo.getMemberId();
		String nickname = vo.getNickname();

		WriteDAO dao = new WriteDAO();
		
		int cnt = dao.write(subject, content, img_pic1, img_pic2, img_pic3,memberId, nickname);
		
		if (cnt>0) {
			
			WriteVO vo2 = dao.view(subject);
			
			if(vo!=null) {
			
				session.setAttribute("vo2", vo2);
				response.sendRedirect("view_board.jsp");
				System.out.println("글 작성 성공");;
				
			}
			
			
	
		}
		
		
		
		
		
		
		
	}

}
