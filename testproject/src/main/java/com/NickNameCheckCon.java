package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;

@WebServlet("/NickNameCheckCon")
public class NickNameCheckCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
String data = request.getParameter("nickname");
		
		MemberDAO dao = new MemberDAO();
		boolean check = dao.nicknameCheck(data);
		System.out.println(data);
		PrintWriter out= response.getWriter();
		
		out.print(check);

	}

}
