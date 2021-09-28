package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;

@WebServlet("/FindPwService")
public class FindPwService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String memberId = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberDAO dao = new MemberDAO();
		
		String pw = dao.findPw(memberId, phone);
		
		PrintWriter out= response.getWriter();
		
		out.print(pw);
	}

}
