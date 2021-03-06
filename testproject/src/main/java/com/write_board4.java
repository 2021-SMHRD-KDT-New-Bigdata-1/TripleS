package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.Write4DAO;
import com.VO.MemberVO;
import com.VO.Write4VO;

@WebServlet("/write_board4")
public class write_board4 extends HttpServlet {
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

	
		Write4DAO dao = new Write4DAO();
			int cnt = dao.write(subject, content, img_pic1, img_pic2, img_pic3,memberId, nickname);
		
		if (cnt>0) {
			
			Write4VO vo2 = dao.view(subject);
			
			if(vo!=null) {
			
				session.setAttribute("vo2", vo2);
				response.sendRedirect("notice_board.jsp");
				System.out.println("글 작성 성공");;
				
			}
			
			
	
		}
		
		
		
		
		
	}
	

}
