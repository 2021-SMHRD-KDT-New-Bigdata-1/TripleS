package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//이렇게 하고 한번 실행해보세요! 넵
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String adminYN = null;
		
		if (nickname.equals("admin")) {
			adminYN = "Y";
		}else {
			adminYN = "N";
		}
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.join(nickname, password, phone, memberId, adminYN);
		
		if (cnt>0) {
			response.sendRedirect("login_index.html");
		}
	}

}
