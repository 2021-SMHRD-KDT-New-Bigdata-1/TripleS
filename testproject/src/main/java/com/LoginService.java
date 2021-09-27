package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MemberDAO;
import com.VO.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.login(memberId,password);
		
		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			System.out.println("로그인 성공!");
			
			response.sendRedirect("main_index.html");
		}else {
			System.out.println("로그인 실패!");
			response.sendRedirect("login.jsp");
			
		}
	}

}
